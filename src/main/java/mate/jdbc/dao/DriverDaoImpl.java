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
        String sqlQuery = "INSERT INTO drivers (name, license_number) "
                + "VALUES (? ,?)";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement createDriverStatement
                        = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS)
        ) {
            createDriverStatement.setString(1, driver.getName());
            createDriverStatement.setString(2, driver.getLicenseNumber());
            createDriverStatement.executeUpdate();
            ResultSet resultSetUpdate = createDriverStatement.getGeneratedKeys();
            if (resultSetUpdate.next()) {
                Long id = resultSetUpdate.getObject(1, Long.class);
                driver.setId(id);
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't create driver. " + driver + " ", e);
        }
        return driver;
    }

    @Override
    public Optional<Driver> get(Long id) {
        String sqlQuery = "SELECT * FROM drivers WHERE id = " + id + " AND is_deleted = false ;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getDriverStatement = connection.prepareStatement(sqlQuery)
        ) {
            ResultSet resultSetById = getDriverStatement.executeQuery();
            Driver driver = null;
            if (resultSetById.next()) {
                driver = getDriver(resultSetById);
            }
            return Optional.ofNullable(driver);
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get driver by id " + id + ". ", e);
        }
    }

    @Override
    public List<Driver> getAll() {
        String sqlQuery = "SELECT * FROM drivers WHERE is_deleted = false;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getAllStatement = connection.prepareStatement(sqlQuery)
        ) {
            ResultSet resultSetAllDrivers = getAllStatement.executeQuery();
            List<Driver> driverList = new ArrayList<>();
            while (resultSetAllDrivers.next()) {
                Driver driver = getDriver(resultSetAllDrivers);
                driverList.add(driver);
            }
            return driverList;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get all drivers from database. ", e);
        }
    }

    @Override
    public Driver update(Driver driver) {
        String sqlQuery = "UPDATE drivers SET name = ?, license_number = ? "
                + "WHERE id = ? AND is_deleted = false";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement updateDriverStatement = connection.prepareStatement(sqlQuery)
        ) {
            updateDriverStatement.setString(1, driver.getName());
            updateDriverStatement.setString(2, driver.getLicenseNumber());
            updateDriverStatement.setObject(3, driver.getId());
            updateDriverStatement.executeUpdate();
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't update driver with param: " + driver + " ", e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String sqlQuery = "UPDATE drivers SET is_deleted = true WHERE id = ?;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement deleteStatement = connection.prepareStatement(sqlQuery)
        ) {
            deleteStatement.setObject(1, id);
            return deleteStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete driver with id: " + id + ". ", e);
        }
    }

    private Driver getDriver(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getObject(1, Long.class);
        String name = resultSet.getString(2);
        String licenseNumber = resultSet.getString(3);
        return new Driver(id, name, licenseNumber);
    }
}
