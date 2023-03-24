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
    private static final String NAME_OF_DRIVER = "name";
    private static final String DRIVER_LICENSE_NUMBER = "license_number";
    private static final String ID_OF_DRIVER = "id";

    @Override
    public Driver create(Driver driver) {
        String insertDriverQuery =
                "INSERT INTO drivers(name, license_number) VALUES(?, ?);";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement createDriverStatement =
                        connection.prepareStatement(insertDriverQuery,
                        Statement.RETURN_GENERATED_KEYS)) {
            createDriverStatement.setString(1, driver.getName());
            createDriverStatement.setString(2, driver.getLicenseNumber());
            createDriverStatement.executeUpdate();
            ResultSet generatedKeys = createDriverStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Long id = generatedKeys.getObject(1, Long.class);
                driver.setId(id);
            }
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't create driver "
                    + "to DataBase " + driver, e);
        }
    }

    @Override
    public Optional<Driver> get(Long id) {
        String getDriverQuery = "SELECT * FROM drivers WHERE id = ? "
                + "AND is_deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getDriverStatement =
                        connection.prepareStatement(getDriverQuery)) {
            getDriverStatement.setLong(1, id);
            ResultSet resultSet = getDriverStatement.executeQuery();
            Driver driver = null;
            if (resultSet.next()) {
                driver = createDriverFromResultSet(resultSet);
            }
            return Optional.ofNullable(driver);
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get driver "
                    + "from DataBase by id = " + id, e);
        }
    }

    @Override
    public List<Driver> getAll() {
        List<Driver> drivers = new ArrayList<>();
        String driverQuery = "SELECT * FROM drivers WHERE is_deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getAllManufacturerStatement =
                        connection.prepareStatement(driverQuery)) {
            ResultSet resultSet = getAllManufacturerStatement.executeQuery();
            while (resultSet.next()) {
                drivers.add(createDriverFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get drivers from DataBase ", e);
        }
        return drivers;
    }

    @Override
    public Driver update(Driver driver) {
        String updateDriverQuery = "UPDATE drivers SET name = ?, license_number = ?"
                + "WHERE id = ? AND is_deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement updateDriverStatement =
                        connection.prepareStatement(updateDriverQuery)) {
            updateDriverStatement.setString(1,
                    driver.getName());
            updateDriverStatement.setString(2,
                    driver.getLicenseNumber());
            updateDriverStatement.setLong(3,
                    driver.getId());
            updateDriverStatement.executeUpdate();
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't update driver "
                    + "to DataBase " + driver, e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String driverToDeleteQuery =
                "UPDATE drivers SET is_deleted = TRUE WHERE id = ?;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement deleteDriverStatement =
                        connection.prepareStatement(driverToDeleteQuery)) {
            deleteDriverStatement.setLong(1, id);
            return deleteDriverStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete driver from DB " + id, e);
        }
    }

    private Driver createDriverFromResultSet(ResultSet resultSet) throws SQLException {
        String name = resultSet.getString(NAME_OF_DRIVER);
        String licenseNumber = resultSet.getString(DRIVER_LICENSE_NUMBER);
        Long id = resultSet.getObject(ID_OF_DRIVER, Long.class);
        return new Driver(id, name, licenseNumber);
    }
}
