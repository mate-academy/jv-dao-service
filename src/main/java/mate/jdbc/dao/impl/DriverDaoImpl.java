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
    private static final String INSERT_FORMAT_REQUEST =
            "INSERT INTO drivers(name, license_number) value(?, ?);";
    private static final String GET_REQUEST =
            "SELECT * FROM drivers WHERE is_deleted = FALSE AND id = ?;";
    private static final String GET_ALL =
            "SELECT * FROM drivers WHERE is_deleted = FALSE;";
    private static final String UPDATE_REQUEST =
            "UPDATE drivers SET name = ?, license_number = ? WHERE is_deleted = FALSE AND id = ?;";
    private static final String DELETE_REQUEST =
            "UPDATE drivers SET is_deleted = true WHERE id = ?;";

    @Override
    public Driver create(Driver driver) {
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement createStatement =
                        connection.prepareStatement(INSERT_FORMAT_REQUEST,
                             Statement.RETURN_GENERATED_KEYS)) {
            createStatement.setString(1, driver.getName());
            createStatement.setString(2, driver.getLicenseNumber());
            createStatement.executeUpdate();
            ResultSet generatedKeys = createStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Long id = generatedKeys.getLong(1);
                driver.setId(id);
            }
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't insert driver: "
                    + driver + " to table drivers", e);
        }
    }

    @Override
    public Optional<Driver> get(Long id) {
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getByIdStatement =
                        connection.prepareStatement(GET_REQUEST)) {
            getByIdStatement.setLong(1, id);
            ResultSet resultSet = getByIdStatement.executeQuery();
            Driver driver = null;
            if (resultSet.next()) {
                driver = getDriver(resultSet);
            }
            return Optional.ofNullable(driver);
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get driver by id " + id, e);
        }
    }

    @Override
    public List<Driver> getAll() {
        List<Driver> allDrivers = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getAllStatement =
                        connection.prepareStatement(GET_ALL)) {
            ResultSet resultSet = getAllStatement.executeQuery();
            while (resultSet.next()) {
                allDrivers.add(getDriver(resultSet));
            }
            return allDrivers;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get all drivers from DB", e);
        }
    }

    @Override
    public Driver update(Driver driver) {
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement updateStatement =
                        connection.prepareStatement(UPDATE_REQUEST)) {
            updateStatement.setString(1, driver.getName());
            updateStatement.setString(2, driver.getLicenseNumber());
            updateStatement.setLong(3, driver.getId());
            updateStatement.executeUpdate();
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't update DB for drivers: "
                    + driver, e);
        }
    }

    @Override
    public boolean delete(Long id) {
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement deleteStatement =
                        connection.prepareStatement(DELETE_REQUEST)) {
            deleteStatement.setLong(1, id);
            return deleteStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete driver from DB with id: "
                    + id, e);
        }
    }

    private Driver getDriver(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getObject("id", Long.class);
        String name = resultSet.getString("name");
        String licenseNumber = resultSet.getString("license_number");
        return new Driver(id, name, licenseNumber);
    }
}
