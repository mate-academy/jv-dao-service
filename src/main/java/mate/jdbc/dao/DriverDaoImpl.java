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
        String queryInsertInto = "insert into driver (name,licenseNumber) values (?,?)";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(queryInsertInto,
                            Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, driver.getName());
            preparedStatement.setString(2, driver.getLicenseNumber());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                driver.setId(resultSet.getObject(1, Long.class));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't create driver. " + driver, e);
        }
        return driver;
    }

    @Override
    public Optional<Driver> get(Long id) {
        Driver driver = new Driver();
        String query = "select * from driver "
                + "where id = ? and driver_deleted = false";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long id1 = resultSet.getObject(1, Long.class);
                String name = resultSet.getString("name");
                String licenseNumber = resultSet.getString("licenseNumber");
                driver.setId(id1);
                driver.setName(name);
                driver.setLicenseNumber(licenseNumber);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't get driver by id " + id, e);
        }
        return Optional.ofNullable(driver);
    }

    @Override
    public List<Driver> getAll() {
        List<Driver> allDriver = new ArrayList<>();
        Driver driver;
        String query = "select * from driver where driver_deleted = false ";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                driver = new Driver();
                Long id = resultSet.getObject("id", Long.class);
                String name = resultSet.getString("name");
                String licenseNumber = resultSet.getString("licenseNumber");
                driver.setId(id);
                driver.setName(name);
                driver.setLicenseNumber(licenseNumber);
                allDriver.add(driver);
            }
            return allDriver;
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't get a list of driver "
                    + "from driver table.", e);
        }

    }

    @Override
    public Driver update(Driver driver) {
        String queryUpdate = "update driver set name = ?, licenseNumber = ? "
                + "where id = ? and driver_deleted = false";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(queryUpdate);
            preparedStatement.setString(1, driver.getName());
            preparedStatement.setString(2, driver.getLicenseNumber());
            preparedStatement.setLong(3, driver.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't update a driver "
                    + driver, e);
        }
        return driver;
    }

    @Override
    public boolean delete(Long id) {
        String deleteDriver = "update driver set driver_deleted = true where id = ?";
        try (Connection connection = ConnectionUtil.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteDriver);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't delete a manufacturer by id " + id, e);
        }
    }
}
