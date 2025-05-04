package mate.jdbc.service;

import java.util.List;
import mate.jdbc.model.Driver;

public interface DriverService {
    List<Driver> getAll();

    Driver get(Long id);

    Driver create(Driver driver);

    boolean delete(Long id);

    Driver update(Driver driver);
}
