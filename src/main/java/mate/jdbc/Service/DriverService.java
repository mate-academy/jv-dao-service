package mate.jdbc.Service;

import java.util.Optional;
import java.util.List;
import mate.jdbc.model.Driver;

public interface DriverService {
    Driver create(Driver driver);

    Optional<Driver> get(Long id);

    List<Driver> getAll();

    Driver update(Driver driver);

    boolean delete(Long id);
}
