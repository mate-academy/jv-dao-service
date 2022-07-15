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
        String createDriverRequest = "INSERT drivers (name, licence_number) VALUES (?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement createDriverStatement =
                        connection.prepareStatement(
                                createDriverRequest, Statement.RETURN_GENERATED_KEYS)) {
            createDriverStatement.setString(1, driver.getName());
            createDriverStatement.setString(2, driver.getLicenseNumber());
            createDriverStatement.executeUpdate();
            ResultSet generatedKey = createDriverStatement.getGeneratedKeys();
            if (generatedKey.next()) {
                driver.setId(generatedKey.getObject(1, Long.class));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can`t add to DB the driver " + driver, e);
        }
        return driver;
    }

    @Override
    public Optional<Driver> get(Long id) {
        String getByIdRequest = "SELECT * FROM drivers WHERE id = ? AND is_deleted = 'false'";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getByIdStatement = connection.prepareStatement(getByIdRequest)) {
            getByIdStatement.setLong(1, id);
            ResultSet getByIdResultSet = getByIdStatement.executeQuery();
            if (getByIdResultSet.next()) {
                return Optional.of(getDriver(getByIdResultSet));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can`t get the driver by id " + id, e);
        }
        return Optional.empty();
    }

    @Override
    public List<Driver> getAll() {
        List<Driver> drivers = new ArrayList<>();
        String getAllRequest = "SELECT * FROM drivers WHERE is_deleted = 'false'";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getAllStatement = connection.prepareStatement(getAllRequest)) {
            ResultSet getAllResultSet = getAllStatement.executeQuery();
            while (getAllResultSet.next()) {
                Driver driver = getDriver(getAllResultSet);
                drivers.add(driver);
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can`t get all drivers", e);
        }
        return drivers;
    }

    @Override
    public Driver update(Driver driver) {
        String updateRequest = "UPDATE drivers SET name = ?, licence_number = ? "
                + "WHERE id = ? AND is_deleted = 'false'";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement updateStatement = connection.prepareStatement(updateRequest)) {
            updateStatement.setString(1, driver.getName());
            updateStatement.setString(2, driver.getLicenseNumber());
            updateStatement.setLong(3, driver.getId());
            updateStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DataProcessingException("Can`t update the driver" + driver, e);
        }
        return driver;
    }

    @Override
    public boolean delete(Long id) {
        String deleteRequest = "UPDATE drivers SET is_deleted = 'true' WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement deleteStatement = connection.prepareStatement(deleteRequest)) {
            deleteStatement.setLong(1, id);
            return deleteStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DataProcessingException("Can`t delete driver with id" + id, e);
        }
    }

    private Driver getDriver(ResultSet resultSet) {
        try {
            return new Driver(resultSet.getLong(1),
                    resultSet.getString("name"),
                    resultSet.getString("licence_number"));
        } catch (SQLException e) {
            throw new DataProcessingException("Can`t get driver from resultSet", e);
        }
    }
}
