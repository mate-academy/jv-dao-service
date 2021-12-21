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
        String insertDriverRequest = "INSERT INTO drivers(name,licenseNumber) values(?,?);";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement createDriversStatement =
                        connection.prepareStatement(insertDriverRequest,
                                Statement.RETURN_GENERATED_KEYS)) {
            createDriversStatement.setString(1, driver.getName());
            createDriversStatement.setString(2, driver.getLicenseNumber());
            createDriversStatement.executeUpdate();
            ResultSet generateKeys = createDriversStatement.getGeneratedKeys();
            if (generateKeys.next()) {
                Long id = generateKeys.getObject(1,Long.class);
                driver.setId(id);
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't insert driver to DB "
                    + driver, e);
        }
        return driver;
    }

    @Override
    public Optional<Driver> get(Long id) {
        String getRequest = "SELECT * FROM drivers WHERE id = ? AND is_deleted = false;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getDriversStatement =
                        connection.prepareStatement(getRequest)) {
            getDriversStatement.setLong(1, id);
            ResultSet resultSet = getDriversStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(getDriverByResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get driver: id="
                    + id + " from DB", e);
        }
        return Optional.empty();
    }

    @Override
    public List<Driver> getAll() {
        List<Driver> allDrivers = new ArrayList<>();

        try (Connection connection = ConnectionUtil.getConnection();
                Statement getAllDriversStatement = connection.createStatement()) {
            ResultSet resultSet = getAllDriversStatement
                    .executeQuery("SELECT * FROM drivers WHERE is_deleted = false;");
            while (resultSet.next()) {
                allDrivers.add(getDriverByResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get all drivers from DB", e);
        }
        return allDrivers;
    }

    @Override
    public Driver update(Driver driver) {
        String updateRequest = "UPDATE drivers SET name = ?, "
                + "licenseNumber = ? WHERE id = ? AND is_deleted = false;";
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement updateDriverStatement =
                        connection.prepareStatement(updateRequest)) {
            updateDriverStatement.setLong(3, driver.getId());
            updateDriverStatement.setString(1, driver.getName());
            updateDriverStatement.setString(2, driver.getLicenseNumber());
            updateDriverStatement.executeUpdate();
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't update driver in DB", e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String deleteRequest = "UPDATE drivers SET is_deleted = true WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement deleteDriverStatement =
                        connection.prepareStatement(deleteRequest,
                             Statement.RETURN_GENERATED_KEYS)) {
            deleteDriverStatement.setLong(1, id);
            return deleteDriverStatement.executeUpdate() >= 1;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete driver from DB with id "
                    + id, e);
        }
    }

    private Driver getDriverByResultSet(ResultSet resultSet) {
        try {
            String name = resultSet.getString("name");
            String licenseNumber = resultSet.getString("licenseNumber");
            Driver driver = new Driver(name, licenseNumber);
            Long id = resultSet.getObject(1, Long.class);
            driver.setId(id);
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Can`t get driver by ResultSet", e);
        }
    }

}
