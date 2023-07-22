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
        String createRequest = "INSERT INTO drivers(name, license_number) VALUES(?, ?);";
        try (Connection dbConnection = ConnectionUtil.getConnection();
                PreparedStatement createStatement = dbConnection.prepareStatement(createRequest,
                        Statement.RETURN_GENERATED_KEYS)) {
            createStatement.setString(1, driver.getName());
            createStatement.setString(2, driver.getLicenseNumber());
            createStatement.executeUpdate();
            ResultSet generatedKeys = createStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                driver.setId(generatedKeys.getObject(1, Long.class));
            }
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't insert driver " + driver
                    + " to DB", e);
        }
    }

    @Override
    public Optional<Driver> get(Long id) {
        String getRequest = "SELECT * FROM drivers WHERE is_deleted = FALSE AND id = ?;";
        try (Connection dbConnection = ConnectionUtil.getConnection();
                PreparedStatement getStatement = dbConnection.prepareStatement(getRequest)) {
            getStatement.setLong(1, id);
            ResultSet driversSet = getStatement.executeQuery();
            if (driversSet.next()) {
                return Optional.of(getDriverFromResultSet(driversSet));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get drivers by id " + id
                    + " from DB", e);
        }
    }

    @Override
    public List<Driver> getAll() {
        String getRequest = "SELECT * FROM drivers WHERE is_deleted = FALSE;";
        List<Driver> drivers = new ArrayList<>();
        try (Connection dbConnection = ConnectionUtil.getConnection();
                PreparedStatement getStatement = dbConnection.prepareStatement(getRequest)) {
            ResultSet driversSet = getStatement.executeQuery();
            while (driversSet.next()) {
                drivers.add(getDriverFromResultSet(driversSet));
            }
            return drivers;
        } catch (SQLException e) {
            throw new RuntimeException("Can't get all drivers from DB", e);
        }
    }

    @Override
    public Driver update(Driver driver) {
        String updateRequest = "UPDATE drivers SET name = ?,"
                + " license_number = ? WHERE id = ? AND is_deleted = FALSE;";
        try (Connection dbConnection = ConnectionUtil.getConnection();
                PreparedStatement updateStatement = dbConnection.prepareStatement(updateRequest)) {
            updateStatement.setString(1, driver.getName());
            updateStatement.setString(2, driver.getLicenseNumber());
            updateStatement.setLong(3, driver.getId());
            updateStatement.executeUpdate();
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't update driver " + driver
                    + " in DB", e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String deleteRequest = "UPDATE drivers SET is_deleted = TRUE "
                + "WHERE id = ?;";
        try (Connection dbConnection = ConnectionUtil.getConnection();
                PreparedStatement deleteStatement = dbConnection.prepareStatement(deleteRequest)) {
            deleteStatement.setLong(1, id);
            return deleteStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete driver by id " + id
                    + " from DB", e);
        }
    }

    private Driver getDriverFromResultSet(ResultSet resultSet) throws SQLException {
        return new Driver(resultSet.getObject("id", Long.class),
                resultSet.getString("name"),
                resultSet.getString("license_number"));
    }
}
