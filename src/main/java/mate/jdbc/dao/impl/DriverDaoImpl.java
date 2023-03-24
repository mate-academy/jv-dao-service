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
    private static final String ID_COLUMN = "id";
    private static final String NAME_COLUMN = "name";
    private static final String LICENSE_NUMBER_COLUMN = "license_number";

    @Override
    public Driver create(Driver driver) {
        String insertDriver = "INSERT INTO drivers (name, license_number) VALUES (?, ?);";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement createStatement = connection
                        .prepareStatement(insertDriver,Statement.RETURN_GENERATED_KEYS)) {
            createStatement.setString(1,driver.getName());
            createStatement.setString(2,driver.getLicenseNumber());
            createStatement.executeUpdate();
            ResultSet generateKeys =
                    createStatement.getGeneratedKeys();
            if (generateKeys.next()) {
                Long id = generateKeys.getObject(1, Long.class);
                driver.setId(id);
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't add to DB: " + driver, e);
        }
        return driver;
    }

    @Override
    public Optional<Driver> get(Long id) {
        String getDriver = "SELECT * FROM drivers WHERE is_deleted = FALSE AND id = ?;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getAllStatement = connection
                        .prepareStatement(getDriver)) {
            getAllStatement.setLong(1,id);
            ResultSet resultSet = getAllStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(createDriver(resultSet));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get driver with id: " + id, e);
        }
        return Optional.empty();
    }

    @Override
    public List<Driver> getAll() {
        List<Driver> drivers = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection();
                Statement getAllStatement = connection.createStatement()) {
            ResultSet resultSet = getAllStatement
                    .executeQuery("SELECT * FROM drivers WHERE is_deleted = FALSE;");
            while (resultSet.next()) {
                drivers.add(createDriver(resultSet));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get list of drivers from db", e);
        }
        return drivers;
    }

    @Override
    public Driver update(Driver driver) {
        String updateManufacturer = "UPDATE drivers SET name = ?, license_number = ?"
                + " WHERE id = ? AND is_deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement createStatement = connection
                        .prepareStatement(updateManufacturer)) {
            createStatement.setString(1,driver.getName());
            createStatement.setString(2,driver.getLicenseNumber());
            createStatement.setLong(3,driver.getId());
            createStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't update driver in DB: "
                    + driver, e);
        }
        return driver;
    }

    @Override
    public boolean delete(Long id) {
        String deleteRequest = "UPDATE drivers SET is_deleted = TRUE"
                + " WHERE id = ? AND is_deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement createStatement = connection
                        .prepareStatement(deleteRequest)) {
            createStatement.setLong(1,id);
            return createStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete driver by id: " + id, e);
        }
    }

    private Driver createDriver(ResultSet resultSet) {
        try {
            Long id = resultSet.getObject(ID_COLUMN,Long.class);
            String name = resultSet.getString(NAME_COLUMN);
            String licenseNumber = resultSet.getString(LICENSE_NUMBER_COLUMN);
            return new Driver(id,name,licenseNumber);
        } catch (SQLException e) {
            throw new DataProcessingException("Can't parse driver data from result set: "
                    + resultSet, e);
        }
    }
}
