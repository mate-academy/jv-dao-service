package mate.jdbc.dao.imp;

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
public class DriverDaoImp implements DriverDao {
    @Override
    public Driver create(Driver driver) {
        String insertDriverQuery =
                "INSERT INTO drivers(name,licence_number) VALUES(?, ?);";
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement statement
                         = connection.prepareStatement(insertDriverQuery,
                         Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, driver.getName());
            statement.setString(2, driver.getLicenseNumber());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                driver.setId(resultSet.getObject(1, Long.class));
            }
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't create driver: " + driver, e);
        }
    }

    @Override
    public Optional<Driver> get(Long id) {
        String getDriverQuery =
                "SELECT * FROM drivers WHERE id = ? AND is_deleted = false;";
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement getDriverById =
                         connection.prepareStatement(getDriverQuery)) {
            getDriverById.setLong(1, id);
            ResultSet resultSet = getDriverById.executeQuery();
            Driver driver = null;
            if (resultSet.next()) {
                driver = parseDriver(resultSet);
            }
            return Optional.ofNullable(driver);
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get driver by id " + id, e);
        }
    }

    @Override
    public List<Driver> getAll() {
        List<Driver> drivers = new ArrayList<>();
        String getAllDriverQuery =
                "SELECT * FROM drivers WHERE is_deleted = false";
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement getAllDriverStatement =
                         connection.prepareStatement(getAllDriverQuery)) {
            ResultSet resultSet = getAllDriverStatement.executeQuery();
            while (resultSet.next()) {
                drivers.add(parseDriver(resultSet));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get all drivers "
                    + drivers, e);
        }
        return drivers;
    }

    @Override
    public Driver update(Driver driver) {
        String updateDriverRequest =
                "UPDATE drivers SET name = ?, licence_number = ? WHERE  id = ?;";
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement updateDriverStatement =
                         connection.prepareStatement(updateDriverRequest)) {
            updateDriverStatement.setString(1, driver.getName());
            updateDriverStatement.setString(2, driver.getLicenseNumber());
            updateDriverStatement.setLong(3, driver.getId());
            updateDriverStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't update driver to DB "
                    + updateDriverRequest, e);
        }
        return driver;
    }

    @Override
    public boolean delete(Long id) {
        String deleteDriverRequest =
                "UPDATE drivers SET is_deleted = true WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement deleteDriverStatement =
                         connection.prepareStatement(deleteDriverRequest)) {
            deleteDriverStatement.setLong(1, id);
            return deleteDriverStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete drivers from DB :"
                    + id, e);
        }
    }

    private Driver parseDriver(ResultSet resultSet) {
        try {
            String driverName = resultSet.getString("name");
            String driverLicence = resultSet.getString("licenseNumber");
            Long driverId = resultSet.getObject("id", Long.class);
            return new Driver(driverId, driverName, driverLicence);
        } catch (SQLException e) {
            throw new DataProcessingException("Can't parse driver from result set "
                    + resultSet, e);
        }
    }
}
