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
        String createQuery = "INSERT INTO drivers(name, license_number) "
                + "VALUES(?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement createStatement =
                         connection.prepareStatement(createQuery,
                                 Statement.RETURN_GENERATED_KEYS)) {
            createStatement.setString(1, driver.getName());
            createStatement.setString(2, driver.getLicenseNumber());
            createStatement.executeUpdate();
            ResultSet resultSet = createStatement.getGeneratedKeys();
            if (resultSet.next()) {
                driver.setId(resultSet.getObject(1, Long.class));
            }
            return driver;
        } catch (SQLException exception) {
            throw new DataProcessingException("Couldn't create driver: " + driver, exception);
        }
    }

    @Override
    public Optional<Driver> get(Long id) {
        String getDriverQuery = "SELECT * "
                + "FROM drivers "
                + "WHERE id = ? AND is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getDriverStatement =
                        connection.prepareStatement(getDriverQuery)) {
            getDriverStatement.setLong(1, id);
            ResultSet resultSet = getDriverStatement.executeQuery();
            Driver driver = null;
            if (resultSet.next()) {
                driver = getDriver(resultSet);
            }
            return Optional.ofNullable(driver);
        } catch (SQLException exception) {
            throw new DataProcessingException("Couldn't get driver by id " + id, exception);
        }
    }

    @Override
    public List<Driver> getAll() {
        String getAllDriversQuery = "SELECT * "
                + "FROM drivers "
                + "WHERE is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getAllStatement =
                        connection.prepareStatement(getAllDriversQuery)) {
            List<Driver> drivers = new ArrayList<>();
            ResultSet resultSet = getAllStatement.executeQuery();
            while (resultSet.next()) {
                drivers.add(getDriver(resultSet));
            }
            return drivers;
        } catch (SQLException exception) {
            throw new DataProcessingException("Couldn't get a list of drivers"
                    + "from drivers table.", exception);
        }
    }

    @Override
    public Driver update(Driver driver) {
        String updateDriverQuery = "UPDATE drivers SET name = ?, license_number = ? "
                + "WHERE id = ? AND is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement updateDriverStatement =
                        connection.prepareStatement(updateDriverQuery)) {
            updateDriverStatement.setString(1, driver.getName());
            updateDriverStatement.setString(2, driver.getLicenseNumber());
            updateDriverStatement.setLong(3, driver.getId());
            updateDriverStatement.executeUpdate();
            return driver;
        } catch (SQLException exception) {
            throw new DataProcessingException("Couldn't update a driver "
                    + driver, exception);
        }
    }

    @Override
    public boolean delete(Long id) {
        String softDeleteQuery = "UPDATE drivers SET is_deleted = TRUE "
                + "WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement softDeleteStatement =
                        connection.prepareStatement(softDeleteQuery)) {
            softDeleteStatement.setLong(1, id);
            return softDeleteStatement.executeUpdate() > 0;
        } catch (SQLException exception) {
            throw new DataProcessingException("Couldn't delete a driver by id: " + id, exception);
        }
    }

    private Driver getDriver(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getObject("id", Long.class);
        String name = resultSet.getString("name");
        String licenceNumber = resultSet.getString("license_number");
        return new Driver(id, name, licenceNumber);
    }
}
