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
        String createRequest = "INSERT INTO drivers (name, licenseNumber) "
                + "VALUES (?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement creteFormatStatement =
                        connection.prepareStatement(createRequest,
                                Statement.RETURN_GENERATED_KEYS)) {
            creteFormatStatement.setString(1, driver.getName());
            creteFormatStatement.setString(2, driver.getLicenseNumber());
            creteFormatStatement.executeUpdate();
            ResultSet generatedKeys = creteFormatStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Long id = generatedKeys.getObject(1, Long.class);
                driver.setId(id);
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can`t crete driver: " + driver, e);
        }
        return driver;
    }

    @Override
    public Optional<Driver> get(Long id) {
        String getRequest =
                "SELECT * FROM drivers WHERE id = ? AND is_deleted = FALSE";
        Driver driver = null;
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getFormatStatment =
                        connection.prepareStatement(getRequest)) {
            getFormatStatment.setLong(1,id);
            ResultSet resultSet = getFormatStatment.executeQuery();
            if (resultSet.next()) {
                driver = getDriver(resultSet);
            }
            return Optional.ofNullable(driver);
        } catch (SQLException e) {
            throw new DataProcessingException("Can`t get driver from db by id" + id, e);
        }
    }

    @Override
    public List<Driver> getAll() {
        String getAllReuarments = "SELECT * FROM drivers WHERE is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement
                        = connection.prepareStatement(getAllReuarments)) {
            List<Driver> driver = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                driver.add(getDriver(resultSet));
            }
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't get a list of driver "
                    + "from drivers table.", e);
        }
    }

    @Override
    public Driver update(Driver driver) {
        String updateReuarmets = "UPDATE drivers SET name = ?, licenseNumber = ? "
                + "WHERE is_deleted = FALSE AND id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement updateDriverStatement
                        = connection.prepareStatement(updateReuarmets)) {
            updateDriverStatement.setString(1, driver.getName());
            updateDriverStatement.setString(2, driver.getLicenseNumber());
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
        String query = "UPDATE drivers SET is_deleted = TRUE WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement
                        = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't delete a driver by id " + id, e);
        }
    }

    private Driver getDriver(ResultSet resultSet) {
        Driver driver = new Driver();
        try {
            driver.setId(resultSet.getObject(1, Long.class));
            driver.setName(resultSet.getString("name"));
            driver.setLicenseNumber(resultSet.getString("licenseNumber"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return driver;
    }
}
