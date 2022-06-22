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
    private static final String createDriverQuery
            = "INSERT INTO drivers(name, license) VALUES(?, ?)";
    private static final String getDriverQuery
            = "SELECT * FROM drivers WHERE id = ? AND is_deleted = false";
    private static final String getAllDriversQuery
            = "SELECT * FROM drivers WHERE is_deleted = false";
    private static final String updateDriverQuery
            = "UPDATE drivers SET name = ?, license = ? WHERE id = ?";
    private static final String deleteDriverQuery
            = "UPDATE drivers SET is_deleted = true WHERE id = ? AND is_deleted = false";

    private static final String deleteAllDriversQuery
            = "DELETE FROM drivers";
    private static final int ID_INDEX = 1;
    private static final int NAME_INDEX = 2;
    private static final int LICENSE_INDEX = 3;

    @Override
    public Driver create(Driver driver) {
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement createDriverStatement = connection
                        .prepareStatement(createDriverQuery, Statement.RETURN_GENERATED_KEYS)) {
            createDriverStatement.setString(1, driver.getName());
            createDriverStatement.setString(2, driver.getLicense());
            createDriverStatement.executeUpdate();
            ResultSet generatedKeys = createDriverStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Long id = generatedKeys.getObject(ID_INDEX, Long.class);
                driver.setId(id);
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Cannot create driver", e);
        }
        return driver;
    }

    @Override
    public Optional<Driver> get(Long id) {
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getDriverStatement = connection
                        .prepareStatement(getDriverQuery)) {
            getDriverStatement.setLong(1, id);
            ResultSet generatedKeys = getDriverStatement.executeQuery();
            return Optional.ofNullable(generatedKeys.next() ? getDriver(generatedKeys) : null);
        } catch (SQLException e) {
            throw new DataProcessingException("Cannot get driver by id: " + id, e);
        }
    }

    @Override
    public List<Driver> getAll() {
        List<Driver> list = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getAllDriversStatement = connection
                        .prepareStatement(getAllDriversQuery)) {
            ResultSet generatedKeys = getAllDriversStatement.executeQuery();
            while (generatedKeys.next()) {
                list.add(new Driver(generatedKeys.getObject(ID_INDEX, Long.class),
                        generatedKeys.getString(NAME_INDEX),
                        generatedKeys.getString(LICENSE_INDEX)));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Cannot get drivers", e);
        }
        return list;
    }

    @Override
    public Driver update(Driver driver) {
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement updateDriverStatement = connection
                        .prepareStatement(updateDriverQuery)) {
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
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement deleteDriverStatement = connection
                        .prepareStatement(deleteDriverQuery)) {
            deleteDriverStatement.setLong(1, id);
            return deleteDriverStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Cannot delete driver by id: " + id, e);
        }
    }

    @Override
    public boolean deleteAll() {
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement deleteAllDriversStatement = connection
                        .prepareStatement(deleteAllDriversQuery)) {
            return deleteAllDriversStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Cannot delete all drivers", e);
        }
    }

    private Driver getDriver(ResultSet generatedKeys) throws SQLException {
        Long id = generatedKeys.getObject(ID_INDEX, Long.class);
        String name = generatedKeys.getString(NAME_INDEX);
        String license = generatedKeys.getString(LICENSE_INDEX);
        return new Driver(id, name, license);
    }
}
