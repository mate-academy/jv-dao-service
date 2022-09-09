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
        String createQuery = "INSERT INTO driver(name,license_number) values (?,?);";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(createQuery,
                     Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, driver.getName());
            preparedStatement.setString(2, driver.getLicenseNumber());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Long id = generatedKeys.getObject(1, Long.class);
                driver.setId(id);
            }
            return driver;
        } catch (SQLException throwables) {
            throw new DataProcessingException("Can`t create Driver in DB " + driver, throwables);
        }
    }

    @Override
    public Optional<Driver> get(Long id) {
        String queryFindById = "SELECT * FROM driver WHERE id = ?" +
                " AND is_deleted = false;";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(queryFindById)) {
            preparedStatement.setObject(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(getDriverFromDb(resultSet));
            }
        } catch (SQLException throwables) {
            throw new DataProcessingException("Can`t find Driver by id: " + id, throwables);
        }
        return Optional.empty();
    }

    @Override
    public List<Driver> getAll() {
        List<Driver> drivers = new ArrayList<>();
        String query = "SELECT * FROM driver"
                + " WHERE is_deleted = false;";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                drivers.add(getDriverFromDb(resultSet));
            }
            return drivers;
        } catch (SQLException throwables) {
            throw new DataProcessingException("Can`t get drivers drivers from db", throwables);
        }
    }

    @Override
    public Driver update(Driver driver) {
        String queryForUpdate = "UPDATE driver SET name = ?, license_number = ?"
                + "WHERE id = ? AND is_deleted = false;";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(queryForUpdate)) {
            preparedStatement.setObject(1, driver.getName());
            preparedStatement.setObject(2, driver.getLicenseNumber());
            preparedStatement.setObject(3, driver.getId());
            preparedStatement.executeUpdate();
            return driver;
        } catch (SQLException throwables) {
            throw new DataProcessingException("Can`t make update with " + driver, throwables);
        }
    }

    @Override
    public boolean delete(Long id) {
        String queryForDelete = "UPDATE driver SET is_deleted = true"
                + " WHERE id = ? AND is_deleted = false;";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(queryForDelete)) {
            preparedStatement.setObject(1, id);
            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException throwables) {
            throw new DataProcessingException("Can`t delete driver by id:" + id, throwables);
        }
    }

    private Driver getDriverFromDb(ResultSet resultSet) throws SQLException {
        return new Driver(resultSet.getObject("id", Long.class),
                resultSet.getString("name"),
                resultSet.getString("license_number"));
    }
}
