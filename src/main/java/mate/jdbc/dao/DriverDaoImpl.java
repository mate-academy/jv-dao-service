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
import mate.jdbc.model.Driver;
import mate.jdbc.util.ConnectionUtil;

@Dao
public class DriverDaoImpl implements DriverDao {
    @Override
    public Driver create(Driver driver) {
        String query = "INSERT INTO drivers(name, licenseNumber) VALUE(?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement createDriver =
                        connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            createDriver.setString(1, driver.getName());
            createDriver.setString(2, driver.getLicenseNumber());
            createDriver.executeUpdate();
            ResultSet generatedKeys = createDriver.getGeneratedKeys();
            if (generatedKeys.next()) {
                Long id = generatedKeys.getObject(1, Long.class);
                driver.setId(id);
            }
            return driver;
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't create driver. " + driver, e);
        }
    }

    @Override
    public Optional<Driver> get(Long id) {
        String query = "SELECT * FROM drivers" + " WHERE id = ? AND is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getDriver =
                        connection.prepareStatement(query)) {
            getDriver.setLong(1, id);
            ResultSet resultSet = getDriver.executeQuery();
            Driver driver = null;
            if (resultSet.next()) {
                driver = getDriver(resultSet);
            }
            return Optional.ofNullable(driver);
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't get driver by id " + id, e);
        }
    }

    @Override
    public List<Driver> getAll() {
        String query = "SELECT * FROM drivers WHERE is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getAllDrivers =
                        connection.prepareStatement(query)) {
            List<Driver> driverList = new ArrayList<>();
            ResultSet resultSet = getAllDrivers.executeQuery();
            while (resultSet.next()) {
                driverList.add(getDriver(resultSet));
            }
            return driverList;
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't get a list of drivers "
                    + "from drivers table.", e);
        }
    }

    @Override
    public Driver update(Driver driver) {
        String query = "UPDATE drivers SET name = ?, licenseNumber = ? "
                + "WHERE id = ? AND is_deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement updateDriver =
                        connection.prepareStatement(query)) {
            updateDriver.setString(1, driver.getName());
            updateDriver.setString(2, driver.getLicenseNumber());
            updateDriver.setLong(1, driver.getId());
            updateDriver.executeUpdate();
            return driver;
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't update a driver " + driver, e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String query = "UPDATE drivers SET is_deleted = TRUE WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement deleteDriver =
                        connection.prepareStatement(query)) {
            deleteDriver.setLong(1, id);
            return deleteDriver.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't delete a driver by id " + id, e);
        }
    }

    private Driver getDriver(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getObject("id", Long.class);
        String name = resultSet.getString("name");
        String licenseNumber = resultSet.getString("licenseNumber");
        return new Driver(id, name, licenseNumber);
    }
}
