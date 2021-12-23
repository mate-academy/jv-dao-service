package mate.jdbc.service;

import java.util.List;
import mate.jdbc.model.Driver;

public interface DriverService {
    Driver create(Driver manufacturer);

    Driver get(Long id);

    List<Driver> getAll();

    Driver update(Driver manufacturer);

    boolean delete(Long id);
}
