package mate.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import mate.jdbc.dao.DriverDao;
import mate.jdbc.exception.DataProcessingException;
import mate.jdbc.lib.Dao;
import mate.jdbc.lib.Inject;
import mate.jdbc.model.Driver;
import mate.jdbc.util.ConnectionUtil;

@Dao
public class DriverDaoImpl implements DriverDao {
    @Inject
    @Override
    public Driver create(Driver driver) {
        String query = "INSERT INTO drivers (name, licenceNumber) values(?,?)";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement createStatement =
                     connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            createStatement.setString(1, driver.getName());
            createStatement.setString(2, driver.getLicenseNumber());
            createStatement.executeUpdate();
            ResultSet generatedKeys = createStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Long id = generatedKeys.getObject(1, Long.class);
                driver.setId(id);
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can`t create driver " + driver, e);
        }
        return driver;
    }

    @Override
    public Optional<Driver> get(Long id) {
        String query = "SELECT * FROM drivers WHERE id = ? AND is_deleted = false";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement getStatement = connection.prepareStatement(query)
        ) {
            getStatement.setLong(1, id);
            getStatement.executeQuery();
            ResultSet resultSet = getStatement.getResultSet();
            if (resultSet.next()) {
                return Optional.of(getDriver(resultSet));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can`t get object by id " + id, e);
        }
        return Optional.empty();
    }

    @Override
    public List<Driver> getAll() {
        String query = "SELECT * FROM drivers WHERE is_deleted = false";
        List<Driver> driverList = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement getAllStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = getAllStatement.executeQuery();
            while (resultSet.next()) {
                driverList.add(getDriver(resultSet));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can`t get all data from DB", e);
        }
        return driverList;
    }

    @Override
    public Driver update(Driver driver) {
        String update = "UPDATE drivers SET name = ?"
                + ", licenceNumber = ? WHERE id = ? AND is_deleted = false";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement updatePrepared = connection.prepareStatement(update)) {
            updatePrepared.setString(1, driver.getName());
            updatePrepared.setString(2, driver.getLicenseNumber());
            updatePrepared.setLong(3, driver.getId());
            updatePrepared.executeUpdate();
            if (updatePrepared.executeUpdate() > 0) {
                return driver;
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can`t update driver " + driver, e);
        }
        throw new NoSuchElementException("driver does`nt exist in db " + driver);
    }

    @Override
    public boolean delete(Long id) {
        String deleteUpdate = "Update drivers SET is_deleted = true WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement deleteStatement = connection.prepareStatement(deleteUpdate)) {
            deleteStatement.setLong(1, id);
            deleteStatement.executeUpdate();
            return deleteStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DataProcessingException("Can`t delete date by id " + id, e);
        }
    }

    private Driver getDriver(ResultSet resultSet) throws SQLException {
        Driver driver = new Driver();
        driver.setId(resultSet.getObject("id", Long.class));
        driver.setName(resultSet.getString("name"));
        driver.setLicenseNumber(resultSet.getString("licenceNumber"));
        return driver;
    }
}
