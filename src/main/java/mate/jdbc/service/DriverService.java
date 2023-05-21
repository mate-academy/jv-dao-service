package mate.jdbc.service;

import mate.jdbc.model.Driver;

import java.util.List;
import java.util.Optional;

public interface DriverService {
    Driver create(Driver driver);

    Optional<Driver> get(Long id);

    List<Driver> getAll();

    Driver update(Driver driver);

    boolean delete(Long id);
}
