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
    private Connection connection = ConnectionUtil.getConnection();

    @Override
    public Driver create(Driver driver) {
        String createDriverRequest = "INSERT INTO drivers (name, license_number)"
                + "VALUES (?, ?)";
        try (PreparedStatement createStatement = connection
                .prepareStatement(createDriverRequest, Statement.RETURN_GENERATED_KEYS)) {
            createStatement.setString(1, driver.getName());
            createStatement.setString(2, driver.getLicenseNumber());
            createStatement.executeUpdate();
            ResultSet resultSet = createStatement.getGeneratedKeys();
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
        String getDriverRequest = "SELECT * FROM drivers "
                + "WHERE id = ? AND is_deleted = false;";
        try (PreparedStatement getDriverStatement = connection.prepareStatement(getDriverRequest)) {
            getDriverStatement.setLong(1, id);
            ResultSet resultSet = getDriverStatement.executeQuery();
            Driver driver = null;
            if (resultSet.next()) {
                driver = getDriver(resultSet);
            }
            return Optional.ofNullable(driver);
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get driver form tablet drivers "
                    + "by index " + id, e);
        }
    }

    @Override
    public List<Driver> getAll() {
        String getAllDriversRequest = "SELECT * FROM drivers WHERE is_deleted = false;";
        try (PreparedStatement getAllDriversStatement
                     = connection.prepareStatement(getAllDriversRequest)) {
            List<Driver> drivers = new ArrayList<>();
            ResultSet resultSet = getAllDriversStatement.executeQuery();
            while (resultSet.next()) {
                drivers.add(getDriver(resultSet));
            }
            return drivers;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get add drivers from tablet drivers.", e);
        }
    }

    @Override
    public Driver update(Driver driver) {
        String updateDriverRequest = "UPDATE drivers SET name = ?, license_number = ?"
                + "WHERE id = ? AND is_deleted = false;";
        try (PreparedStatement updateDriverStatement
                     = connection.prepareStatement(updateDriverRequest)) {
            updateDriverStatement.setString(1, driver.getName());
            updateDriverStatement.setString(2, driver.getLicenseNumber());
            updateDriverStatement.setLong(3, driver.getId());
            updateDriverStatement.executeUpdate();
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't update a driver " + driver, e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String deleteDriversRequest = "UPDATE drivers SET is_deleted = true WHERE id = ?";
        try (PreparedStatement deleteDriversStatement
                     = connection.prepareStatement(deleteDriversRequest)) {
            deleteDriversStatement.setLong(1, id);
            return deleteDriversStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete driver by id " + id, e);
        }
    }

    private Driver getDriver(ResultSet resultSet) {
        try {
            Long id = resultSet.getObject("id", Long.class);
            String name = resultSet.getString("name");
            String licenseNumber = resultSet.getString("license_number");
            return new Driver(id, name, licenseNumber);
        } catch (SQLException e) {
            throw new DataProcessingException("Can't parse data from " + resultSet, e);
        }
    }
}
