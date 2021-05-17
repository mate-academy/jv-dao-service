package mate.jdbc.service;

import java.util.List;
import mate.jdbc.model.Driver;

public interface DriverService {
    Driver create(Driver driver);

    List<Driver> getAll();

    Driver get(Long id);

    Driver update(Driver driver);

    boolean delete(Long id);
}
