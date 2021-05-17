package mate.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import mate.jdbc.dao.FlightDao;
import mate.jdbc.exception.DataProcessingException;
import mate.jdbc.lib.Dao;
import mate.jdbc.model.Flight;
import mate.jdbc.util.ConnectionUtil;

@Dao
public class FlightDaoImpl implements FlightDao {
    @Override
    public Flight create(Flight flight) {
        String query = "INSERT INTO flights(number, carrier, manufacturer_id) VALUES (?, ?, ?);";
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement statement = connection
                         .prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, flight.getNumber());
            statement.setString(2, flight.getCarrier());
            statement.setLong(3, flight.getManufacturer());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Long id = generatedKeys.getObject(1, Long.class);
                flight.setId(id);
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't insert flight to DB : "
                    + flight, e);
        }
        return flight;
    }

    @Override
    public Optional<Flight> get(Long id) {
        String query = "SELECT * FROM flights WHERE id = ? AND is_deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(getFlight(resultSet));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get flight from DB by id = " + id, e);
        }
    }

    @Override
    public List<Flight> getAll() {
        List<Flight> flights = new ArrayList<>();
        String query = "SELECT * FROM flights WHERE is_deleted = false;";
        try (Connection connection = ConnectionUtil.getConnection();
                 Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                flights.add(getFlight(resultSet));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't get all flights from DB", e);
        }
        return flights;
    }

    @Override
    public Flight update(Flight flight) {
        String query = "UPDATE flights SET  number = ?, carrier = ?, manufacturer_id = ?"
                + " WHERE id = ? AND is_deleted = FALSE;";
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, flight.getNumber());
            statement.setString(2, flight.getCarrier());
            statement.setLong(3, flight.getManufacturer());
            statement.setObject(4, flight.getId());
            if (statement.executeUpdate() > 0) {
                return flight;
            } else {
                throw new DataProcessingException("The flight have illegal id or was deleted: "
                        + flight);
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't update flight in DB by id = "
                    + flight.getId(), e);
        }
    }

    @Override
    public boolean delete(Long id) {
        String query = "UPDATE flights SET is_deleted = TRUE where id = ?;";
        try (Connection connection = ConnectionUtil.getConnection();
                 PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setLong(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DataProcessingException("Can't delete flight from DB by id = " + id, e);
        }
    }

    private Flight getFlight(ResultSet resultSet) throws SQLException {
        Flight flight = new Flight();
        flight.setId(resultSet.getObject("id", Long.class));
        flight.setNumber(resultSet.getString("number"));
        flight.setCarrier(resultSet.getString("carrier"));
        flight.setManufacturer(resultSet.getObject("manufacturer_id", Long.class));
        return flight;
    }
}
