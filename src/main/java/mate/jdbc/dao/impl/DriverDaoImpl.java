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
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_LICENSE = "license_number";

    @Override
    public Optional<Driver> get(Long id) {
        String getDriverQuery =
                "SELECT * FROM drivers WHERE id = ? AND is_deleted = FALSE;";
        Optional<Driver> driver = Optional.empty();
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getDriverStatement = connection
                        .prepareStatement(getDriverQuery)) {
            getDriverStatement.setLong(1, id);
            getDriverStatement.executeQuery();
            ResultSet resultSet = getDriverStatement.getResultSet();
            if (resultSet.next()) {
                return Optional.of(retrieveDriver(resultSet));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get a driver by id"
                    + id + " from taxi_DB", e);
        }
        return driver;
    }

    @Override
    public List<Driver> getAll() {
        String getAllDriversQuery = "SELECT * FROM drivers WHERE is_deleted = FALSE;";
        List<Driver> allDrivers = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getAllDriversStatement = connection
                        .prepareStatement(getAllDriversQuery)) {
            ResultSet resultSet = getAllDriversStatement
                    .executeQuery(getAllDriversQuery);
            while (resultSet.next()) {
                allDrivers.add(retrieveDriver(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Can't get all drivers from taxi_DB", e);
        }
        return allDrivers;
    }

    @Override
    public Driver create(Driver driver) {
        String insertDriverQuery =
                "INSERT INTO drivers (name, license_number) VALUES (?, ?);";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement createDriverStatement =
                        connection.prepareStatement(insertDriverQuery,
                             Statement.RETURN_GENERATED_KEYS)) {
            createDriverStatement.setString(1, driver.getName());
            createDriverStatement.setString(2, driver.getLicenseNumber());
            createDriverStatement.executeUpdate();
            ResultSet generatedKeys = createDriverStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Long id = generatedKeys.getObject(1, Long.class);
                driver.setId(id);
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't add driver " + driver
                    + " to taxi_DB", e);
        }
        return driver;
    }

    @Override
    public Driver update(Driver driver) {
        String updateQuery = "UPDATE drivers "
                + "SET name = ?, license_number = ? WHERE id = ? AND is_deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement updateStatement = connection
                        .prepareStatement(updateQuery)) {
            updateStatement.setString(1, driver.getName());
            updateStatement.setString(2, driver.getLicenseNumber());
            updateStatement.setLong(3, driver.getId());
            if (updateStatement.executeUpdate() > 0) {
                return driver;
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't update driver " + driver
                    + " in taxi_DB", e);
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        String deleteQuery = "UPDATE drivers SET is_deleted = "
                + "TRUE WHERE id = ? AND is_deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement deleteDriverStatement =
                        connection.prepareStatement(deleteQuery)) {
            deleteDriverStatement.setLong(1, id);
            return deleteDriverStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete driver with id: "
                    + id + " from taxi_DB" + id, e);
        }
    }

    private Driver retrieveDriver(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getObject(COLUMN_ID, Long.class);
        String name = resultSet.getString(COLUMN_NAME);
        String licenseNumber = resultSet.getString(COLUMN_LICENSE);
        return new Driver(id, name, licenseNumber);
    }
}
