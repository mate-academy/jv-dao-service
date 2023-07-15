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
import mate.jdbc.exception.DataProcessingException;
import mate.jdbc.lib.Dao;
import mate.jdbc.model.Driver;
import mate.jdbc.util.ConnectionUtil;

@Dao
public class DriverDaoImpl implements DriverDao {
    @Override
    public Driver create(Driver driver) {
        try (Connection connection = ConnectionUtil.getConnection();
                  PreparedStatement statement = connection.prepareStatement(
                          Query.INSERT.string, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, driver.getName());
            statement.setString(2, driver.getLicenseNumber());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            generatedKeys.next();
            driver.setId(generatedKeys.getObject(1, Long.class));
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't insert driver. " + driver, e);
        }
    }

    @Override
    public Optional<Driver> get(Long id) {
        try (Connection connection = ConnectionUtil.getConnection();
                  PreparedStatement statement = connection.prepareStatement(
                          Query.SELECT_ALL.string + " AND id = ?")) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(getDriverFromResultSet(resultSet));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new DataProcessingException("Couldn't get manufacturer by id " + id, e);
        }
    }

    @Override
    public List<Driver> getAll() {
        try (Connection connection = ConnectionUtil.getConnection();
                  PreparedStatement preparedStatement = connection.prepareStatement(
                             Query.SELECT_ALL.string)) {
            List<Driver> driverList = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                driverList.add(getDriverFromResultSet(resultSet));
            }
            return driverList;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get drivers from DB!", e);
        }
    }

    @Override
    public Driver update(Driver driver) {
        try (Connection connection = ConnectionUtil.getConnection();
                  PreparedStatement statement = connection.prepareStatement(Query.UPDATE.string)) {
            statement.setString(1, driver.getName());
            statement.setString(2, driver.getLicenseNumber());
            statement.setLong(3, driver.getId());
            statement.executeUpdate();
            return driver;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't update driver!"
                    + driver, e);
        }
    }

    @Override
    public boolean delete(Long id) {
        try (Connection connection = ConnectionUtil.getConnection();
                  PreparedStatement preparedStatement =
                        connection.prepareStatement(Query.DELETE.string)) {
            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete driver with id " + id, e);
        }
    }

    private Driver getDriverFromResultSet(ResultSet resultSet) throws SQLException {
        Driver driver = new Driver();
        driver.setId(resultSet.getObject(1, Long.class));
        driver.setName(resultSet.getString(2));
        driver.setLicenseNumber(resultSet.getString(3));
        return driver;
    }

    private enum Query {
        SELECT_ALL("SELECT * FROM drivers WHERE is_deleted = FALSE"),
        INSERT("INSERT INTO drivers (name, license_number) VALUES (?, ?);"),
        UPDATE("UPDATE drivers SET name = ?, license_number = ? "
                + "WHERE id = ? AND is_deleted = FALSE;"),
        DELETE("UPDATE drivers SET is_deleted = TRUE WHERE id = ?");

        private String string;

        Query(String string) {
            this.string = string;
        }
    }
}
