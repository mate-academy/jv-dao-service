package mate.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import mate.jdbc.dao.DriverDao;
import mate.jdbc.lib.Dao;
import mate.jdbc.model.Driver;
import mate.jdbc.util.ConnectionUtil;

@Dao
public class DriverDaoImpl implements DriverDao {
    @Override
    public Driver create(Driver driver) {
        String insertDriverRequest =
                "INSERT INTO drivers (name, license_number) "
                        + "VALUES (?, ?);";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement createDriverStatement
                         = connection.prepareStatement(insertDriverRequest,
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
            throw new RuntimeException("Can't insert driver to DB " + driver, e);
        }
    }

    @Override
    public Optional<Driver> get(Long id) {
        String getDriverRequest =
                "SELECT * FROM drivers WHERE id = ? AND is_deleted = false;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getDriverById =
                         connection.prepareStatement(getDriverRequest)) {
            getDriverById.setLong(1, id);
            ResultSet resultSet = getDriverById.executeQuery();
            Driver driver = null;
            if (resultSet.next()) {
                driver = parseDriver(resultSet);
            }
            return Optional.ofNullable(driver);
        } catch (SQLException e) {
            throw new RuntimeException("Can't get driver by id " + id, e);
        }
    }

    @Override
    public List<Driver> getAll() {
        List<Driver> allDrivers = new ArrayList<>();
        String getAllDrivers =
                "SELECT * FROM drivers WHERE is_deleted = false";
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement getAllDriversStatement =
                         connection.prepareStatement(getAllDrivers)) {
            ResultSet resultSet = getAllDriversStatement.executeQuery();
            while (resultSet.next()) {
                allDrivers.add(parseDriver(resultSet));
            }
            return allDrivers;
        } catch (SQLException e) {
            throw new RuntimeException("Can't get all drivers from DB "
                    + allDrivers, e);
        }
    }

    @Override
    public Driver update(Driver driver) {
        String updateDriverRequest =
                "UPDATE drivers SET name = ?, license_number = ? WHERE id = ?;";
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement updateDriverStatement =
                         connection.prepareStatement(updateDriverRequest)) {
            updateDriverStatement.setString(1, driver.getName());
            updateDriverStatement.setString(2, driver.getLicenseNumber());
            updateDriverStatement.setLong(3, driver.getId());
            updateDriverStatement.executeUpdate();
            return driver;
        } catch (SQLException e) {
            throw new RuntimeException("Can't update drivers to DB "
                    + updateDriverRequest, e);
        }
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
            throw new RuntimeException("Can't delete drivers from DB "
                    + deleteDriverRequest, e);
        }
    }

    private Driver parseDriver(ResultSet resultSet) throws SQLException {
        String name = resultSet.getString("name");
        String licenseNumber = resultSet.getString("license_number");
        Long id = resultSet.getObject("id", Long.class);
        return new Driver(id, name, licenseNumber);
    }
}
