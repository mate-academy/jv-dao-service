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
        String query = "INSERT INTO drivers(name, licenseNumber) values (?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement creatStatement = connection.prepareStatement(
                        query, Statement.RETURN_GENERATED_KEYS);) {

            creatStatement.setString(1, driver.getName());
            creatStatement.setString(2, driver.getLicenseNumber());
            creatStatement.executeUpdate();
            ResultSet resultSet = creatStatement.getGeneratedKeys();

            if (resultSet.next()) {
                driver.setId(resultSet.getObject(1, Long.class));
            }
            return driver;

        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't create manufacturer. " + driver, e);
        }
    }

    @Override
    public Optional<Driver> get(Long id) {
        String query = "SELECT * FROM drivers WHERE id = ? AND is_deleted = false";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getStatement = connection.prepareStatement(query);) {

            getStatement.setLong(1, id);
            ResultSet resultSet = getStatement.executeQuery();

            Driver driver = new Driver();
            if (resultSet.next()) {
                driver = getDriver(resultSet);
            }
            return Optional.ofNullable(driver);

        } catch (SQLException e) {
            throw new RuntimeException("Couldn't get driver by id " + id, e);
        }
    }

    @Override
    public List<Driver> getAll() {
        String query = "SELECT * FROM drivers WHERE is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getAllStatment = connection.prepareStatement(query)) {

            ResultSet resultSet = getAllStatment.executeQuery();
            List<Driver> drivers = new ArrayList<>();
            while (resultSet.next()) {
                drivers.add(getDriver(resultSet));
            }
            return drivers;

        } catch (SQLException e) {
            throw new RuntimeException("Couldn't get a list of drivers "
                    + "from drivers table.", e);
        }
    }

    @Override
    public Driver update(Driver driver) {
        String query = "UPDATE drivers SET name = ?, licenseNumber = ? "
                + "WHERE id = ? AND is_deleted = false";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement updateStatement = connection.prepareStatement(query)) {

            updateStatement.setString(1, driver.getName());
            updateStatement.setString(2, driver.getLicenseNumber());
            updateStatement.setLong(3, driver.getId());
            updateStatement.executeUpdate();

            return driver;

        } catch (SQLException e) {
            throw new RuntimeException("Couldn't update a driver " + driver, e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String query = "UPDATE drivers SET is_deleted = true WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement deleteStatement = connection.prepareStatement(query)) {

            deleteStatement.setLong(1, id);
            return (deleteStatement.executeUpdate() > 0);

        } catch (SQLException e) {
            throw new RuntimeException("Couldn't update a driver with ID " + id, e);
        }
    }

    private Driver getDriver(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getObject(1, Long.class);
        String name = resultSet.getString(2);
        String licenseNumber = resultSet.getString(3);
        return new Driver(id, name, licenseNumber);
    }
}
