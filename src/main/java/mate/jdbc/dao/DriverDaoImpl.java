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
        String insertDriverRequest = "INSERT INTO drivers (name, licenseNumber) VALUES(?,?);";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement preparedStatement = connection
                        .prepareStatement(insertDriverRequest, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, driver.getName());
            preparedStatement.setString(2, driver.getLicenseNumber());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                driver.setId(generatedKeys.getObject(1, Long.class));
            }
            return driver;
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't insert new Driver to DB. Driver: " + driver, e);
        }
    }

    @Override
    public Optional<Driver> get(Long id) {
        String selectDriverByIdRequest =
                "SELECT * FROM drivers WHERE is_deleted = false AND id = ?;";
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement selectDriverByIdStatement = connection
                        .prepareStatement(selectDriverByIdRequest)) {
            selectDriverByIdStatement.setLong(1, id);
            ResultSet resultSet = selectDriverByIdStatement.executeQuery();
            Driver driver = null;
            if (resultSet.next()) {
                driver = getDriver(resultSet);
            }
            return Optional.ofNullable(driver);
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't get Driver by id = " + id, e);
        }
    }

    @Override
    public List<Driver> getAll() {
        String selectAllRequest = "SELECT * FROM drivers WHERE is_deleted = false;";
        try (Connection connection = ConnectionUtil.getConnection();
                    PreparedStatement selectAllStatement = connection
                            .prepareStatement(selectAllRequest)) {
            ResultSet resultSet = selectAllStatement.executeQuery();
            List<Driver> allDataList = new ArrayList<>();
            while (resultSet.next()) {
                allDataList.add(getDriver(resultSet));
            }
            return allDataList;
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't get all data from DB", e);
        }
    }

    @Override
    public Driver update(Driver driver) {
        String updateDriverRequest = "UPDATE drivers SET name = ?,  licenseNumber = ?"
                + " WHERE id = ? AND is_deleted = false;";
        try (Connection connection = ConnectionUtil.getConnection();
                    PreparedStatement updateDriverStatement = connection
                            .prepareStatement(updateDriverRequest)) {
            updateDriverStatement.setString(1, driver.getName());
            updateDriverStatement.setString(2, driver.getLicenseNumber());
            updateDriverStatement.setLong(3, driver.getId());
            updateDriverStatement.executeUpdate();
            return driver;
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't update Driver in DB. Driver: " + driver, e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String deleteDriverRequest = "UPDATE drivers SET is_deleted = true WHERE id = ?;";
        try (Connection connection = ConnectionUtil.getConnection();
                    PreparedStatement deleteDriverStatement = connection
                            .prepareStatement(deleteDriverRequest,
                                    Statement.RETURN_GENERATED_KEYS)) {
            deleteDriverStatement.setLong(1, id);
            return deleteDriverStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't delete Driver from DB by id " + id, e);
        }
    }

    private Driver getDriver(ResultSet resultSet) throws SQLException {
        String name = resultSet.getString("name");
        String licenseNumber = resultSet.getString("licenseNumber");
        Driver driver = new Driver(name, licenseNumber);
        Long id = resultSet.getObject("id", Long.class);
        driver.setId(id);
        return driver;
    }
}
