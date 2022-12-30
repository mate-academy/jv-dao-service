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
        String insertQuery = "INSERT INTO drivers(name, licenseNumber) VALUES(?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement createPreparedStatement = connection
                        .prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
            createPreparedStatement.setString(1, driver.getName());
            createPreparedStatement.setString(2, driver.getLicenseNumber());
            createPreparedStatement.executeUpdate();
            ResultSet generatedKeys = createPreparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Long id = generatedKeys.getObject(1, Long.class);
                driver.setId(id);
                return driver;
            }
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't create driver. " + driver, e);
        }
    }

    @Override
    public Optional<Driver> get(Long id) {
        Driver driver = null;
        String selectQuery = "SELECT * FROM drivers WHERE is_deleted = FALSE AND id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getPreparedStatement
                        = connection.prepareStatement(selectQuery)) {
            getPreparedStatement.setLong(1, id);
            ResultSet resultSet = getPreparedStatement.executeQuery();
            if (resultSet.next()) {
                driver = createDriverFromResultSet(resultSet);
            }
            return Optional.ofNullable(driver);
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't get driver by id: " + id, e);
        }
    }

    @Override
    public List<Driver> getAll() {
        String selectQuery = "SELECT * FROM drivers WHERE is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getAllPreparedStatement =
                        connection.prepareStatement(selectQuery)) {
            List<Driver> drivers = new ArrayList<>();
            ResultSet resultSet = getAllPreparedStatement.executeQuery();
            while (resultSet.next()) {
                drivers.add(createDriverFromResultSet(resultSet));
            }
            return drivers;
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't get a list of drivers "
                    + "from drivers table.", e);
        }
    }

    @Override
    public Driver update(Driver driver) {
        String updateQuery = "UPDATE drivers SET name = ?, licenseNumber = ?"
                + " WHERE id = ? AND is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement updatePreparedStatement =
                        connection.prepareStatement(updateQuery)) {
            updatePreparedStatement.setString(1, driver.getName());
            updatePreparedStatement.setString(2, driver.getLicenseNumber());
            updatePreparedStatement.setLong(3, driver.getId());
            updatePreparedStatement.executeUpdate();
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't update a driver "
                    + driver, e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String deleteQuery = "UPDATE drivers SET is_deleted = TRUE WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement deletePreparedStatement =
                        connection.prepareStatement(deleteQuery)) {
            deletePreparedStatement.setLong(1, id);
            return deletePreparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't delete a driver by id " + id, e);
        }
    }

    private Driver createDriverFromResultSet(ResultSet resultSet) {
        try {
            Long id = resultSet.getObject("id", Long.class);
            String name = resultSet.getString("name");
            String licenseNumber = resultSet.getString("licenseNumber");
            Driver driver = new Driver();
            driver.setId(id);
            driver.setName(name);
            driver.setLicenseNumber(licenseNumber);
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Invalid data from resultSet: " + resultSet, e);
        }
    }
}
