package mate.jdbc.service;

import java.util.List;
import mate.jdbc.model.Driver;

public interface DriverService {
    Driver create(Driver e);

    Driver get(Long id);

    List<Driver> getAll();

    Driver update(Driver e);

    boolean delete(Long id);
}
