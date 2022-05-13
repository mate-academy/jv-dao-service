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
        String query = "INSERT INTO drivers (name, license_number) VALUES (?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement insertDriver = connection.prepareStatement(
                         query, Statement.RETURN_GENERATED_KEYS)) {
            insertDriver.setString(1, driver.getName());
            insertDriver.setString(2, driver.getLicenseNumber());
            insertDriver.executeUpdate();
            ResultSet generatedId = insertDriver.getGeneratedKeys();
            if (generatedId.next()) {
                driver.setId(generatedId.getObject(1, Long.class));
            }
            return driver;
        } catch (SQLException ex) {
            throw new DataProcessingException("Can't insert driver: " + driver, ex);
        }
    }

    @Override
    public Optional<Driver> get(Long id) {
        String query = "SELECT * FROM drivers WHERE id = ? AND is_deleted = false;";
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement selectDriver = connection.prepareStatement(query)) {
            selectDriver.setLong(1, id);
            ResultSet driverSet = selectDriver.executeQuery();
            if (driverSet.next()) {
                return Optional.of(parseResultSet(driverSet));
            }
            return Optional.empty();
        } catch (SQLException ex) {
            throw new DataProcessingException("Can't get driver with id: " + id, ex);
        }
    }

    @Override
    public List<Driver> getAll() {
        String query = "SELECT * FROM drivers WHERE is_deleted = false;";
        List<Driver> drivers = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement selectAllDrivers = connection.prepareStatement(query)) {
            ResultSet driversSet = selectAllDrivers.executeQuery();
            while (driversSet.next()) {
                drivers.add(parseResultSet(driversSet));
            }
            return drivers;
        } catch (SQLException ex) {
            throw new DataProcessingException("Can't get all drivers from database", ex);
        }
    }

    @Override
    public Driver update(Driver driver) {
        String query = "UPDATE drivers SET name = ?, license_number = ?"
                + " WHERE id = ? AND is_deleted = false;";
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, driver.getName());
            statement.setString(2, driver.getLicenseNumber());
            statement.setLong(3, driver.getId());
            statement.executeUpdate();
            return driver;
        } catch (SQLException ex) {
            throw new DataProcessingException("Can't update driver: " + driver, ex);
        }
    }

    @Override
    public boolean delete(Long id) {
        String query = "UPDATE drivers SET is_deleted = true WHERE id = ?;";
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement deleteDriver = connection.prepareStatement(query)) {
            deleteDriver.setLong(1, id);
            return deleteDriver.executeUpdate() > 0;
        } catch (SQLException ex) {
            throw new DataProcessingException("Can't delete driver with id: " + id, ex);
        }
    }

    private Driver parseResultSet(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getObject("id", Long.class);
        String name = resultSet.getString("name");
        String licenseNumber = resultSet.getString("license_number");
        return new Driver(id, name, licenseNumber);
    }
}

