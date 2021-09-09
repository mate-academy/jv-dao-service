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
import mate.jdbc.model.Driver;
import mate.jdbc.util.ConnectionUtil;

@Dao
public class DriverDaoImpl implements DriverDao {
    @Override
    public Driver create(Driver driver) {
        String createDriverRequest = "INSERT INTO drivers(name, licenseNumber) values(?, ?);";

        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement createDriverStatement =
                        connection
                                .prepareStatement(createDriverRequest,
                                        Statement.RETURN_GENERATED_KEYS)) {
            createDriverStatement.setString(1, driver.getName());
            createDriverStatement.setString(2, driver.getLicenseNumber());
            createDriverStatement.executeUpdate();
            ResultSet generatedKeys = createDriverStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Long id = generatedKeys.getObject(1, Long.class);
                driver.setId(id);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Can't insert driver to DB" + driver, e);
        }
        return driver;
    }

    @Override
    public Optional<Driver> get(Long id) {
        String getDriverRequest = "SELECT * FROM drivers WHERE is_deleted = false AND id = ?;";

        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getDriverStatement =
                        connection.prepareStatement(getDriverRequest)) {
            getDriverStatement.setLong(1, id);
            getDriverStatement.executeQuery();
            ResultSet resultSet = getDriverStatement.getResultSet();
            if (resultSet.next()) {
                return Optional.of(getDriver(resultSet));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException("Can't get a driver for id #" + id + " from DB.", e);
        }
    }

    @Override
    public List<Driver> getAll() {
        List<Driver> allDrivers = new ArrayList<>();
        String getAllDriversRequest = "SELECT * FROM drivers WHERE is_deleted = false;";

        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getAllDriversStatement =
                        connection.prepareStatement(getAllDriversRequest)) {
            ResultSet resultSet = getAllDriversStatement.executeQuery(getAllDriversRequest);
            while (resultSet.next()) {
                allDrivers.add(getDriver(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Can't get all drivers from DB.", e);
        }
        return allDrivers;
    }

    @Override
    public Driver update(Driver driver) {
        String updateDriverRequest = "UPDATE drivers SET name = ?"
                + ", licenseNumber = ? WHERE id = ? AND is_deleted = false;";

        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement updateDriverStatement =
                        connection.prepareStatement(updateDriverRequest)) {
            updateDriverStatement.setString(1, driver.getName());
            updateDriverStatement.setString(2, driver.getLicenseNumber());
            updateDriverStatement.setLong(3, driver.getId());
            updateDriverStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Can't update driver " + driver, e);
        }
        return driver;
    }

    @Override
    public boolean delete(Long id) {
        String deleteDriverRequest = "UPDATE drivers SET is_deleted = true WHERE id = ?;";

        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement deleteDriverStatement =
                        connection
                                .prepareStatement(deleteDriverRequest,
                                        Statement.RETURN_GENERATED_KEYS)) {
            deleteDriverStatement.setLong(1, id);
            return deleteDriverStatement.executeUpdate() >= 1;
        } catch (SQLException e) {
            throw new RuntimeException("Can't delete driver id #" + id + " from DB.", e);
        }
    }

    private Driver getDriver(ResultSet resultSet) throws SQLException {
        return new Driver(
                resultSet.getObject("id", Long.class),
                resultSet.getString("name"),
                resultSet.getString("licenseNumber"));
    }

}
