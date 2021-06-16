package mate.jdbc.dao;

import mate.jdbc.lib.Dao;
import mate.jdbc.lib.exception.DataProcessingException;
import mate.jdbc.model.Driver;
import mate.jdbc.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Dao
public class DriverDaoImpl implements DriverDao{
    @Override
    public Driver create(Driver drivers) {
        String query = "INSERT INTO drivers (name, licenseNumber) "
                + "VALUES (?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement createDriverStatement
                     = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            createDriverStatement.setString(1, drivers.getName());
            createDriverStatement.setString(2, drivers.getLicenseNumber());
            createDriverStatement.executeUpdate();
            ResultSet resultSet = createDriverStatement.getGeneratedKeys();
            if (resultSet.next()) {
                drivers.setId(resultSet.getObject(1, Long.class));
            }
            return drivers;
        } catch (SQLException throwable) {
            throw  new DataProcessingException("Couldn't create drivers. " + drivers + " ",
                    throwable);
        }
    }

    @Override
    public Optional<Driver> get(Long id) {
        String query = "SELECT * FROM drivers"
                + " WHERE id = (?) AND is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement getDriverStatement = connection.prepareStatement(query)) {
            getDriverStatement.setLong(1, id);
            ResultSet resultSet = getDriverStatement.executeQuery();
            Driver drivers = null;
            if (resultSet.next()) {
                drivers = getDriver(resultSet);
            }
            return Optional.ofNullable(drivers);
        } catch (SQLException throwable) {
            throw new DataProcessingException("Couldn't get drivers by id " + id + " ",
                    throwable);
        }
    }

    @Override
    public List<Driver> getAll() {
        String query = "SELECT * FROM drivers WHERE is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement getAllDriversStatement
                     = connection.prepareStatement(query)) {
            List<Driver> drivers = new ArrayList<>();
            ResultSet resultSet = getAllDriversStatement.executeQuery();
            while (resultSet.next()) {
                drivers.add(getDriver(resultSet));
            }
            return drivers;
        } catch (SQLException throwable) {
            throw new DataProcessingException("Couldn't get a list of drivers "
                    + "from drivers table. ",
                    throwable);
        }
    }

    @Override
    public Driver update(Driver drivers) {
        String query = "UPDATE drivers SET name = ?, country = ?"
                + " WHERE id = ? AND is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement updateDriverStatement
                     = connection.prepareStatement(query)) {
            updateDriverStatement.setString(1, drivers.getName());
            updateDriverStatement.setString(2, drivers.getLicenseNumber());
            updateDriverStatement.setLong(3, drivers.getId());
            updateDriverStatement.executeUpdate();
            return drivers;
        } catch (SQLException throwable) {
            throw new DataProcessingException("Couldn't update a drivers "
                    + drivers + " ", throwable);
        }
    }

    @Override
    public boolean delete(Long id) {
        String query = "UPDATE drivers SET is_deleted = TRUE WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement deleteDriverStatement
                     = connection.prepareStatement(query)) {
            deleteDriverStatement.setLong(1, id);
            return deleteDriverStatement.executeUpdate() > 0;
        } catch (SQLException throwable) {
            throw new DataProcessingException("Couldn't delete a drivers by id " + id + " ",
                    throwable);
        }
    }

    private Driver getDriver(ResultSet resultSet) throws SQLException {
        Long newId = resultSet.getObject("id", Long.class);
        String name = resultSet.getString("name");
        String country = resultSet.getString("country");
        Driver drivers = new Driver(name, country);
        drivers.setId(newId);
        return drivers;
    }
}
