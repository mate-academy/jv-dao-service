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
import mate.jdbc.lib.Dao;
import mate.jdbc.model.Driver;
import mate.jdbc.util.ConnectionUtil;

@Dao
public class DriverDaoImpl implements DriverDao {
    private static final String INSERT_DRIVER_REQUEST
            = "INSERT INTO drivers(name, licence_number) values(?,?);";
    private static final String GET_ALL_DRIVERS_REQUEST
            = "SELECT * FROM drivers WHERE is_deleted = false";
    private static final String UPDATE_DRIVER_REQUEST
            = "UPDATE drivers SET name=?,licence_number=? WHERE id=?";
    private static final String DELETE_DRIVER_REQUEST
            = "UPDATE drivers SET is_deleted = true WHERE id = ?";
    private static final String GET_DRIVER_REQUEST
            = "SELECT * FROM drivers WHERE is_deleted = false AND id = ?";
    private static final String CANT_GET_ALL_MESSAGE = "Can't get all drivers from DB.";
    private static final String CANT_CREATE_MESSAGE = "Can't insert driver to DB.";
    private static final String CANT_UPDATE_MESSAGE = "Can't update driver in DB.";
    private static final String CANT_DELETE_MESSAGE = "Can't delete driver from DB.";
    private static final String CANT_GET_MESSAGE = "Can't get driver by id from DB.";
    private static final String NAME = "name";
    private static final String LICENCE_NUMBER = "licence_number";
    private static final String ID = "id";

    @Override
    public List<Driver> getAll() {
        List<Driver> driverList = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection();
                Statement getAllDriversStatement = connection.createStatement();) {
            ResultSet resultSet = getAllDriversStatement
                    .executeQuery(GET_ALL_DRIVERS_REQUEST);
            while (resultSet.next()) {
                driverList.add(getDriver(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(CANT_GET_ALL_MESSAGE, e);
        }
        return driverList;
    }

    @Override
    public Driver create(Driver driver) {
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement createDriverStatement =
                        connection.prepareStatement(INSERT_DRIVER_REQUEST,
                             Statement.RETURN_GENERATED_KEYS);) {
            createDriverStatement.setString(1, driver.getName());
            createDriverStatement.setString(2, driver.getLicenseNumber());
            createDriverStatement.executeUpdate();
            ResultSet generatedKeys = createDriverStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Long id = generatedKeys.getObject(1, Long.class);
                driver.setId(id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(CANT_CREATE_MESSAGE, e);
        }
        return driver;
    }

    @Override
    public Driver update(Driver driver) {
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement updateDriverStatement =
                        connection.prepareStatement(UPDATE_DRIVER_REQUEST,
                             Statement.RETURN_GENERATED_KEYS);) {
            updateDriverStatement.setString(1, driver.getName());
            updateDriverStatement.setString(2, driver.getLicenseNumber());
            updateDriverStatement.setObject(3, driver.getId());
            updateDriverStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(CANT_UPDATE_MESSAGE, e);
        }
        return driver;
    }

    @Override
    public boolean delete(Long id) {
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement deleteDriverStatement =
                         connection.prepareStatement(DELETE_DRIVER_REQUEST,
                             Statement.RETURN_GENERATED_KEYS);) {
            deleteDriverStatement.setLong(1, id);
            return deleteDriverStatement.executeUpdate() >= 1;
        } catch (SQLException e) {
            throw new RuntimeException(CANT_DELETE_MESSAGE, e);
        }
    }

    @Override
    public Optional<Driver> get(Long id) {
        Driver driver = null;
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement getDriverStatement =
                        connection.prepareStatement(GET_DRIVER_REQUEST,
                             Statement.RETURN_GENERATED_KEYS);) {
            getDriverStatement.setLong(1, id);
            ResultSet resultSet = getDriverStatement.executeQuery();
            if (resultSet.next()) {
                driver = getDriver(resultSet);
            }
            return Optional.ofNullable(driver);
        } catch (SQLException e) {
            throw new RuntimeException(CANT_GET_MESSAGE, e);
        }
    }

    private Driver getDriver(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getObject(ID, Long.class);
        String name = resultSet.getString(NAME);
        String licenseNumber = resultSet.getString(LICENCE_NUMBER);
        return new Driver(id, name, licenseNumber);
    }
}
