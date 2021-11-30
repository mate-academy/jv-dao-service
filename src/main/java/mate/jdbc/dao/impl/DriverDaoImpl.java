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
import mate.jdbc.lib.Dao;
import mate.jdbc.lib.exception.DataProcessingException;
import mate.jdbc.model.Driver;
import mate.jdbc.util.ConnectionUtil;

@Dao
public class DriverDaoImpl implements DriverDao {
    @Override
    public Driver create(Driver driver) {
        String query = "INSERT INTO drivers (name, license_number) "
                + "VALUES (?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement createDriverStatement =
                        connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            createDriverStatement.setString(1, driver.getName());
            createDriverStatement.setString(2, driver.getLicenseNumber());
            createDriverStatement.executeUpdate();
            ResultSet resultSet = createDriverStatement.getGeneratedKeys();
            if (resultSet.next()) {
                driver.setId(resultSet.getObject(1, Long.class));
            }
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't create driver. " + driver + "; ",
                    e);
        }
    }

    @Override
    public Optional<Driver> get(Long id) {
        String query = "SELECT * FROM drivers WHERE id = ?, is_deleted = false";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getDriverStatement = connection.prepareStatement(query)) {
            getDriverStatement.setLong(1, id);
            ResultSet resultSet = getDriverStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.ofNullable(getDriver(resultSet));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't get driver by id " + id + " ", e);
        }
        return Optional.empty();
    }

    @Override
    public List<Driver> getAll() {
        List<Driver> driversList = new ArrayList<>();
        String query = "SELECT * FROM drivers WHERE is_deleted = false";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getAllStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = getAllStatement.executeQuery();
            while (resultSet.next()) {
                driversList.add(getDriver(resultSet));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't get all drivers from db", e);
        }
        return driversList;
    }

    @Override
    public Driver update(Driver driver) {
        String query = "UPDATE drivers SET name = ?, license_number = ?"
                + " WHERE id = ? AND is_deleted = false";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement updateStatement = connection.prepareStatement(query)) {
            updateStatement.setString(1, driver.getName());
            updateStatement.setString(2, driver.getLicenseNumber());
            updateStatement.setLong(3, driver.getId());
            updateStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't update this driver: " + driver, e);
        }
        return driver;
    }

    @Override
    public boolean delete(Long id) {
        String query = "UPDATE drivers SET is_deleted = TRUE WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement deleteStatement =
                        connection.prepareStatement(query)) {
            deleteStatement.setLong(1, id);
            return deleteStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't delete a driver by id " + id + " ",
                    e);
        }
    }

    private Driver getDriver(ResultSet resultSet) throws SQLException {
        Driver driver = new Driver();
        driver.setId(resultSet.getObject(1, Long.class));
        driver.setName(resultSet.getString(2));
        driver.setLicenseNumber(resultSet.getString(3));
        return driver;
    }
}
