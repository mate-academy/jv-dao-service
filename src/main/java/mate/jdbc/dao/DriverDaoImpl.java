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
        String createRequest = "INSERT INTO drivers (name, licenseNumber) "
                + "VALUES (?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement createManufacturerStatement
                        = connection.prepareStatement(createRequest,
                        Statement.RETURN_GENERATED_KEYS)) {
            createManufacturerStatement.setString(1, driver.getName());
            createManufacturerStatement.setString(2, driver.getLicenseNumber());
            createManufacturerStatement.executeUpdate();
            ResultSet resultSet = createManufacturerStatement.getGeneratedKeys();
            if (resultSet.next()) {
                driver.setId(resultSet.getObject(1, Long.class));
            }
            return driver;
        } catch (SQLException throwable) {
            throw new DataProcessingException("Couldn't create manufacturer. " + driver + " ",
                    throwable);
        }
    }

    @Override
    public Optional<Driver> get(Long id) {
        String query = "SELECT * FROM drivers"
                + " WHERE id = (?) AND is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getManufacturerStatement = connection.prepareStatement(query)) {
            getManufacturerStatement.setLong(1, id);
            ResultSet resultSet = getManufacturerStatement.executeQuery();
            Driver driver = null;
            if (resultSet.next()) {
                driver = getManufacturer(resultSet);
            }
            return Optional.ofNullable(driver);
        } catch (SQLException throwable) {
            throw new DataProcessingException("Couldn't get manufacturer by id " + id + " ",
                    throwable);
        }
    }

    @Override
    public List<Driver> getAll() {
        String query = "SELECT * FROM drivers WHERE is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getAllManufacturersStatement
                           = connection.prepareStatement(query)) {
            List<Driver> drivers = new ArrayList<>();
            ResultSet resultSet = getAllManufacturersStatement.executeQuery();
            while (resultSet.next()) {
                drivers.add(getManufacturer(resultSet));
            }
            return drivers;
        } catch (SQLException throwable) {
            throw new DataProcessingException("Couldn't get a list of manufacturers "
                    + "from manufacturers table. ",
                    throwable);
        }
    }

    @Override
    public Driver update(Driver driver) {
        String query = "UPDATE drivers SET name = ?, licenseNumber = ?"
                + " WHERE id = ? AND is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement updateManufacturerStatement
                        = connection.prepareStatement(query)) {
            updateManufacturerStatement.setString(1, driver.getName());
            updateManufacturerStatement.setString(2, driver.getLicenseNumber());
            updateManufacturerStatement.setLong(3, driver.getId());
            updateManufacturerStatement.executeUpdate();
            return driver;
        } catch (SQLException throwable) {
            throw new DataProcessingException("Couldn't update a manufacturer "
                    + driver + " ", throwable);
        }
    }

    @Override
    public boolean delete(Long id) {
        String query = "UPDATE drivers SET is_deleted = TRUE WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement deleteManufacturerStatement
                        = connection.prepareStatement(query)) {
            deleteManufacturerStatement.setLong(1, id);
            return deleteManufacturerStatement.executeUpdate() > 0;
        } catch (SQLException throwable) {
            throw new DataProcessingException("Couldn't delete a manufacturer by id " + id + " ",
                    throwable);
        }
    }

    private Driver getManufacturer(ResultSet resultSet) throws SQLException {
        Long newId = resultSet.getObject("id", Long.class);
        String name = resultSet.getString("name");
        String licenseNumber = resultSet.getString("licenseNumber");
        Driver driver = new Driver(name, licenseNumber);
        driver.setId(newId);
        return driver;
    }
}
