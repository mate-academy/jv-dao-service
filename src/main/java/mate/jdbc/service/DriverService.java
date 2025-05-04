package mate.jdbc.service;

import java.util.List;
import mate.jdbc.model.Driver;

public interface DriverService {
    Driver create(Driver driver);

    Driver get(Long id);

    Driver getByLicenseNumber(String licenseNumber);

    List<Driver> getAll();

    Driver update(Driver driver);

    boolean delete(Long id);
}
