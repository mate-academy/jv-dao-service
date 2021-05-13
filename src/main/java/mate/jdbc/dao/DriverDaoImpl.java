package mate.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import mate.jdbc.lib.Dao;
import mate.jdbc.lib.exception.DataProcessingException;
import mate.jdbc.model.Driver;
import mate.jdbc.util.ConnectionUtil;

@Dao
public class DriverDaoImpl implements DriverDao {
    @Override
    public Driver create(Driver driver) {
        String createRequest = "INSERT INTO drivers(name, license_number) VALUES(?, ?);";
        try (Connection connection = ConnectionUtil.getDriversConnection();
                PreparedStatement preparedStatement = connection
                        .prepareStatement(createRequest, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, driver.getName());
            preparedStatement.setString(2, driver.getLicenseNumber());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                driver.setId(resultSet.getObject(1, Long.class));
            }
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't add driver: " + driver + " to the DB", e);
        }
    }
    
    @Override
    public Optional<Driver> get(Long id) {
        String getDriverRequest = "SELECT * FROM drivers WHERE id = ? AND deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getDriversConnection();
                PreparedStatement preparedStatement = connection
                        .prepareStatement(getDriverRequest)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Driver driver = null;
            while (resultSet.next()) {
                driver = getDriver(resultSet);
            }
            return Optional.ofNullable(driver);
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get driver by specified ID: " + id, e);
        }
    }
    
    @Override
    public List<Driver> getAll() {
        String getDriverRequest = "SELECT * FROM drivers WHERE deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getDriversConnection();
                Statement preparedStatement = connection.createStatement()) {
            ResultSet resultSet = preparedStatement.executeQuery(getDriverRequest);
            List<Driver> driverList = new ArrayList<>();
            while (resultSet.next()) {
                driverList.add(getDriver(resultSet));
            }
            return driverList;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get all drivers from DB", e);
        }
    }
    
    @Override
    public Driver update(Driver driver) {
        String createRequest = "UPDATE drivers SET name = ?, license_number = ? WHERE id = ? "
                + "AND deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getDriversConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(createRequest)) {
            preparedStatement.setString(1, driver.getName());
            preparedStatement.setString(2, driver.getLicenseNumber());
            preparedStatement.setLong(3, driver.getId());
            preparedStatement.executeUpdate();
            if (preparedStatement.executeUpdate() > 0) {
                return driver;
            }
            throw new RuntimeException("Can't update nonexistent driver");
        } catch (SQLException e) {
            throw new DataProcessingException(
                    "Can't update driver: " + driver + " by following ID: " + driver.getId(), e);
        }
    }
    
    @Override
    public boolean delete(Long id) {
        String createRequest = "DELETE FROM drivers WHERE id = ? AND deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getDriversConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(createRequest)) {
            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete driver by following ID: " + id, e);
        }
    }
    
    private Driver getDriver(ResultSet resultSet) {
        try {
            Long id = resultSet.getObject(1, Long.class);
            String name = resultSet.getString("name");
            String licenseNumber = resultSet.getString("license_number");
            Driver driver = new Driver();
            driver.setName(name);
            driver.setLicenseNumber(licenseNumber);
            driver.setId(id);
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't create a driver from given resultSet", e);
        }
    }
}
