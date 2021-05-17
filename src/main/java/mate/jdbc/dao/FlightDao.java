package mate.jdbc.dao;

import java.util.List;
import java.util.Optional;
import mate.jdbc.model.Flight;

public interface FlightDao {
    Flight create(Flight flight);

    Optional<Flight> get(Long id);

    List<Flight> getAll();

    Flight update(Flight flight);

    boolean delete(Long id);

    boolean truncateTable();
}
