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
import mate.jdbc.lib.exception.DataProcessingException;
import mate.jdbc.model.Driver;
import mate.jdbc.util.ConnectionUtil;

@Dao
public class DriverDaoImpl implements DriverDao {
    @Override
    public Driver create(Driver driver) {
        String createRequest = "INSERT INTO drivers (name, license_number) "
                + "VALUES (?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement createDriverStatement
                        = connection.prepareStatement(createRequest, Statement.RETURN_GENERATED_KEYS)) {
            createDriverStatement.setString(1, driver.getName());
            createDriverStatement.setString(2, driver.getLicenseNumber());
            createDriverStatement.executeUpdate();
            ResultSet resultSet = createDriverStatement.getGeneratedKeys();
            if (resultSet.next()) {
                driver.setId(resultSet.getObject(1, Long.class));
            }
            return driver;
        } catch (SQLException throwable) {
            throw new DataProcessingException("Couldn't create driver " + driver + " in DB ",
                    throwable);
        }
    }

    @Override
    public Optional<Driver> get(Long id) {
        String getRequest = "SELECT * FROM drivers"
                + " WHERE id = (?) AND is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getDriverStatement = connection.prepareStatement(getRequest)) {
            getDriverStatement.setLong(1, id);
            ResultSet resultSet = getDriverStatement.executeQuery();
            Driver driver = null;
            if (resultSet.next()) {
                driver = getDriver(resultSet);
            }
            return Optional.ofNullable(driver);
        } catch (SQLException throwable) {
            throw new DataProcessingException("Couldn't get driver by id " + id + " from DB ",
                    throwable);
        }
    }

    @Override
    public List<Driver> getAll() {
        String getAllRequest = "SELECT * FROM drivers WHERE is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getAllDriversStatement
                        = connection.prepareStatement(getAllRequest)) {
            List<Driver> drivers = new ArrayList<>();
            ResultSet resultSet = getAllDriversStatement.executeQuery();
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
        String updateRequest = "UPDATE drivers SET name = ?, license_number = ?"
                + " WHERE id = ? AND is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement updateDriverStatement
                        = connection.prepareStatement(updateRequest)) {
            updateDriverStatement.setString(1, driver.getName());
            updateDriverStatement.setString(2, driver.getLicenseNumber());
            updateDriverStatement.setLong(3, driver.getId());
            updateDriverStatement.executeUpdate();
            return driver;
        } catch (SQLException throwable) {
            throw new DataProcessingException("Couldn't update a driver "
                    + driver + " in DB ", throwable);
        }
    }

    @Override
    public boolean delete(Long id) {
        String softDeleteRequest = "UPDATE drivers SET is_deleted = TRUE WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement deleteDriverStatement
                        = connection.prepareStatement(softDeleteRequest)) {
            deleteDriverStatement.setLong(1, id);
            return deleteDriverStatement.executeUpdate() > 0;
        } catch (SQLException throwable) {
            throw new DataProcessingException("Couldn't delete a driver by id " + id + " from DB ",
                    throwable);
        }
    }

    private Driver getDriver(ResultSet resultSet) throws SQLException {
        Long newId = resultSet.getObject("id", Long.class);
        String name = resultSet.getString("name");
        String licenseNumber = resultSet.getString("license_number");
        Driver driver = new Driver(name, licenseNumber);
        driver.setId(newId);
        return driver;
    }
}
