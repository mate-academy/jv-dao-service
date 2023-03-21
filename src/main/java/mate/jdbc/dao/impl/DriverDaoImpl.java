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
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO drivers(name, license_number) VALUES(?, ?);",
                        Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, driver.getName());
            preparedStatement.setString(2, driver.getLicenseNumber());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Long id = generatedKeys.getObject(1, Long.class);
                driver.setId(id);
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't add to DB: " + driver, e);
        }
        return driver;
    }

    @Override
    public Optional<Driver> get(Long id) {
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM drivers WHERE is_deleted = FALSE AND id = ?")) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(createDriverFromInput(resultSet));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get driver by id: " + id, e);
        }
        return Optional.empty();
    }

    @Override
    public List<Driver> getAll() {
        List<Driver> drivers = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT * FROM drivers WHERE is_deleted = FALSE;")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                drivers.add(createDriverFromInput(resultSet));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get list of drivers", e);
        }
        return drivers;
    }

    @Override
    public Driver update(Driver driver) {
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "UPDATE drivers SET name = ?, license_number = ?"
                             + " WHERE id = ? AND is_deleted = FALSE;")) {
            preparedStatement.setString(1, driver.getName());
            preparedStatement.setString(2, driver.getLicenseNumber());
            preparedStatement.setLong(3, driver.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't update information for " + driver, e);
        }
        return driver;
    }

    @Override
    public boolean delete(Long id) {
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "UPDATE drivers SET is_deleted = TRUE"
                             + " WHERE id = ? AND is_deleted = FALSE;")) {
            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete driver by id: " + id, e);
        }
    }

    private Driver createDriverFromInput(ResultSet resultSet) throws SQLException {
        Long driverId = resultSet.getObject("id", Long.class);
        String name = resultSet.getString("name");
        String licenseNumber = resultSet.getString("license_number");
        return new Driver(driverId, name, licenseNumber);
    }
}
