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
        String query = "INSERT INTO drivers (name, license_number) VALUE(?, ?);";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement driverPreparedStatement =
                        connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            driverPreparedStatement.setString(1, driver.getName());
            driverPreparedStatement.setString(2, driver.getLicenseNumber());
            driverPreparedStatement.executeUpdate();
            ResultSet resultSet = driverPreparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                driver.setId(resultSet.getObject(1, Long.class));
            }
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't create driver in DB: "
                    + driver, e);
        }
    }

    @Override
    public Optional<Driver> get(Long id) {
        String query = "SELECT * FROM drivers WHERE id = ?;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getDriverFromDB = connection.prepareStatement(query)) {
            getDriverFromDB.setLong(1, id);
            ResultSet resultSet = getDriverFromDB.executeQuery();
            if (resultSet.next()) {
                return Optional.of(parseDriver(resultSet));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get driver with id = "
                    + id, e);
        }
        return Optional.empty();
    }

    @Override
    public List<Driver> getAll() {
        String query = "SELECT * FROM drivers WHERE is_deleted = FALSE ;";
        List<Driver> drivers = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection();
                Statement getAllDrivers = connection.createStatement()) {
            ResultSet resultSet = getAllDrivers.executeQuery(query);
            while (resultSet.next()) {
                drivers.add(parseDriver(resultSet));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get all drivers from DB", e);
        }
        return drivers;
    }

    @Override
    public Driver update(Driver driver) {
        String query = "UPDATE drivers SET name = ?, license_number = ? WHERE id = ?;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement updateDriverPreparedStatement =
                        connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            updateDriverPreparedStatement.setString(1, driver.getName());
            updateDriverPreparedStatement.setString(2, driver.getLicenseNumber());
            updateDriverPreparedStatement.setLong(3, driver.getId());
            updateDriverPreparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't update driver: "
                    + driver + " into DB", e);
        }
        return driver;
    }

    @Override
    public boolean delete(Long id) {
        String query = "UPDATE drivers SET is_deleted = true WHERE id = ?;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement deleteDriverPreparedStatement =
                        connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            deleteDriverPreparedStatement.setLong(1, id);
            return deleteDriverPreparedStatement.executeUpdate() >= 1;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete driver from DB where id: "
                    + id, e);
        }
    }

    private Driver parseDriver(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getObject("id", Long.class);
        String name = resultSet.getString("name");
        String licenseNumber = resultSet.getString("license_number");
        return new Driver(id, name, licenseNumber);
    }
}
