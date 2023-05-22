package mate.jdbc.service;

import java.util.List;
import java.util.Optional;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Driver;

@Service
public interface DriverService {
    Driver createDriver(Driver driver);

    Optional<Driver> getDriver(Long id);

    List<Driver> getAllDriver();

    Driver updateDriver(Driver driver);

    boolean deleteDriver(Long id);
}
