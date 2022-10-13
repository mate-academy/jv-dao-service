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
        String insert = "INSERT INTO drivers(name, license_number) VALUES(?, ?);";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement createStm
                        = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS)) {
            createStm.setString(1, driver.getName());
            createStm.setString(2, driver.getLicenceNumber());
            createStm.executeUpdate();
            ResultSet resultSet = createStm.getGeneratedKeys();
            if (resultSet.next()) {
                Long id = resultSet.getObject(1, Long.class);
                driver.setId(id);
            }
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Can`t create driver " + driver, e);
        }
    }

    @Override
    public Optional<Driver> get(Long id) {
        String selectId = "SELECT FROM drivers WHERE id = ? AND is_deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement selectStm = connection.prepareStatement(selectId)) {
            selectStm.setLong(1,id);
            ResultSet resultSet = selectStm.executeQuery();
            Driver driver = null;
            if (resultSet.next()) {
                driver = convertToDriver(resultSet);
            }
            return Optional.ofNullable(driver);
        } catch (SQLException e) {
            throw new DataProcessingException("Can`t get driver by id: " + id, e);
        }
    }

    @Override
    public List<Driver> getAll() {
        String selectAll = "SELECT * FROM drivers WHERE is_deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement selectAllStm = connection.prepareStatement(selectAll)) {
            List<Driver> drivers = new ArrayList<>();
            ResultSet resultSet = selectAllStm.executeQuery();
            while (resultSet.next()) {
                Driver driver = convertToDriver(resultSet);
                drivers.add(driver);
            }
            return drivers;
        } catch (SQLException e) {
            throw new DataProcessingException("Can`t get all drivers from table drivers", e);
        }
    }

    @Override
    public Driver update(Driver driver) {
        String update = "UPDATE drivers SET name = ?"
                + "license_number = ? WHERE id = ? AND is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement updateStm = connection.prepareStatement(update)) {
            updateStm.setString(1,driver.getName());
            updateStm.setString(2, driver.getLicenceNumber());
            updateStm.setLong(3, driver.getId());
            updateStm.executeUpdate();
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Can`t update drivers db", e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String delete = "UPDATE drivers SET is_deleted = TRUE WHERE id = ?;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement deleteStm = connection.prepareStatement(delete)) {
            deleteStm.setLong(1,id);
            return deleteStm.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new DataProcessingException("Can`t delete driver by id: " + id, e);
        }
    }

    private Driver convertToDriver(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getObject("id", Long.class);
        String name = resultSet.getString("name");
        String licenseNumber = resultSet.getString("licenseNumber");
        return new Driver(id, name, licenseNumber);
    }
}
