package mate.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import mate.jdbc.exception.DataProcessingException;
import mate.jdbc.lib.Dao;
import mate.jdbc.model.Driver;
import mate.jdbc.util.ConnectionUtil;

@Dao
public class DriverDaoImpl implements DriverDao {
    @Override
    public Driver create(Driver driver) {
        String createDriver = "INSERT INTO drivers (name, license_number) "
                + "values(?, ?);";
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement createStatement =
                         connection.prepareStatement(createDriver,
                                Statement.RETURN_GENERATED_KEYS)) {
            createStatement.setString(1, driver.getName());
            createStatement.setString(2, driver.getLicenseNumber());
            createStatement.executeUpdate();
            ResultSet generatedKeys = createStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                driver.setId(generatedKeys.getObject(1, Long.class));
            }
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't insert driver to DB"
                    + driver, e);
        }
    }

    @Override
    public Optional<Driver> get(Long id) {
        String get = "SELECT * FROM drivers WHERE is_deleted = FALSE AND id = ?;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getStatement = connection.prepareStatement(get)) {
            getStatement.setLong(1, id);
            ResultSet resultSet = getStatement.executeQuery();
            Driver driver = null;
            if (resultSet.next()) {
                driver = getDriver(resultSet);
            }
            return Optional.ofNullable(driver);
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get driver from DB with id="
                    + id, e);
        }
    }

    @Override
    public List<Driver> getAll() {
        String selectAll = "SELECT * FROM drivers WHERE is_deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement getAllStatement = connection.prepareStatement(selectAll)) {
            List<Driver> driverList = new ArrayList<>();
            ResultSet resultSet = getAllStatement.executeQuery();
            while (resultSet.next()) {
                driverList.add(getDriver(resultSet));
            }
            return driverList;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't read all information from DB", e);
        }
    }

    @Override
    public Driver update(Driver driver) {
        String update = "UPDATE drivers SET name = ?, license_number = ?"
                + " WHERE id = ? AND is_deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement updateStatement = connection.prepareStatement(update)) {
            updateStatement.setString(1, driver.getName());
            updateStatement.setString(2, driver.getLicenseNumber());
            updateStatement.setLong(3, driver.getId());
            updateStatement.executeUpdate();
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't update driver from DB"
                    + driver, e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String delete = "UPDATE drivers SET is_deleted = TRUE WHERE id = ?;";
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement deleteStatement = connection.prepareStatement(delete)) {
            deleteStatement.setLong(1, id);
            return deleteStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete driver from DB with id= "
                    + id, e);
        }
    }

    private Driver getDriver(ResultSet resultSet) {
        try {
            Long id = resultSet.getObject("id", Long.class);
            String name = resultSet.getString("name");
            String licenseNumber = resultSet.getString("license_number");
            return new Driver(id, name, licenseNumber);
        } catch (SQLException e) {
            throw new DataProcessingException("Can't read driver from DB", e);
        }
    }
}
