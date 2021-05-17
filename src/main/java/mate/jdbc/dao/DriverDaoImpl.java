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
        String createDriverRequest = "INSERT INTO drivers(name, license_number) VALUES(?, ?);";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement createDriverStatement =
                        connection.prepareStatement(createDriverRequest,
                                Statement.RETURN_GENERATED_KEYS)) {
            createDriverStatement.setString(1, driver.getName());
            createDriverStatement.setString(2, driver.getLicenseNumber());
            createDriverStatement.executeUpdate();
            ResultSet generatedKeys = createDriverStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                driver.setId(generatedKeys.getObject("id", Long.class));
            }
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't add new driver to DB. "
                    + "Input params: " + driver, e);
        }
    }

    @Override
    public Optional<Driver> get(Long id) {
        String getDriverRequest = "SELECT * FROM drivers WHERE id = ? AND is_deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getDriverStatement =
                        connection.prepareStatement(getDriverRequest,
                        Statement.RETURN_GENERATED_KEYS)) {
            getDriverStatement.setLong(1, id);
            ResultSet resultSet = getDriverStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(createDriverObject(resultSet));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get driver by id. ID = " + id, e);
        }
    }

    @Override
    public List<Driver> getAll() {
        String getAllRequest = "SELECT * FROM drivers WHERE is_deleted = FALSE;";
        List<Driver> allDrivers = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection();
                Statement getAllStatement = connection.createStatement()) {
            ResultSet resultSet = getAllStatement.executeQuery(getAllRequest);
            while (resultSet.next()) {
                allDrivers.add(createDriverObject(resultSet));
            }
            return allDrivers;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get all drivers.", e);
        }
    }

    @Override
    public Driver update(Driver driver) {
        String updateDriverRequest = "UPDATE drivers "
                + "SET name = ?, license_number = ? "
                + "WHERE id = ? AND is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement updateDriverStatement =
                        connection.prepareStatement(updateDriverRequest)) {
            updateDriverStatement.setString(1, driver.getName());
            updateDriverStatement.setString(2, driver.getLicenseNumber());
            updateDriverStatement.setLong(3, driver.getId());
            updateDriverStatement.executeUpdate();
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't update data for driver: " + driver, e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String deleteDriverRequest = "UPDATE drivers "
                + "SET is_deleted = TRUE "
                + "WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement deleteDriverStatement =
                        connection.prepareStatement(deleteDriverRequest)) {
            deleteDriverStatement.setLong(1, id);
            return deleteDriverStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete driver by id = " + id, e);
        }
    }

    Driver createDriverObject(ResultSet resultSet) {
        try {
            Long id = resultSet.getObject("id", Long.class);
            String name = resultSet.getString("name");
            String licenseNumber = resultSet.getString("license_number");
            Driver driver = new Driver(name, licenseNumber);
            driver.setId(id);
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't create driver from output data.", e);
        }
    }
}
