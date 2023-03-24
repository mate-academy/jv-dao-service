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
        String insertDriverRequest = "INSERT INTO drivers(name, license_number) VALUES(?, ?);";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement createDriverStatement =
                        connection.prepareStatement(insertDriverRequest,
                             Statement.RETURN_GENERATED_KEYS)) {
            createDriverStatement.setString(1, driver.getName());
            createDriverStatement.setString(2, driver.getLicenseNumber());
            createDriverStatement.executeUpdate();
            ResultSet generatedKeys = createDriverStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Long id = generatedKeys.getObject(1, Long.class);
                driver.setId(id);
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't insert driver to DataBase: "
                    + driver, e);
        }
        return driver;
    }

    @Override
    public Optional<Driver> get(Long id) {
        String getDriverRequest =
                "SELECT * FROM drivers WHERE id = ? AND is_deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement getDriverStatement =
                        connection.prepareStatement(getDriverRequest)) {
            getDriverStatement.setLong(1, id);
            ResultSet resultSet = getDriverStatement.executeQuery();
            if (resultSet.next()) {
                Driver driver = parseDriver(resultSet);
                return Optional.of(driver);
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get driver from DataBase by ID: "
                    + id, e);
        }
        return Optional.empty();
    }

    @Override
    public List<Driver> getAll() {
        String getAllDriverRequest = "SELECT * FROM drivers WHERE is_deleted = FALSE;";
        List<Driver> driverList = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement getAllDriversStatement =
                         connection.prepareStatement(getAllDriverRequest)) {
            ResultSet resultSet = getAllDriversStatement.executeQuery();
            while (resultSet.next()) {
                driverList.add(parseDriver(resultSet));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get all drivers from DataBase", e);
        }
        return driverList;
    }

    @Override
    public Driver update(Driver driver) {
        String updateDriverRequest = "UPDATE drivers SET name = ?, license_number = ? "
                + "WHERE id = ? AND is_deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement updateDriverStatement
                         = connection.prepareStatement(updateDriverRequest)) {
            updateDriverStatement.setString(1, driver.getName());
            updateDriverStatement.setString(2, driver.getLicenseNumber());
            updateDriverStatement.setLong(3, driver.getId());
            updateDriverStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't update driver from DB "
                    + driver, e);
        }
        return driver;
    }

    @Override
    public boolean delete(Long id) {
        String deleteDriverRequest =
                "UPDATE drivers SET is_deleted = TRUE WHERE id = ?;";
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement deleteDriverStatement =
                         connection.prepareStatement(deleteDriverRequest,
                             Statement.RETURN_GENERATED_KEYS)) {
            deleteDriverStatement.setLong(1, id);
            return deleteDriverStatement.executeUpdate() >= 1;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete driver from DataBase by ID: "
                    + id, e);
        }
    }

    private Driver parseDriver(ResultSet resultSet) {
        try {
            String name = resultSet.getString("name");
            String country = resultSet.getString("license_number");
            Long id = resultSet.getObject("id", Long.class);
            Driver driver = new Driver();
            driver.setId(id);
            driver.setLicenseNumber(country);
            driver.setName(name);
            return driver;
        } catch (SQLException e) {
            throw new RuntimeException("Can't parse a new driver", e);
        }
    }
}
