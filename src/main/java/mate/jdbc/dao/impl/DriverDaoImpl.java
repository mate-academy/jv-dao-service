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
    private static final String TABLE = "drivers";
    private static final String ID_COLUMN = "id";
    private static final String IS_DELETED_COLUMN = "is_deleted";
    private static final String NAME_COLUMN = "name";
    private static final String LICENSE_COLUMN = "license_number";

    @Override
    public Driver create(Driver driver) {
        String query = String.format("INSERT INTO %s (%s, %s) VALUES (?, ?);",
                TABLE, NAME_COLUMN, LICENSE_COLUMN);
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement
                        = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, driver.getName());
            statement.setString(2, driver.getLicenseNumber());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                driver.setId(resultSet.getObject(1, Long.class));
            }
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't create driver. " + driver, e);
        }
    }

    @Override
    public Optional<Driver> get(Long id) {
        String query = String.format("SELECT * FROM %s WHERE %s = ? AND %s = FALSE;",
                TABLE, ID_COLUMN, IS_DELETED_COLUMN);
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            Driver driver = null;
            if (resultSet.next()) {
                driver = getDriver(resultSet);
            }
            return Optional.ofNullable(driver);
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't get driver by id " + id, e);
        }
    }

    @Override
    public List<Driver> getAll() {
        String query = String.format("SELECT * FROM %s WHERE %s = FALSE;",
                TABLE, IS_DELETED_COLUMN);
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement
                        = connection.prepareStatement(query)) {
            List<Driver> drivers = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                drivers.add(getDriver(resultSet));
            }
            return drivers;
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't get a list of drivers "
                                              + "from drivers table.", e);
        }
    }

    @Override
    public Driver update(Driver driver) {
        String query = String.format("UPDATE %s SET %s = ?, %s = ? WHERE %s = ? AND %s = FALSE;",
                TABLE, NAME_COLUMN, LICENSE_COLUMN, ID_COLUMN, IS_DELETED_COLUMN);
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement
                        = connection.prepareStatement(query)) {
            statement.setString(1, driver.getName());
            statement.setString(2, driver.getLicenseNumber());
            statement.setLong(3, driver.getId());
            statement.executeUpdate();
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't update a driver "
                                              + driver, e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String query = String.format("UPDATE %s SET %s = TRUE WHERE %s = ?;",
                TABLE, IS_DELETED_COLUMN, ID_COLUMN);
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement
                        = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't delete a driver by id " + id, e);
        }
    }

    private Driver getDriver(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getObject(ID_COLUMN, Long.class);
        String name = resultSet.getString(NAME_COLUMN);
        String country = resultSet.getString(LICENSE_COLUMN);
        return new Driver(id, name, country);
    }
}
