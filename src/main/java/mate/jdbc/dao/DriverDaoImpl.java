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
        String query = "INSERT INTO drivers(name, license) VALUES(?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement createDriverStatement = connection
                        .prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            createDriverStatement.setString(1, driver.getName());
            createDriverStatement.setString(2, driver.getLicense());
            createDriverStatement.executeUpdate();
            ResultSet generatedKeys = createDriverStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Long id = generatedKeys.getObject(1, Long.class);
                driver.setId(id);
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Cannot create driver: " + driver, e);
        }
        return driver;
    }

    @Override
    public Optional<Driver> get(Long id) {
        String query = "SELECT * FROM drivers WHERE id = ? AND is_deleted = false";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getDriverStatement = connection
                        .prepareStatement(query)) {
            getDriverStatement.setLong(1, id);
            ResultSet generatedKeys = getDriverStatement.executeQuery();
            return Optional.ofNullable(generatedKeys.next() ? getDriver(generatedKeys) : null);
        } catch (SQLException e) {
            throw new DataProcessingException("Cannot get driver by id: " + id, e);
        }
    }

    @Override
    public List<Driver> getAll() {
        String query = "SELECT * FROM drivers WHERE is_deleted = false";
        List<Driver> driversList = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getAllDriversStatement = connection
                        .prepareStatement(query)) {
            ResultSet generatedKeys = getAllDriversStatement.executeQuery();
            while (generatedKeys.next()) {
                driversList.add(getDriver(generatedKeys));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Cannot get drivers", e);
        }
        return driversList;
    }

    @Override
    public Driver update(Driver driver) {
        String query
                = "UPDATE drivers SET name = ?, license = ? WHERE id = ? AND is_deleted = false";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement updateDriverStatement = connection
                        .prepareStatement(query)) {
            updateDriverStatement.setString(1, driver.getName());
            updateDriverStatement.setString(2, driver.getLicense());
            updateDriverStatement.setLong(3, driver.getId());
            updateDriverStatement.executeUpdate();
            return driver;
        } catch (SQLException e) {
            throw new RuntimeException("Cannot update driver by id: " + driver.getId(), e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String query = "UPDATE drivers SET is_deleted = true WHERE id = ? AND is_deleted = false";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement deleteDriverStatement = connection
                        .prepareStatement(query)) {
            deleteDriverStatement.setLong(1, id);
            return deleteDriverStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Cannot delete driver by id: " + id, e);
        }
    }

    private Driver getDriver(ResultSet generatedKeys) throws SQLException {
        Long id = generatedKeys.getObject(1, Long.class);
        String name = generatedKeys.getString(2);
        String license = generatedKeys.getString(3);
        return new Driver(id, name, license);
    }
}
