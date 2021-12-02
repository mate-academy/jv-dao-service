package mate.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mate.jdbc.lib.Dao;
import mate.jdbc.lib.exception.DataProcessingException;
import mate.jdbc.model.Driver;
import mate.jdbc.util.ConnectionUtil;

@Dao
public class DriverDaoImpl implements DriverDao {
    @Override
    public Driver create(Driver driver) {
        String query = "INSERT INTO drivers(name, license_number) "
                + "VALUES (?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement preparedStatement
                        = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, driver.getName());
            preparedStatement.setString(2, driver.getLicenseNumber());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                driver.setId(generatedKeys.getObject(1, Long.class));
            }
            return driver;
        } catch (SQLException throwable) {
            throw new DataProcessingException("Couldn't create driver. " + driver + " ", throwable);
        }
    }

    @Override
    public Driver get(Long id) {
        String query = "SELECT * FROM drivers"
                + " WHERE id = (?) AND is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Driver driver = null;
            if (resultSet.next()) {
                driver = getDriver(resultSet);
            }
            return driver;
        } catch (SQLException throwable) {
            throw new DataProcessingException("Couldn't get driver by id " + id + " ",
                    throwable);
        }
    }

    @Override
    public List<Driver> getAll() {
        String query = "SELECT * FROM drivers WHERE is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement preparedStatement
                        = connection.prepareStatement(query)) {
            List<Driver> drivers = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                drivers.add(getDriver(resultSet));
            }
            return drivers;
        } catch (SQLException throwable) {
            throw new DataProcessingException("Couldn't get a list of drivers "
                    + "from drivers table. ",
                    throwable);
        }
    }

    @Override
    public Driver update(Driver driver) {
        String query = "UPDATE drivers SET name = ?, license_Number = ?"
                + " WHERE id = ? AND is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement prepareStatement
                        = connection.prepareStatement(query)) {
            prepareStatement.setString(1, driver.getName());
            prepareStatement.setString(2, driver.getLicenseNumber());
            prepareStatement.setLong(3, driver.getId());
            prepareStatement.executeUpdate();
            return driver;
        } catch (SQLException throwable) {
            throw new DataProcessingException("Couldn't update a driver "
                    + driver + " ", throwable);
        }
    }

    @Override
    public boolean delete(Long id) {
        String query = "UPDATE drivers SET is_deleted = TRUE WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement prepareStatement
                           = connection.prepareStatement(query)) {
            prepareStatement.setLong(1, id);
            return prepareStatement.executeUpdate() > 0;
        } catch (SQLException throwable) {
            throw new DataProcessingException("Couldn't delete a driver by id " + id + " ",
                    throwable);
        }
    }

    private Driver getDriver(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getObject("id", Long.class);
        String name = resultSet.getString("name");
        String licenseNumber = resultSet.getString("license_number");
        Driver driver = new Driver(name, licenseNumber);
        driver.setId(id);
        return driver;
    }
}
