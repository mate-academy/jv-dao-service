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
        String createQuery = "INSERT INTO drivers(name, licence_number) VALUES(?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement statement = connection.
                     prepareStatement(createQuery, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, driver.getName());
            statement.setString(2, driver.getLicenceNumber());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                Long id = resultSet.getObject(1, Long.class);
                driver.setId(id);
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't insert driver to DB: " + driver, e);
        }
        return driver;
    }

    @Override
    public Optional<Driver> get(Long id) {
        String getQuery = "SELECT * FROM drivers " +
                "WHERE id = ? AND is_deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(getQuery)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            Driver driver = null;
            if (resultSet.next()) {
                driver = resultSetToDrivers(resultSet);
            }
            return Optional.ofNullable(driver);
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get driver from DB by id " + id, e);
        }
    }

    @Override
    public List<Driver> getAll() {
        String getAllDriversQuery = "SELECT * FROM drivers WHERE is_deleted = FALSE;";
        List<Driver> allDrivers = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(getAllDriversQuery)) {
            ResultSet resultSet = statement.executeQuery(getAllDriversQuery);
            while (resultSet.next()) {
                allDrivers.add(resultSetToDrivers(resultSet));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get all drivers from DB", e);
        }
        return allDrivers;
    }

    @Override
    public Driver update(Driver driver) {
        Optional<Driver> getDriver = get(driver.getId());
        if (getDriver.isPresent()) {
            String updateQuery = "UPDATE drivers SET name = ?, licence_number = ? " +
                    "WHERE id = ? AND is_deleted = FALSE";
            try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement statement = connection.prepareStatement(updateQuery)) {
                statement.setString(1, driver.getName());
                statement.setString(2, driver.getLicenceNumber());
                statement.setLong(3, driver.getId());
                statement.executeUpdate();
                return driver;
            } catch (SQLException e) {
                throw new DataProcessingException("Can't update driver in DB: " + driver, e);
            }
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        String deleteQuery = "UPDATE drivers SET is_deleted = TRUE WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(deleteQuery)) {
            statement.setLong(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete driver from DB with id " + id, e);
        }
    }

    private Driver resultSetToDrivers(ResultSet resultSet) {
        try {
            Long id = resultSet.getObject("id", Long.class);
            String name = resultSet.getString("name");
            String licenceNumber = resultSet.getString("licence_number");
            return new Driver(id, name, licenceNumber);
        } catch (SQLException e) {
            throw new RuntimeException("Can't get a result ", e);
        }
    }
}
