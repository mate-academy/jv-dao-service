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
        String query = "INSERT INTO `drivers` (`name`, `license_number`) VALUES (?, ?);";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement createDriverStatement = connection.prepareStatement(query,
                          Statement.RETURN_GENERATED_KEYS)) {
            createDriverStatement.setString(1, driver.getName());
            createDriverStatement.setString(2, driver.getLicenseNumber());
            createDriverStatement.executeUpdate();
            ResultSet generatedKeys = createDriverStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                driver.setId(generatedKeys.getObject(1, Long.class));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't create driver " + driver + " ", e);
        }
        return driver;
    }

    @Override
    public Optional<Driver> get(Long id) {
        String query = "SELECT * FROM `drivers` WHERE `id` = ? AND `deleted` = false;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getDriverByIdStatement = connection.prepareStatement(query)) {
            getDriverByIdStatement.setLong(1, id);
            ResultSet resultSet = getDriverByIdStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(parseDriver(resultSet));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't get driver by id = " + id + " ", e);
        }
    }

    @Override
    public List<Driver> getAll() {
        String query = "SELECT * FROM `drivers` WHERE `deleted` = false;";
        try (Connection connection = ConnectionUtil.getConnection();
                Statement getAllDriversStatement = connection.createStatement()) {
            ResultSet resultSet = getAllDriversStatement.executeQuery(query);
            List<Driver> drivers = new ArrayList<>();
            while (resultSet.next()) {
                drivers.add(parseDriver(resultSet));
            }
            return drivers;
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't get a list of manufacturers "
                    + "from drivers table. ", e);
        }
    }

    @Override
    public Driver update(Driver driver) {
        String query = "UPDATE `drivers` SET `name` = ?, `license_number` = ?"
                + " WHERE `id` = ? AND `deleted` = false;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement updateDriverStatement = connection.prepareStatement(query)) {
            updateDriverStatement.setString(1, driver.getName());
            updateDriverStatement.setString(2, driver.getLicenseNumber());
            updateDriverStatement.setObject(3, driver.getId());
            updateDriverStatement.executeUpdate();
            return driver;
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't update driver " + driver + " ", e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String query = "UPDATE `drivers` SET `deleted` = true WHERE `id` = ?;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement deleteDriverStatement = connection.prepareStatement(query)) {
            deleteDriverStatement.setLong(1, id);
            return deleteDriverStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't delete driver id = " + id + " " + e);
        }
    }

    private Driver parseDriver(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getObject(1, Long.class);
        String name = resultSet.getString("name");
        String licenseNumber = resultSet.getString("license_number");
        Driver driver = new Driver(name, licenseNumber);
        driver.setId(id);
        return driver;
    }
}
