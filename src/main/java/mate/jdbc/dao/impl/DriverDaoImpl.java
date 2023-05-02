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
import mate.jdbc.lib.Dao;
import mate.jdbc.lib.exception.DataProcessingException;
import mate.jdbc.model.Driver;
import mate.jdbc.util.ConnectionUtil;

@Dao
public class DriverDaoImpl implements DriverDao {
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_LICENCE = "licence_number";
    private static final String COLUMN_IS_DELETED = "is_deleted";
    private static final String QUERY_UPDATE = "UPDATE drivers "
            + "SET " + COLUMN_NAME + " = ?, " + COLUMN_LICENCE + " = ? "
            + "WHERE " + COLUMN_ID + " = ? " + "AND " + COLUMN_IS_DELETED + " IS FALSE;";
    private static final String QUERY_CREATE = "INSERT "
            + "INTO drivers(" + COLUMN_NAME + "," + COLUMN_LICENCE + ") "
            + "Values(?, ?);";
    private static final String QUERY_GET = "SELECT * "
            + "FROM drivers "
            + "WHERE " + COLUMN_ID + " = ? "
            + "AND " + COLUMN_IS_DELETED + " IS FALSE;";
    private static final String QUERY_GETALL = "SELECT * "
            + "FROM drivers "
            + "WHERE " + COLUMN_IS_DELETED + " IS FALSE;";
    private static final String QUERY_DELETE = "UPDATE drivers "
            + "SET " + COLUMN_IS_DELETED + " = TRUE "
            + "WHERE " + COLUMN_ID + " = ? "
            + "AND " + COLUMN_IS_DELETED + " IS FALSE;";
    private static final String GET_FAILED = "Failed to obtain driver with id: ";
    private static final String CREATE_FAILED = "Failed to create new driver with name= ";
    private static final String UPDATE_FAILED = "Failed to update driver with id: ";
    private static final String DELETE_FAILED = "Failed to delete driver with id: ";
    private static final String GET_ALL_FAILED = "Failed to read all drivers from db.";

    @Override
    public Driver create(Driver driver) {
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement createStatement = connection.prepareStatement(
                        QUERY_CREATE, Statement.RETURN_GENERATED_KEYS)) {
            createStatement.setString(1, driver.getName());
            createStatement.setString(2, driver.getLicenceNumber());
            createStatement.executeUpdate();
            ResultSet resultSet = createStatement.getGeneratedKeys();
            if (resultSet.next()) {
                driver.setId(resultSet.getObject(1, Long.class));
                return driver;
            } else {
                throw new DataProcessingException(GET_FAILED + driver.getId());
            }
        } catch (SQLException e) {
            throw new DataProcessingException(CREATE_FAILED + driver.getName(), e);
        }
    }

    @Override
    public Optional<Driver> get(Long id) {
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement getStatement = connection.prepareStatement(
                        QUERY_GET)) {
            getStatement.setLong(1, id);
            getStatement.executeQuery();
            return parseResult(getStatement.getResultSet()).stream().findFirst();
        } catch (SQLException e) {
            throw new DataProcessingException(GET_FAILED + id, e);
        }
    }

    @Override
    public List<Driver> getAll() {
        try (Connection connection = ConnectionUtil.getConnection();
                Statement getAllStatement = connection.createStatement()) {
            ResultSet resultSet = getAllStatement.executeQuery(
                    QUERY_GETALL);
            return parseResult(resultSet);
        } catch (SQLException e) {
            throw new DataProcessingException(GET_ALL_FAILED, e);
        }
    }

    @Override
    public Optional<Driver> update(Driver driver) {
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement updateStatement = connection.prepareStatement(
                        QUERY_UPDATE)) {
            updateStatement.setString(1, driver.getName());
            updateStatement.setString(2, driver.getLicenceNumber());
            updateStatement.setLong(3, driver.getId());
            updateStatement.executeUpdate();
            return Optional.of(driver);
        } catch (SQLException e) {
            throw new DataProcessingException(UPDATE_FAILED + driver.getId(), e);
        }
    }

    @Override
    public boolean delete(Long id) {
        try (Connection connection = ConnectionUtil.getConnection();
                PreparedStatement deleteStatement = connection.prepareStatement(
                        QUERY_DELETE)) {
            deleteStatement.setLong(1, id);
            return deleteStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DataProcessingException(DELETE_FAILED, e);
        }
    }

    private List<Driver> parseResult(ResultSet resultSet) throws SQLException {
        List<Driver> result = new ArrayList<>();
        while (resultSet.next()) {
            result.add(new Driver(
                    resultSet.getObject(COLUMN_ID, Long.class),
                    resultSet.getObject(COLUMN_NAME, String.class),
                    resultSet.getObject(COLUMN_LICENCE, String.class)));
        }
        return result;
    }
}
