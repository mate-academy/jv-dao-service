package mate.jdbc.service;

import java.util.List;
import mate.jdbc.model.Driver;

public interface DriverService {
    Driver create(Driver driver);

    Driver read(Long id);

    List<Driver> readAll();

    Driver update(Driver driver);

    boolean delete(Long id);
}
