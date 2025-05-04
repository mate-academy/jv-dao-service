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
        String insertQuery = "INSERT INTO drivers (name, licence_number) "
                + "VALUES (?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement insertStatement =
                        connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
            insertStatement.setString(1, driver.getName());
            insertStatement.setString(2, driver.getLicenceNumber());
            insertStatement.executeUpdate();
            ResultSet generatedKeys = insertStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                driver.setId(generatedKeys.getObject(1, Long.class));
            }
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't create a driver " + driver, e);
        }
    }

    @Override
    public Optional<Driver> get(Long id) {
        String getQuery = "SELECT * FROM drivers"
                + " WHERE id = ? AND is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getStatement = connection.prepareStatement(getQuery)) {
            getStatement.setLong(1, id);
            ResultSet resultSet = getStatement.executeQuery();
            Driver driver = null;
            if (resultSet.next()) {
                driver = getDriver(resultSet);
            }
            return Optional.ofNullable(driver);
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't get driver by ID " + id, e);
        }
    }

    @Override
    public List<Driver> getAll() {
        String getAllQuery = "SELECT * FROM drivers"
                + " WHERE is_deleted = FALSE";
        List<Driver> driverList = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getStatement = connection.prepareStatement(getAllQuery)) {
            ResultSet resultSet = getStatement.executeQuery();
            while (resultSet.next()) {
                driverList.add(getDriver(resultSet));
            }
            return driverList;
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't get a list of drivers "
                    + "from drivers table.", e);
        }
    }

    @Override
    public Driver update(Driver driver) {
        String updateQuery = "UPDATE driver SET name = ?, licence_number = ?"
                + " WHERE id = ? AND is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement
                        = connection.prepareStatement(updateQuery)) {
            statement.setString(1, driver.getName());
            statement.setString(2, driver.getLicenceNumber());
            statement.setLong(3, driver.getId());
            statement.executeUpdate();
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't update a manufacturer "
                    + driver, e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String deleteQuery = "UPDATE drivers SET is_deleted = TRUE WHERE id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement
                        = connection.prepareStatement(deleteQuery)) {
            statement.setLong(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't delete a driver by id " + id, e);
        }
    }

    private Driver getDriver(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getObject("id", Long.class);
        String name = resultSet.getString("name");
        String licenceNumber = resultSet.getString("licence_number");
        return new Driver(id, name, licenceNumber);
    }
}
