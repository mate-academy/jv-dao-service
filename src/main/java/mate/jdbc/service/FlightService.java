package mate.jdbc.service;

import java.util.List;
import mate.jdbc.model.Flight;

public interface FlightService {
    Flight create(Flight flight);

    Flight get(Long id);

    List<Flight> getAll();

    Flight update(Flight flight);

    boolean delete(Long id);

    boolean truncateTable();
}
