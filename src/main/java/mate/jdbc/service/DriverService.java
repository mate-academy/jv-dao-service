package mate.jdbc.service;

import java.util.List;
import java.util.Optional;
import mate.jdbc.model.Driver;

public interface DriverService {
    List<Driver> getAll();

    Driver create(Driver driver);

    Optional<Driver> get(Long id);

    Driver update(Driver driver);

    boolean delete(Long id);
}
