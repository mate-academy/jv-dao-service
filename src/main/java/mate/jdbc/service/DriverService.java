package mate.jdbc.service;

import java.util.List;
import mate.jdbc.model.Driver;

public interface DriverService {
    Driver get(Long id);

    List<Driver> getAll();

    Driver create(Driver driver);

    Driver update(Driver driver);

    boolean delete(Long id);
}
