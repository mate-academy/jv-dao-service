package mate.jdbc.service;

import java.util.List;
import java.util.Optional;
import mate.jdbc.model.Driver;

public interface DriverService {
    Driver create(Driver manufacturer);

    Optional<Driver> get(Long id);

    List<Driver> getAll();

    Driver update(Driver manufacturer);

    boolean delete(Long id);
}
