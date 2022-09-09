package mate.jdbc.service;

import java.util.List;
import mate.jdbc.model.Driver;

public interface DriverService {
    Driver create(Driver driver);

    mate.jdbc.model.Driver get(Long id);

    List<mate.jdbc.model.Driver> getAll();

    Driver update(Driver driver);

    boolean delete(Long id);
}
