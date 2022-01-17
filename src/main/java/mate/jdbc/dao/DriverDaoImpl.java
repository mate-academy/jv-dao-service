package mate.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import mate.jdbc.exception.DataProcessingException;
import mate.jdbc.lib.Dao;
import mate.jdbc.model.Driver;
import mate.jdbc.util.ConnectionUtil;

@Dao
public class DriverDaoImpl implements DriverDao {
    @Override
    public Driver create(Driver driver) {
        String createRequest = "INSERT INTO drivers (name,licenseNumber) value (?,?)";
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement createDriverStatement
                         = connection.prepareStatement(createRequest,
                         Statement.RETURN_GENERATED_KEYS)) {
            createDriverStatement.setString(1, driver.getName());
            createDriverStatement.setString(2, driver.getLicenseNumber());
            createDriverStatement.executeUpdate();
            ResultSet generatedKeys = createDriverStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Long id = generatedKeys.getObject(1, Long.class);
                driver.setId(id);
            }
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't create a driver to DB" + driver, e);
        }
    }

    @Override
    public Optional<Driver> get(Long id) {
        String getRequest = "SELECT * FROM drivers WHERE id = ? AND is_deleted = false";
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement getDriverStatement = connection.prepareStatement(getRequest)) {
            getDriverStatement.setLong(1, id);
            ResultSet resultSet = getDriverStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(getDriver(resultSet));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get a driver by id" + id, e);
        }
        return Optional.empty();
    }

    @Override
    public List<Driver> getAll() {
        List<Driver> allDrivers = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection();
                 Statement getAllDriversStatement = connection.createStatement()) {
            ResultSet resultSet = getAllDriversStatement
                    .executeQuery("SELECT * FROM drivers WHERE is_deleted = false");
            while (resultSet.next()) {
                allDrivers.add(getDriver(resultSet));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get all drivers from DB", e);
        }
        return allDrivers;
    }

    @Override
    public Driver update(Driver driver) {
        String updateRequest = "UPDATE drivers SET name = ?, licenseNumber = ?"
                + "WHERE id = ? AND is_deleted = false";
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement updateDriverStatement =
                         connection.prepareStatement(updateRequest)) {
            updateDriverStatement.setString(1, driver.getName());
            updateDriverStatement.setString(2, driver.getLicenseNumber());
            updateDriverStatement.setLong(3, driver.getId());
            updateDriverStatement.executeUpdate();
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't update a driver in DB" + driver, e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String deleteRequest = "UPDATE drivers SET is_deleted = true WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement deleteDriverStatement =
                         connection.prepareStatement(deleteRequest)) {
            deleteDriverStatement.setLong(1, id);
            return deleteDriverStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete a driver by id" + id, e);
        }
    }

    public Driver getDriver(ResultSet resultSet) {
        try {
            Long id = resultSet.getObject("id", Long.class);
            String name = resultSet.getString("name");
            String licenseNumber = resultSet.getString("licenseNumber");
            Driver driver = new Driver(name,licenseNumber);
            driver.setId(id);
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get Driver by resultSet" + resultSet, e);
        }
    }
}
