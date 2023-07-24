package mate.jdbc.service;

import java.util.List;
import java.util.Optional;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Driver;

@Service
public interface DriverService {
    Driver create(Driver driver);

    Optional<Driver> get(Long id);

    List<Driver> getAll();

    Driver update(Driver driver);

    boolean delete(Long id);
}
