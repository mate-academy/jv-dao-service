package mate.jdbc.dao;

import mate.jdbc.exception.DataProcessingException;
import mate.jdbc.lib.Dao;
import mate.jdbc.model.Driver;
import mate.jdbc.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Dao
public class DriverDaoImpl implements DriverDao {
    @Override
    public Driver create(Driver driver) {
        String insert = "INSERT INTO drivers(name, license_number) VALUES(?, ?);";
        try (Connection connection = ConnectionUtil.getConnection();
        PreparedStatement createStmt
                = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS)) {
            createStmt.setString(1, driver.getName());
            createStmt.setString(2, driver.getLicenseNumber());
            createStmt.executeUpdate();
            ResultSet resultSet = createStmt.getGeneratedKeys();
            while (resultSet.next()) {
                Long id = resultSet.getObject(1, Long.class);
                driver.setId(id);
            }
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Cannot create driver" + driver, e);
        }
    }

    @Override
    public Optional<Driver> get(Long id) {
        String select = "SELECT * FROM drivers WHERE id = ? AND is_deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getConnection();
        PreparedStatement selectStmt
                = connection.prepareStatement(select)) {
            selectStmt.setObject(1, id);
            ResultSet resultSet = selectStmt.executeQuery();
            Driver driver = null;
            if (resultSet.next()) {
                driver = convertToDriver(resultSet);
            }
            return Optional.ofNullable(driver);
        } catch (SQLException e) {
            throw new DataProcessingException("Cannot get driver by id: " + id, e);
        }
    }

    @Override
    public List<Driver> getAll() {
        String select = "SELECT * FROM drivers WHERE is_deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement selectStmt
                     = connection.prepareStatement(select)) {
            List<Driver> drivers = new ArrayList<>();
            ResultSet resultSet = selectStmt.executeQuery();
            while (resultSet.next()) {
                Driver driver = convertToDriver(resultSet);
                drivers.add(driver);
            }
            return drivers;
        } catch (SQLException e) {
            throw new DataProcessingException("Cannot get all drivers from drivers table", e);
        }
    }

    @Override
    public Driver update(Driver driver) {
        String update = "UPDATE drivers SET name = ?, "
                + "license_number = ? WHERE id = ? AND is_deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement updateStmt
                     = connection.prepareStatement(update)) {
            updateStmt.setString(1, driver.getName());
            updateStmt.setString(2, driver.getLicenseNumber());
            updateStmt.setObject(3, driver.getId());
            updateStmt.executeUpdate();
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Cannot update the driver: "+ driver, e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String delete = "UPDATE drivers SET is_deleted = TRUE WHERE id = ?;";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement updateStmt
                     = connection.prepareStatement(delete)) {
            updateStmt.setObject(1, id);
            return updateStmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DataProcessingException("Cannot delete the driver by id: "+ id, e);
        }
    }

    private Driver convertToDriver(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getObject("id", Long.class);
        String name = resultSet.getString("name");
        String licenseNumber = resultSet.getString("license_number");
        return new Driver(id, name, licenseNumber);
    }
}
