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
import mate.jdbc.model.Driver;
import mate.jdbc.util.ConnectionUtil;

@Dao
public class DriverDaoImpl implements DriverDao {
    @Override
    public Driver create(Driver driver) {
        String queryInsertInto = "INSERT INTO driver (name,licenseNumber) VALUES (?,?)";
        try (Connection connection = ConnectionUtil.getConnection();PreparedStatement
                preparedStatement = connection.prepareStatement(queryInsertInto,
                             Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, driver.getName());
            preparedStatement.setString(2, driver.getLicenseNumber());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                driver.setId(resultSet.getObject(1, Long.class));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't create driver. " + driver, e);
        }
        return driver;
    }

    @Override
    public Optional<Driver> get(Long id) {
        String query = "SELECT * FROM driver "
                + "WHERE id = ? AND driver_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection(); PreparedStatement
                preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Driver driver = null;
            while (resultSet.next()) {
                driver = getDriver(resultSet);
            }
            return Optional.ofNullable(driver);
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't get driver by id " + id, e);
        }

    }

    @Override
    public List<Driver> getAll() {
        List<Driver> allDrivers = new ArrayList<>();
        String query = "SELECT * FROM driver WHERE driver_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection(); PreparedStatement
                preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                allDrivers.add(getDriver(resultSet));
            }
            return allDrivers;
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't get a list of driver "
                    + "from driver table.", e);
        }

    }

    @Override
    public Driver update(Driver driver) {
        String queryUpdate = "UPDATE driver SET name = ?, licenseNumber = ? "
                + "WHERE id = ? AND driver_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection(); PreparedStatement
                preparedStatement = connection.prepareStatement(queryUpdate);) {
            preparedStatement.setString(1, driver.getName());
            preparedStatement.setString(2, driver.getLicenseNumber());
            preparedStatement.setLong(3, driver.getId());
            preparedStatement.executeUpdate();
            return driver;
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't update a driver "
                    + driver, e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String deleteDriver = "UPDATE driver SET driver_deleted = TRUE WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection(); PreparedStatement
                preparedStatement = connection.prepareStatement(deleteDriver)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't delete a manufacturer by id " + id, e);
        }
    }

    private Driver getDriver(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getObject("id", Long.class);
        String name = resultSet.getString("name");
        String country = resultSet.getString("licenseNumber");
        return new Driver(id, name, country);
    }
}
