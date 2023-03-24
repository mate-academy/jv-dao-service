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
    private static final String ID_COLUMN = "id";
    private static final String NAME_COLUMN = "name";
    private static final String LICENSE_NUMBER_COLUMN = "license_number";
    private static final int PARAMETER_INDEX_1 = 1;
    private static final int PARAMETER_INDEX_2 = 2;
    private static final int PARAMETER_INDEX_3 = 3;
    private static final int COLUMN_INDEX_1 = 1;

    @Override
    public Driver create(Driver driver) {
        String insertDriverQuery =
                "INSERT INTO drivers (name, license_number) VALUES (?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
                   PreparedStatement createDriverStatement =
                           connection.prepareStatement(insertDriverQuery,
                             Statement.RETURN_GENERATED_KEYS)) {
            createDriverStatement.setString(PARAMETER_INDEX_1, driver.getName());
            createDriverStatement.setString(PARAMETER_INDEX_2, driver.getLicenseNumber());
            createDriverStatement.executeUpdate();
            ResultSet generatedKeys = createDriverStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Long id = generatedKeys.getObject(COLUMN_INDEX_1, Long.class);
                driver.setId(id);
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't insert driver to DB" + driver, e);
        }
        return driver;
    }

    @Override
    public Optional<Driver> get(Long id) {
        String getDriverQuery =
                "SELECT * FROM drivers WHERE id = ? AND is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                   PreparedStatement getDriverStatement = connection
                           .prepareStatement(getDriverQuery)) {
            getDriverStatement.setLong(PARAMETER_INDEX_1, id);
            getDriverStatement.executeQuery();
            ResultSet resultSet = getDriverStatement.getResultSet();
            if (resultSet.next()) {
                return Optional.of(getDriverFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get driver by id", e);
        }
        return Optional.empty();
    }

    @Override
    public List<Driver> getAll() {
        String getAllDriversQuery = "SELECT * FROM drivers WHERE is_deleted = FALSE";
        List<Driver> allDrivers = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getAllDriversStatement = connection
                        .prepareStatement(getAllDriversQuery)) {
            ResultSet resultSet = getAllDriversStatement
                    .executeQuery(getAllDriversQuery);
            while (resultSet.next()) {
                allDrivers.add(getDriverFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Can't get all drivers from DB", e);
        }

        return allDrivers;
    }

    @Override
    public Driver update(Driver driver) {
        String updateQuery = "UPDATE drivers "
                + "SET name = ?, license_number = ? WHERE id = ? AND is_deleted = FALSE";
        try (Connection connection = ConnectionUtil.getConnection();
                     PreparedStatement updateStatement = connection
                             .prepareStatement(updateQuery)) {
            updateStatement.setString(PARAMETER_INDEX_1, driver.getName());
            updateStatement.setString(PARAMETER_INDEX_2, driver.getLicenseNumber());
            updateStatement.setLong(PARAMETER_INDEX_3, driver.getId());
            if (updateStatement.executeUpdate() > 0) {
                return driver;
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't update driver " + driver, e);
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        String deleteQuery = "UPDATE drivers SET is_deleted = "
                + "TRUE WHERE is_deleted = FALSE AND id = ?";
        try (Connection connection = ConnectionUtil.getConnection();
                     PreparedStatement deleteDriverStatement =
                            connection.prepareStatement(deleteQuery)) {
            deleteDriverStatement.setLong(1, id);
            return deleteDriverStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete driver from DB " + id, e);
        }
    }

    private Driver getDriverFromResultSet(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getObject(ID_COLUMN, Long.class);
        String name = resultSet.getString(NAME_COLUMN);
        String licenseNumber = resultSet.getString(LICENSE_NUMBER_COLUMN);
        return new Driver(id, name, licenseNumber);
    }
}
