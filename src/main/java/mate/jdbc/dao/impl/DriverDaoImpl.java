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
    @Override
    public Driver create(Driver driver) {
        String createDriverQuery = "INSERT INTO drivers (name, license_number) " + "VALUES (?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement createDriverStatement
                        = connection.prepareStatement(createDriverQuery,
                        Statement.RETURN_GENERATED_KEYS)) {
            createDriverStatement.setString(1, driver.getName());
            createDriverStatement.setString(2, driver.getLicenceNumber());
            createDriverStatement.executeUpdate();
            ResultSet resultSet = createDriverStatement.getGeneratedKeys();
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
        String getDriverQuery = "SELECT * FROM drivers"
                + " WHERE id = ? AND is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getDriverStatement
                        = connection.prepareStatement(getDriverQuery)) {
            getDriverStatement.setLong(1, id);
            ResultSet resultSet = getDriverStatement.executeQuery();
            Driver driver = new Driver();
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
        String getAllDriversQuery = "SELECT * FROM drivers WHERE is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getAllDriversStatement
                        = connection.prepareStatement(getAllDriversQuery)) {
            List<Driver> drivers = new ArrayList<>();
            ResultSet resultSet = getAllDriversStatement.executeQuery();
            while (resultSet.next()) {
                drivers.add(getDriver(resultSet));
            }
            return drivers;
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't get a list of drivers "
                    + "from driver table.", e);
        }
    }

    @Override
    public Driver update(Driver driver) {
        String updateDriverQuery = "UPDATE drivers SET name = ?, license_number = ?"
                + " WHERE id = ? AND is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement updateDriverStatement
                        = connection.prepareStatement(updateDriverQuery)) {
            updateDriverStatement.setString(1, driver.getName());
            updateDriverStatement.setString(2, driver.getLicenceNumber());
            updateDriverStatement.setLong(3, driver.getId());
            updateDriverStatement.executeUpdate();
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't update a driver "
                    + driver, e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String deleteDriverQuery = "UPDATE drivers SET is_deleted = TRUE WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement deleteDriverStatement
                        = connection.prepareStatement(deleteDriverQuery)) {
            deleteDriverStatement.setLong(1, id);
            return deleteDriverStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't delete a driver by id " + id, e);
        }
    }

    private static Driver getDriver(ResultSet resultSet) throws SQLException {
        Driver driver = new Driver();
        driver.setId(resultSet.getObject("id", Long.class));
        driver.setName(resultSet.getString("name"));
        driver.setLicenceNumber(resultSet.getString("license_number"));
        return driver;
    }
}
