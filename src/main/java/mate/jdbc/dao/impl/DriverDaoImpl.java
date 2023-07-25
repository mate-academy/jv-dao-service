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
                PreparedStatement statement = connection.prepareStatement(createQuery,
                        Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, driver.getName());
            statement.setString(2, driver.getLicenceNumber());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                Long id = resultSet.getObject(1, Long.class);
                driver.setId(id);
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't insert format to DB ", e);
        }
        return driver;
    }

    @Override
    public Optional<Driver> get(Long id) {
        String getQuery = "SELECT id, name, licence_number FROM drivers WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(getQuery)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(resultSetToDrivers(resultSet));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't getting drivers ", e);
        }
        return Optional.empty();
    }

    @Override
    public List<Driver> getAll() {
        String getAllDriversQuery = "SELECT id, name, licence_number FROM drivers";
        List<Driver> allDrivers = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(getAllDriversQuery)) {
            ResultSet resultSet = statement.executeQuery(getAllDriversQuery);
            allDrivers = driversListFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DataProcessingException("Can't getting all drivers in DB ", e);
        }
        return allDrivers;
    }

    @Override
    public Driver update(Driver driver) {
        Optional<Driver> getDriver = get(driver.getId());
        if (getDriver.isPresent()) {
            String updateQuery = "UPDATE drivers SET name = ?, licence_number = ? WHERE id = ?";
            try (Connection connection = ConnectionUtil.getConnection();
                    PreparedStatement statement = connection.prepareStatement(updateQuery)) {
                statement.setString(1, driver.getName());
                statement.setString(2, driver.getLicenceNumber());
                statement.setLong(3, driver.getId());
                statement.executeUpdate();
                return driver;
            } catch (SQLException e) {
                throw new DataProcessingException("Can't updating driver in DB ", e);
            }
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        String deleteQuery = "DELETE FROM drivers WHERE id = ?";
        int row = 0;

        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(deleteQuery)) {
            statement.setLong(1, id);
            row = statement.executeUpdate();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete driver in DB ", e);
        }
        return row > 0;
    }

    private Driver resultSetToDrivers(ResultSet resultSet) {
        Driver driver = new Driver();
        try {
            driver.setId(resultSet.getLong("id"));
            driver.setName(resultSet.getString("name"));
            driver.setLicenceNumber("licence_number");
            return driver;
        } catch (SQLException e) {
            throw new RuntimeException("Can't get a result ", e);
        }
    }

    private List<Driver> driversListFromResultSet(ResultSet resultSet) {
        List<Driver> drivers = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Driver driver = resultSetToDrivers(resultSet);
                drivers.add(driver);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Can't get result ", e);
        }
        return drivers;
    }
}
