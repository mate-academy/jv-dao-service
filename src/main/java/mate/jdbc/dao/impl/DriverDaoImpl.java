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
    private static final String TABLE = "drivers";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_LICENSE = "licenseNumber";
    private static final String COLUMN_IS_DELETED = "is_deleted";

    @Override
    public Driver create(Driver driver) {
        String query = "INSERT INTO " + TABLE + " (" + COLUMN_NAME + ", "
                + COLUMN_LICENSE + ") VALUES (?,?)";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement createDriversStatement =
                        connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            createDriversStatement.setString(1, driver.getName());
            createDriversStatement.setString(2, driver.getLicenseNumber());
            createDriversStatement.executeUpdate();
            ResultSet generatedKeys = createDriversStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                driver.setId(generatedKeys.getObject(1, Long.class));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't create the driver " + driver, e);
        }
        return driver;
    }

    @Override
    public Optional<Driver> get(Long id) {
        String query = "SELECT * FROM " + TABLE + " WHERE id = ? AND "
                + COLUMN_IS_DELETED + " = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getDriverStatement = connection.prepareStatement(query)) {
            getDriverStatement.setLong(1, id);
            ResultSet driverResult = getDriverStatement.executeQuery();
            if (driverResult.next()) {
                return Optional.of(getDriver(driverResult));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't get the driver with id " + id, e);
        }
        return Optional.empty();
    }

    @Override
    public List<Driver> getAll() {
        List<Driver> drivers = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE + " WHERE " + COLUMN_IS_DELETED + " = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getAllDriversStatement = connection.prepareStatement(query)) {
            ResultSet driversSet = getAllDriversStatement.executeQuery();
            while (driversSet.next()) {
                drivers.add(getDriver(driversSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return drivers;
    }

    @Override
    public Driver update(Driver driver) {
        String query = "UPDATE " + TABLE + " SET " + COLUMN_NAME + " = ?, "
                + COLUMN_LICENSE + " = ? WHERE id = ? AND " + COLUMN_IS_DELETED + " = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement updateDriverStatement = connection.prepareStatement(query)) {
            updateDriverStatement.setString(1, driver.getName());
            updateDriverStatement.setString(2, driver.getLicenseNumber());
            updateDriverStatement.setLong(3, driver.getId());
            updateDriverStatement.executeUpdate();
            return driver;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String query = "UPDATE " + TABLE + " SET " + COLUMN_IS_DELETED + " = TRUE WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement deleteDriverStatement = connection.prepareStatement(query)) {
            deleteDriverStatement.setLong(1, id);
            return deleteDriverStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Driver getDriver(ResultSet resultSet) throws SQLException {
        Driver driver = new Driver();
        driver.setId(resultSet.getObject(1, Long.class));
        driver.setName(resultSet.getString(COLUMN_NAME));
        driver.setLicenseNumber(resultSet.getString(COLUMN_LICENSE));
        return driver;
    }
}
