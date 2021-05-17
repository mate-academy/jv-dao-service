package mate.jdbc.service.impl;

import java.util.List;
import mate.jdbc.dao.FlightDao;
import mate.jdbc.exception.DataProcessingException;
import mate.jdbc.lib.Inject;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Flight;
import mate.jdbc.service.FlightService;

@Service
public class FlightServiceImpl implements FlightService {
    @Inject
    private FlightDao flightDao;

    @Override
    public Flight create(Flight flight) {
        return flightDao.create(flight);
    }

    @Override
    public Flight get(Long id) {
        return flightDao.get(id).orElseThrow(() ->
                new DataProcessingException("Can't get flight from DB by id = " + id));
    }

    @Override
    public List<Flight> getAll() {
        return flightDao.getAll();
    }

    @Override
    public Flight update(Flight flight) {
        return flightDao.update(flight);
    }

    @Override
    public boolean delete(Long id) {
        return flightDao.delete(id);
    }

    @Override
    public boolean truncateTable() {
        return flightDao.truncateTable();
    }

}
