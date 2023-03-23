package mate.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mate.jdbc.exception.DataProcessingException;
import mate.jdbc.model.Driver;
import mate.jdbc.util.ConnectionUtil;

public class DriverDaoImpl implements DriverDao {
    private static final String CREATE_QUERY = "INSERT INTO drivers"
            + " (name, licenseNumber) VALUES (?, ?)";
    private static final String GET_QUERY = "SELECT * FROM drivers"
            + " WHERE id = ? AND is_deleted = FALSE";
    private static final String GET_ALL_QUERY = "SELECT * FROM drivers"
            + " WHERE is_deleted = FALSE";
    private static final String UPDATE_QUERY = "UPDATE drivers SET name = ?,"
            + " licenseNumber = ? WHERE id = ? AND is_deleted = FALSE";
    private static final String DELETE_QUERY = "UPDATE drivers"
            + " SET is_deleted = TRUE WHERE id = ?";

    @Override
    public Driver create(Driver driver) {
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement statement
                     = connection.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, driver.getName());
            statement.setString(2, driver.getLicenseNumber());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                driver.setId(resultSet.getObject(1, Long.class));
            }
            return driver;
        } catch (SQLException exception) {
            throw new DataProcessingException("Couldn't create driver. " + driver, exception);
        }
    }

    @Override
    public Driver get(Long id) {
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement getDriverStatement = connection.prepareStatement(GET_QUERY)) {
            getDriverStatement.setLong(1, id);
            ResultSet resultSet = getDriverStatement.executeQuery();
            Driver driver = null;
            if (resultSet.next()) {
                driver = getDriver(resultSet);
            }
            return driver;
        } catch (SQLException exception) {
            throw new DataProcessingException("Couldn't get driver by id " + id, exception);
        }
    }

    @Override
    public List<Driver> getAll() {
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement getAllStatement
                     = connection.prepareStatement(GET_ALL_QUERY)) {
            List<Driver> drivers = new ArrayList<>();
            ResultSet resultSet = getAllStatement.executeQuery();
            while (resultSet.next()) {
                drivers.add(getDriver(resultSet));
            }
            return drivers;
        } catch (SQLException exception) {
            throw new DataProcessingException("Couldn't get a list of drivers "
                    + "from drivers table.", exception);
        }
    }

    @Override
    public Driver update(Driver driver) {
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement updateStatement
                     = connection.prepareStatement(UPDATE_QUERY)) {
            updateStatement.setString(1, driver.getName());
            updateStatement.setString(2, driver.getLicenseNumber());
            updateStatement.setLong(3, driver.getId());
            updateStatement.executeUpdate();
            return driver;
        } catch (SQLException exception) {
            throw new DataProcessingException("Couldn't update a driver "
                    + driver, exception);
        }
    }

    @Override
    public boolean delete(Long id) {
        String query = "UPDATE drivers SET is_deleted = TRUE WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement deleteStatement
                     = connection.prepareStatement(DELETE_QUERY)) {
            deleteStatement.setLong(1, id);
            return deleteStatement.executeUpdate() > 0;
        } catch (SQLException exception) {
            throw new DataProcessingException("Couldn't delete a driver by id " + id, exception);
        }
    }

    private Driver getDriver(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getObject("id", Long.class);
        String name = resultSet.getString("name");
        String licenseNumber = resultSet.getString("licenseNumber");
        return new Driver(id, name, licenseNumber);
    }
}
