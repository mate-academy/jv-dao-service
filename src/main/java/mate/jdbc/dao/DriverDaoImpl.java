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
        String query = "INSERT INTO DRIVERS (name,license_number) VALUES(?,?)";
        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,driver.getName());
            preparedStatement.setString(2,driver.getLicenseNumber());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                driver.setId(resultSet.getObject(1,Long.class));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can`t create Driver", e);
        }
        return driver;
    }

    @Override
    public Optional<Driver> get(Long id) {
        String query = "SELECT * FROM drivers WHERE id=? AND is_deleted=false ";
        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement preparedStatement
                    = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Driver driver = new Driver();
            if (resultSet.next()) {
                driver = parseQuery(resultSet);
            }
            return Optional.ofNullable(driver);
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get driver by id = " + id, e);
        }
    }

    @Override
    public List<Driver> getAll() {
        String query = "SELECT * FROM drivers WHERE is_deleted = false";
        List<Driver> driver = new ArrayList<>();
        try {
            Connection connection = ConnectionUtil.getConnection();
            PreparedStatement preparedStatement
                    = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Driver driverNew = parseQuery(resultSet);
                driver.add(driverNew);
            }
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get all drivers", e);
        }
    }

    @Override
    public Driver update(Driver driver) {
        String query = "UPDATE drivers SET name = ?, license_number = ?"
                + " WHERE id = ? AND is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement
                        = connection.prepareStatement(query)) {
            statement.setString(1, driver.getName());
            statement.setString(2, driver.getLicenseNumber());
            statement.setLong(3, driver.getId());
            statement.executeUpdate();
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't update a driver "
                    + driver, e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String query = "UPDATE drivers SET is_deleted = TRUE WHERE id = ?;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        query)) {
            statement.setLong(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete driver.Id: " + id, e);
        }
    }

    public Driver parseQuery(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getObject("id",Long.class);
        String name = resultSet.getString("name");
        String licenseNum = resultSet.getString("license_number");
        Driver driver = new Driver(id,name,licenseNum);
        return driver;
    }
}
