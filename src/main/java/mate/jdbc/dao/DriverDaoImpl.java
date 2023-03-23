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
        String insertRequest = "INSERT INTO drivers(name, licenseNumber) VALUES (?, ?);";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement insertDriverStatement = connection
                        .prepareStatement(insertRequest, Statement.RETURN_GENERATED_KEYS)) {
            insertDriverStatement.setString(1, driver.getName());
            insertDriverStatement.setString(2, driver.getLicenseNumber());
            insertDriverStatement.executeUpdate();
            ResultSet generatedKeys = insertDriverStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Long id = generatedKeys.getObject(1, Long.class);
                driver.setId(id);
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't insert driver: " + driver + " to db", e);
        }
        return driver;
    }

    @Override
    public Optional<Driver> get(Long id) {
        String getRequest = "SELECT * FROM drivers WHERE id = ? AND is_deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getDriverStatement = connection
                        .prepareStatement(getRequest)) {
            getDriverStatement.setLong(1, id);
            ResultSet resultSet = getDriverStatement.executeQuery();
            Driver driver = new Driver();
            if (resultSet.next()) {
                driver = getDataFromResultSet(resultSet);
            }
            return Optional.of(driver);
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get driver with id: "
                    + id + " from db", e);
        }
    }

    @Override
    public List<Driver> getAll() {
        String getAllRequest = "SELECT * FROM drivers WHERE is_deleted = FALSE;";
        List<Driver> allDrivers = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getAllDriversStatement = connection
                        .prepareStatement(getAllRequest)) {
            ResultSet resultSet = getAllDriversStatement.executeQuery();
            while (resultSet.next()) {
                Driver driver = getDataFromResultSet(resultSet);
                allDrivers.add(driver);
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get all drivers from db", e);
        }
        return allDrivers;
    }

    @Override
    public Driver update(Driver driver) {
        String updateRequest = "UPDATE drivers SET name = ?, "
                + "licenseNumber = ?, is_deleted = FALSE WHERE id = ?;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement updateDriverStatement = connection
                        .prepareStatement(updateRequest)) {
            updateDriverStatement.setString(1, driver.getName());
            updateDriverStatement.setString(2, driver.getLicenseNumber());
            updateDriverStatement.setLong(3, driver.getId());
            updateDriverStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't update driver: " + driver, e);
        }
        return driver;
    }

    @Override
    public boolean delete(Long id) {
        String deleteRequest = "UPDATE drivers SET is_deleted = TRUE WHERE id = ?;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement deleteDriversStatement = connection
                        .prepareStatement(deleteRequest)) {
            deleteDriversStatement.setLong(1, id);
            return deleteDriversStatement.executeUpdate() >= 1;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete driver by id: " + id, e);
        }
    }

    private Driver getDataFromResultSet(ResultSet resultSet) {
        try {
            Long idOfDriver = resultSet.getObject("id", Long.class);
            String nameOfDriver = resultSet.getString("name");
            String licenseNumberOfDriver = resultSet.getString("licenseNumber");
            Driver driver = new Driver();
            driver.setId(idOfDriver);
            driver.setName(nameOfDriver);
            driver.setLicenseNumber(licenseNumberOfDriver);
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get data from ResultSet", e);
        }

    }
}
