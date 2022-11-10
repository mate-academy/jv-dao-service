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
        String query = "INSERT INTO drivers (name, license_number) VALUES (?, ?);";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, driver.getName());
            statement.setString(2, driver.getLicenseNumber());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                driver.setId(resultSet.getObject(1, Long.class));
            }
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't create driver" + driver, e);
        }
    }

    @Override
    public Optional<Driver> get(Long id) {
        String query = "SELECT * FROM drivers WHERE id = ? AND is_deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            Driver driver = null;
            if (resultSet.next()) {
                driver = parseResultSet(resultSet);
            }
            return Optional.ofNullable(driver);
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get driver by id = " + id, e);
        }
    }

    @Override
    public List<Driver> getAll() {
        List<Driver> driversList = new ArrayList<>();
        String query = "SELECT * FROM drivers WHERE is_deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getConnection();
                Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                driversList.add(parseResultSet(resultSet));
            }
            return driversList;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get all drivers", e);
        }
    }

    @Override
    public Driver update(Driver driver) {
        String query = "UPDATE drivers SET name = ?, license_number = ? "
                + "WHERE id = ? AND is_deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getConnection();
                   PreparedStatement statement = connection.prepareStatement(
                           query)) {
            statement.setString(1, driver.getName());
            statement.setString(2, driver.getLicenseNumber());
            statement.setLong(3, driver.getId());
            if (statement.executeUpdate() == 0) {
                throw new RuntimeException("Driver not found " + driver);
            }
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't update driver " + driver, e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String query = "UPDATE drivers SET is_deleted = TRUE WHERE id = ?;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        query)) {
            statement.setLong(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete driver with id = " + id, e);
        }
    }

    private Driver parseResultSet(ResultSet resultSet) throws SQLException {
        Driver driver = new Driver();
        Long id = resultSet.getObject("id", Long.class);
        String name = resultSet.getString("name");
        String licenseNumber = resultSet.getString("license_number");
        driver.setId(id);
        driver.setName(name);
        driver.setLicenseNumber(licenseNumber);
        return driver;
    }
}
