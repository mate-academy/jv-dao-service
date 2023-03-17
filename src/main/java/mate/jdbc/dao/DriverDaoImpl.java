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
        String insertDriverQuery = "INSERT INTO drivers(name, license_number) VALUES(?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement createDriverStatement =
                        connection.prepareStatement(insertDriverQuery,
                             Statement.RETURN_GENERATED_KEYS)) {
            createDriverStatement.setString(1, driver.getName());
            createDriverStatement.setString(2, driver.getLicenseNumber());
            createDriverStatement.executeUpdate();
            ResultSet generatedKeys = createDriverStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Long object = generatedKeys.getObject(1, Long.class);
                driver.setId(object);
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can`t insert driver to DB. Driver: " + driver, e);
        }
        return driver;
    }

    @Override
    public Optional<Driver> get(Long id) {
        String getDriverQuery = "SELECT * FROM "
                + "drivers WHERE is_deleted = false AND id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getDriverStatement =
                        connection.prepareStatement(getDriverQuery)) {
            getDriverStatement.setLong(1, id);
            ResultSet resultSet = getDriverStatement.executeQuery();
            Driver driver;
            if (resultSet.next()) {
                driver = createNewDriver(resultSet);
            } else {
                driver = null;
            }
            return Optional.ofNullable(driver);
        } catch (SQLException e) {
            throw new DataProcessingException("Can`t get driver from DB. Driver ID: " + id, e);
        }
    }

    @Override
    public List<Driver> getAll() {
        List<Driver> allDrivers = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection();
                Statement getAllDriversStatement = connection.createStatement()) {
            ResultSet resultSet = getAllDriversStatement.executeQuery("SELECT * FROM "
                    + "drivers WHERE is_deleted = false");
            while (resultSet.next()) {
                Driver driver = createNewDriver(resultSet);
                allDrivers.add(driver);
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can`t get all drivers from DB", e);
        }
        return allDrivers;
    }

    @Override
    public Driver update(Driver driver) {
        String updateDriverQuery = "UPDATE drivers SET name = ?, license_number = ? "
                + "WHERE id = ? AND is_deleted = false";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement updateDriverStatement =
                        connection.prepareStatement(updateDriverQuery)) {
            updateDriverStatement.setString(1, driver.getName());
            updateDriverStatement.setString(2, driver.getLicenseNumber());
            updateDriverStatement.setLong(3, driver.getId());
            updateDriverStatement.executeUpdate();
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Can`t update driver to DB. Driver: " + driver, e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String deleteDriverQuery = "UPDATE drivers SET is_deleted = true WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement deleteDriverStatement =
                        connection.prepareStatement(deleteDriverQuery)) {
            deleteDriverStatement.setLong(1, id);
            return deleteDriverStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DataProcessingException("Can`t delete driver to DB. Driver ID: " + id, e);
        }
    }

    private Driver createNewDriver(ResultSet resultSet) throws SQLException {
        Driver driver = new Driver(
                resultSet.getObject("id", Long.class),
                resultSet.getString("name"),
                resultSet.getString("license_number"));
        return driver;
    }
}
