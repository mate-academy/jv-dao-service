package mate.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import mate.jdbc.dao.DriverDao;
import mate.jdbc.lib.Dao;
import mate.jdbc.lib.exception.DataProcessingException;
import mate.jdbc.model.Driver;
import mate.jdbc.util.ConnectionUtil;

@Dao
public class DriverDaoImpl implements DriverDao {
    @Override
    public Driver create(Driver driver) {
        String insertDriverRequest = "INSERT INTO drivers (name, license_number) VALUES(?, ?);";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement createDriverStatement = connection.prepareStatement(
                        insertDriverRequest,
                        Statement.RETURN_GENERATED_KEYS)) {
            createDriverStatement.setString(1, driver.getName());
            createDriverStatement.setString(2, driver.getLicenseNumber());
            createDriverStatement.executeUpdate();
            ResultSet generatedKeys = createDriverStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                driver.setId(generatedKeys.getObject(1, Long.class));
            }
            return driver;
        } catch (SQLException throwable) {
            throw new DataProcessingException("Couldn't create driver. " + driver + " ",
                    throwable);
        }
    }

    @Override
    public Optional<Driver> get(Long id) {
        String selectDriverRequest = "SELECT * FROM drivers WHERE id = ? "
                + "AND is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement selectDriverStatement
                        = connection.prepareStatement(selectDriverRequest)) {
            selectDriverStatement.setLong(1, id);
            ResultSet resultSet = selectDriverStatement.executeQuery();
            Driver driver = null;
            if (resultSet.next()) {
                driver = getDriver(resultSet);
            }
            return Optional.ofNullable(driver);
        } catch (SQLException throwable) {
            throw new DataProcessingException("Couldn't get driver by id " + id + " ",
                    throwable);
        }
    }

    @Override
    public List<Driver> getAll() {
        String selectAllDriversRequest = "SELECT * FROM drivers  WHERE is_deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getConnection();
                Statement selectDriversStatement = connection.createStatement()) {
            List<Driver> driverList = new ArrayList<>();
            ResultSet resultSet = selectDriversStatement.executeQuery(selectAllDriversRequest);
            while (resultSet.next()) {
                driverList.add(getDriver(resultSet));
            }
            return driverList;
        } catch (SQLException throwable) {
            throw new DataProcessingException("Couldn't get a list of drivers "
                    + "from drivers table. ",
                    throwable);
        }
    }

    @Override
    public Driver update(Driver driver) {
        String updateDriverRequest = "UPDATE drivers SET name = ?, license_number = ? "
                + "WHERE id = ? AND is_deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement updateDriverStatement
                        = connection.prepareStatement(updateDriverRequest)) {
            updateDriverStatement.setString(1, driver.getName());
            updateDriverStatement.setString(2, driver.getLicenseNumber());
            updateDriverStatement.setLong(3, driver.getId());
            if (updateDriverStatement.executeUpdate() > 0) {
                return driver;
            }
            throw new NoSuchElementException(String.format(
                    "Driver %s doesn't exist in DB", driver.toString()));
        } catch (SQLException throwable) {
            throw new DataProcessingException("Couldn't update a driver "
                    + driver + " ", throwable);
        }
    }

    @Override
    public boolean delete(Long id) {
        String removeDriverRequest = "UPDATE drivers SET is_deleted = TRUE WHERE id = ?;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement removeDriverStatement
                        = connection.prepareStatement(removeDriverRequest)) {
            removeDriverStatement.setLong(1, id);
            return removeDriverStatement.executeUpdate() > 0;
        } catch (SQLException throwable) {
            throw new DataProcessingException("Couldn't delete a driver by id " + id + " ",
                    throwable);
        }
    }

    private Driver getDriver(ResultSet resultSet) throws SQLException {
        Driver driver = new Driver();
        driver.setId(resultSet.getObject("id", Long.class));
        driver.setName(resultSet.getString("name"));
        driver.setLicenseNumber(resultSet.getString("license_number"));
        return driver;
    }
}
