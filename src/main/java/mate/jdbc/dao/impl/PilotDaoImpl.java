package mate.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import mate.jdbc.dao.PilotDao;
import mate.jdbc.exception.DataProcessingException;
import mate.jdbc.lib.Dao;
import mate.jdbc.model.Pilot;
import mate.jdbc.util.ConnectionUtil;

@Dao
public class PilotDaoImpl implements PilotDao {
    @Override
    public Pilot create(Pilot pilot) {
        String query = "INSERT INTO pilots (name, flight_number, carrier, manufacturer_id) "
                + "VALUES (?, ?, ?, ?);";
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement statement = connection
                         .prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, pilot.getName());
            statement.setString(2, pilot.getFlightNumber());
            statement.setString(3, pilot.getCarrier());
            statement.setLong(4, pilot.getManufacturer());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Long id = generatedKeys.getObject(1, Long.class);
                pilot.setId(id);
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't insert pilot to DB : "
                    + pilot, e);
        }
        return pilot;
    }

    @Override
    public Optional<Pilot> get(Long id) {
        String query = "SELECT * FROM pilots WHERE id = ? AND is_deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(getPilot(resultSet));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get pilot from DB by id = " + id, e);
        }
    }

    @Override
    public List<Pilot> getAll() {
        List<Pilot> pilots = new ArrayList<>();
        String query = "SELECT * FROM pilots WHERE is_deleted = false;";
        try (Connection connection = ConnectionUtil.getConnection();
                 Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                pilots.add(getPilot(resultSet));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get all pilots from DB", e);
        }
        return pilots;
    }

    @Override
    public Pilot update(Pilot pilot) {
        String query = "UPDATE pilots "
                + "SET name = ?, flight_number = ?, carrier = ?, manufacturer_id = ? "
                + "WHERE id = ? AND is_deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, pilot.getName());
            statement.setString(2, pilot.getFlightNumber());
            statement.setString(3, pilot.getCarrier());
            statement.setLong(4, pilot.getManufacturer());
            statement.setObject(5, pilot.getId());
            if (statement.executeUpdate() > 0) {
                return pilot;
            } else {
                throw new DataProcessingException("The pilot have illegal id or was deleted: "
                        + pilot);
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't update pilot in DB by id = "
                    + pilot.getId(), e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String query = "UPDATE pilots SET is_deleted = TRUE where id = ?;";
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete pilot from DB by id = " + id, e);
        }
    }

    private Pilot getPilot(ResultSet resultSet) throws SQLException {
        Pilot pilot = new Pilot();
        pilot.setId(resultSet.getObject("id", Long.class));
        pilot.setName(resultSet.getString("name"));
        pilot.setFlightNumber(resultSet.getString("flight_number"));
        pilot.setCarrier(resultSet.getString("carrier"));
        pilot.setManufacturer(resultSet.getObject("manufacturer_id", Long.class));
        return pilot;
    }
}
