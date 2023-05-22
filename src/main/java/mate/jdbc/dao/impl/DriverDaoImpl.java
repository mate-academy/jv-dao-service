package mate.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import mate.jdbc.dao.DriverDao;
import mate.jdbc.exception.DataProcessingException;
import mate.jdbc.lib.Dao;
import mate.jdbc.model.Driver;
import mate.jdbc.util.ConnectionUtil;

@Dao
public class DriverDaoImpl implements DriverDao {
    @Override
    public Driver create(Driver driver) {
        String insertDriverRequest = "INSERT INTO drivers(name, licenseNumber)"
                + " VALUES (?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement createDriverStatements =
                        connection.prepareStatement(insertDriverRequest,
                                Statement.RETURN_GENERATED_KEYS)) {
            createDriverStatements.setString(1,driver.getName());
            createDriverStatements.setString(2, driver.getLicenseNumber());
            createDriverStatements.executeUpdate();
            ResultSet generatedKeys = createDriverStatements.getGeneratedKeys();
            if (generatedKeys.next()) {
                driver.setId(generatedKeys.getObject(1, Long.class));
            }
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Could not create driver." + driver, e);
        }
    }

    @Override
    public Optional<Driver> get(Long id) {
        String getDriverRequest = "SELECT * FROM drivers "
                + "WHERE id = ? AND is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getDriverStatement =
                        connection.prepareStatement(getDriverRequest)) {
            getDriverStatement.setObject(1,id);
            ResultSet resultSet = getDriverStatement.executeQuery();
            Driver driver = null;
            if (resultSet.next()) {
                driver = getDriver(resultSet);
            }
            return Optional.ofNullable(driver);
        } catch (SQLException e) {
            throw new DataProcessingException("Could not get driver by id " + id, e);
        }
    }

    @Override
    public List<Driver> getAll() {
        List<Driver> allDrivers = new ArrayList<>();
        String getAllDriversRequest = "SELECT * FROM drivers "
                + "WHERE is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getAllDriversStatement =
                        connection.prepareStatement(getAllDriversRequest)) {
            ResultSet resultSet = getAllDriversStatement.executeQuery();
            while (resultSet.next()) {
                allDrivers.add(getDriver(resultSet));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Could not get a list of drivers "
                    + "from drivers table.", e);
        }
        return allDrivers;
    }

    @Override
    public Driver update(Driver driver) {
        String updateDriverRequest = "UPDATE drivers SET name = ?, licenseNumber = ? "
                + "WHERE id = ? AND is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement updateDriverStatement =
                        connection.prepareStatement(updateDriverRequest)) {
            updateDriverStatement.setString(1,driver.getName());
            updateDriverStatement.setString(2,driver.getLicenseNumber());
            updateDriverStatement.setObject(3,driver.getId());
            updateDriverStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DataProcessingException("Could not update driver." + driver, e);
        }
        return driver;
    }

    @Override
    public boolean delete(Long id) {
        String deleteDriverRequest = "UPDATE drivers "
                + "SET is_deleted = TRUE WHERE id = ?;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement deleteDriverStatement =
                        connection.prepareStatement(deleteDriverRequest)) {
            deleteDriverStatement.setObject(1,id);
            return deleteDriverStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DataProcessingException("Could not delete driver by id " + id, e);
        }
    }

    private Driver getDriver(ResultSet resultSet) {
        Driver driver = new Driver();
        try {
            driver.setId(resultSet.getObject(1, Long.class));
            driver.setName(resultSet.getString("name"));
            driver.setLicenseNumber(resultSet.getString("licenseNumber"));
        } catch (SQLException e) {
            throw new DataProcessingException("Could not get driver from resultSet", e);
        }
        return driver;
    }
}
