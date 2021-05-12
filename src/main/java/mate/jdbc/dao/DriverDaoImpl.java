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
import mate.jdbc.lib.exception.DataInsertException;
import mate.jdbc.lib.exception.DataProcessingException;
import mate.jdbc.model.Driver;
import mate.jdbc.util.ConnectionUtil;

@Dao
public class DriverDaoImpl implements DriverDao {

    @Override
    public Driver create(Driver driver) {
        String insertDriverRequest = "INSERT INTO drivers (name,licenseNumber) values(?,?);";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement createDriverStatement =
                        connection.prepareStatement(insertDriverRequest,
                             Statement.RETURN_GENERATED_KEYS)) {
            createDriverStatement.setString(1, driver.getName());
            createDriverStatement.setString(2,driver.getLicenseNumber());
            createDriverStatement.executeUpdate();
            ResultSet generatedKeys = createDriverStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                driver.setId(generatedKeys.getObject(1, Long.class));
            }
        } catch (SQLException e) {
            throw new DataInsertException("Can`t insert driver: "
                    + driver.getName() + "to DB ", e);
        }
        return driver;
    }

    @Override
    public Optional<Driver> get(Long id) {
        String insertDriverRequest =
                "SELECT * FROM drivers WHERE id = ? and is_deleted = ?;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getDriversStatement =
                        connection.prepareStatement(insertDriverRequest)) {
            getDriversStatement.setLong(1,id);
            getDriversStatement.setLong(2, 0);
            ResultSet resultSet = getDriversStatement.executeQuery();
            Driver driver = null;
            if (resultSet.next()) {
                driver = setValuesFromDB(resultSet);
            }
            return Optional.of(driver);
        } catch (SQLException e) {
            throw new DataProcessingException("Can`t get driver for id: "
                    + id + " from DB", e);
        }
    }

    @Override
    public List<Driver> getAll() {
        String getAllDriversRequest = "SELECT * FROM drivers WHERE is_deleted = false";
        List<Driver> allDrivers = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection();
                Statement getAllDriversStatement = connection.createStatement()) {
            ResultSet resultSet =
                    getAllDriversStatement.executeQuery(getAllDriversRequest);
            while (resultSet.next()) {
                allDrivers.add(setValuesFromDB(resultSet));
            }
            return allDrivers;
        } catch (SQLException e) {
            throw new DataProcessingException("Can`t get all driver from DB", e);
        }
    }

    @Override
    public Driver update(Driver driver) {
        String updateRequest = "UPDATE drivers SET name = ?"
                + ", licenseNumber = ? WHERE id = ? and is_deleted = false;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement createDriverStatement =
                        connection.prepareStatement(updateRequest)) {
            createDriverStatement.setString(1, driver.getName());
            createDriverStatement.setString(2, driver.getLicenseNumber());
            createDriverStatement.setLong(3, driver.getId());
            if (createDriverStatement.executeUpdate() > 0) {
                return driver;
            }
            throw new RuntimeException("No such driver " + driver.getId());
        } catch (SQLException e) {
            throw new DataProcessingException("Can`t update driver for name: "
                    + driver.getName() + " from DB", e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String deleteRequest = "UPDATE drivers SET is_deleted = true where id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement createDriverStatement =
                        connection.prepareStatement(deleteRequest)) {
            createDriverStatement.setLong(1, id);
            return createDriverStatement.executeUpdate() >= 1;
        } catch (SQLException e) {
            throw new DataProcessingException("Can`t delete driver for id: "
                    + id + " from DB", e);
        }
    }

    public Driver setValuesFromDB(ResultSet resultSet) throws SQLException {
        Driver driver =
                new Driver(resultSet.getString("name"),
                        resultSet.getString("licenseNumber"));
        driver.setId(resultSet.getObject("id", Long.class));
        return driver;
    }
}
