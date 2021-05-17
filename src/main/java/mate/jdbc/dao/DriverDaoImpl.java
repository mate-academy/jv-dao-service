package mate.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import mate.jdbc.lib.Dao;
import mate.jdbc.lib.exception.DataProcessingException;
import mate.jdbc.model.Driver;
import mate.jdbc.util.ConnectionUtil;

@Dao
public class DriverDaoImpl implements DriverDao {
    @Override
    public Driver create(Driver driver) {
        String createDriverQuery = "INSERT INTO drivers (name, license_number)"
                + " VALUES (?, ?);";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement createDriverStatement = connection
                        .prepareStatement(createDriverQuery,
                        Statement.RETURN_GENERATED_KEYS)) {
            createDriverStatement.setString(1, driver.getName());
            createDriverStatement.setString(2, driver.getLicenseNumber());
            createDriverStatement.executeUpdate();
            ResultSet dataFromDB = createDriverStatement.getGeneratedKeys();
            if (dataFromDB.next()) {
                driver.setId(dataFromDB.getObject(1, Long.class));
            }
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't insert driver"
                    + " to DB. Param: " + driver, e);
        }
    }

    @Override
    public Optional<Driver> get(Long id) {
        String getDriverQuery = "SELECT * FROM drivers "
                + "WHERE id = ? AND deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getDriverStatement = connection
                        .prepareStatement(getDriverQuery)) {
            getDriverStatement.setLong(1, id);
            ResultSet dataFromDB = getDriverStatement.executeQuery();
            Driver driver = null;
            if (dataFromDB.next()) {
                driver = createAndInitializeDriver(dataFromDB);
            }
            return Optional.ofNullable(driver);
        } catch (SQLException e) {
            throw new DataProcessingException("Can't select data with "
                    + "current ID: " + id, e);
        }
    }

    @Override
    public List<Driver> getAll() {
        List<Driver> driversList = new ArrayList<>();
        String getAllDriversQuery = "SELECT * FROM drivers WHERE deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getAllDriversStatement = connection
                        .prepareStatement(getAllDriversQuery)) {
            ResultSet dataFromDB = getAllDriversStatement.executeQuery();
            while (dataFromDB.next()) {
                driversList.add(createAndInitializeDriver(dataFromDB));
            }
            return driversList;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't select all drivers list from DB", e);
        }
    }

    @Override
    public Driver update(Driver driver) {
        String updateDriverQuery = "UPDATE drivers SET name = ?,"
                + " license_number = ? WHERE id = ? AND deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement updateDriverStatement = connection
                        .prepareStatement(updateDriverQuery)) {
            updateDriverStatement.setString(1, driver.getName());
            updateDriverStatement.setString(2, driver.getLicenseNumber());
            updateDriverStatement.setObject(3, driver.getId());
            updateDriverStatement.executeUpdate();
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't update current driver: " + driver, e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String deleteDriverQuery = "UPDATE drivers SET deleted = TRUE WHERE id = ?;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement deleteDriverStatement = connection
                        .prepareStatement(deleteDriverQuery)) {
            deleteDriverStatement.setLong(1, id);
            deleteDriverStatement.executeUpdate();
            return deleteDriverStatement.executeUpdate() >= 1;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete driver with current ID: " + id, e);
        }
    }

    private Driver createAndInitializeDriver(ResultSet dataFromDB) {
        Driver currentDriver;
        try {
            currentDriver = new Driver(dataFromDB.getString("name"),
                    dataFromDB.getString("license_number"));
            currentDriver.setId(dataFromDB.getObject("id", Long.class));
            return currentDriver;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't create driver from input data", e);
        }
    }
}
