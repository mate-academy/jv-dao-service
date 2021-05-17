package mate.jdbc.service;

import java.util.List;
import mate.jdbc.model.Driver;

public interface DriverService {
    Driver createDriver(Driver driver);

    Driver getDriver(Long id);

    List<Driver> getAllDrivers();

    Driver updateDriver(Driver driver);

    boolean deleteDriver(Long id);
}
