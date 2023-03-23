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
import mate.jdbc.model.Driver;
import mate.jdbc.util.ConnectionUtil;

public class DriverDaoImpl implements DriverDao {
    private static final String NAME = "name";
    private static final String LICENSE_NUMBER = "licenseNumber";
    private static final String ID = "id";
    private static final int PARAMETER_FIRST_INDEX = 1;
    private static final int PARAMETER_SECOND_INDEX = 2;
    private static final int PARAMETER_THIRD_INDEX = 3;

    @Override
    public List<Driver> getAll() {
        List<Driver> allDrivers = new ArrayList<>();
        String insertRequest = "SELECT * FROM drivers WHERE is_deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement getAllDriversStatement =
                     connection.prepareStatement(insertRequest)) {
            ResultSet resultSet = getAllDriversStatement.executeQuery();
            while (resultSet.next()) {
                Driver driver = getDriver(resultSet);
                allDrivers.add(driver);
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get all drivers from DB ", e);
        }
        return allDrivers;
    }

    @Override
    public Optional<Driver> get(Long id) {
        String insertRequest = "SELECT * FROM drivers WHERE is_deleted = FALSE AND id = ?;";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement getDriversStatement =
                     connection.prepareStatement(insertRequest)) {
            getDriversStatement.setLong(PARAMETER_FIRST_INDEX, id);
            ResultSet resultSet = getDriversStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(getDriver(resultSet));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get drivers from DB with that id: "
                    + id, e);
        }
    }

    @Override
    public Driver create(Driver driver) {
        String insertRequest =
                "INSERT INTO drivers (name, licenseNumber) VALUES (?, ?);";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement createDriverStatement =
                     connection.prepareStatement(insertRequest,
                             Statement.RETURN_GENERATED_KEYS)) {
            createDriverStatement.setString(PARAMETER_FIRST_INDEX,
                    driver.getName());
            createDriverStatement.setString(PARAMETER_SECOND_INDEX,
                    driver.getLicenseNumber());
            createDriverStatement.executeUpdate();
            ResultSet generatedKeys = createDriverStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Long id = generatedKeys.getObject(PARAMETER_FIRST_INDEX, Long.class);
                driver.setId(id);
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't insert driver to DB "
                    + driver, e);
        }
        return driver;
    }

    @Override
    public Driver update(Driver driver) {
        String updateRequest = "UPDATE drivers SET name = ?, licenseNumber = ? "
                + "WHERE id = ? AND is_deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement updateDriverStatement =
                     connection.prepareStatement(updateRequest)) {
            updateDriverStatement.setString(PARAMETER_FIRST_INDEX, driver.getName());
            updateDriverStatement.setString(PARAMETER_SECOND_INDEX,
                    driver.getLicenseNumber());
            updateDriverStatement.setLong(PARAMETER_THIRD_INDEX, driver.getId());
            updateDriverStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't update drivers from DB "
                    + driver, e);
        }
        return driver;
    }

    @Override
    public boolean delete(Long id) {
        String deleteRequest = "UPDATE drivers SET is_deleted = TRUE WHERE id = ?;";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement createDriverStatement =
                     connection.prepareStatement(deleteRequest)) {
            createDriverStatement.setLong(PARAMETER_FIRST_INDEX, id);
            return createDriverStatement.executeUpdate() != 0;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete driver from DB with that id: "
                    + id, e);
        }
    }

    private Driver getDriver(ResultSet resultSet) throws SQLException {
        String name = resultSet.getString(NAME);
        String license = resultSet.getString(LICENSE_NUMBER);
        Long id = resultSet.getObject(ID, Long.class);
        Driver driver = new Driver();
        driver.setId(id);
        driver.setName(name);
        driver.setLicenseNumber(license);
        return driver;
    }
}
