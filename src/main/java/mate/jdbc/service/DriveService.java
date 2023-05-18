package mate.jdbc.service;

import java.util.List;
import mate.jdbc.model.Driver;

public interface DriveService {
    Driver create(Driver driver);

    Driver get(Long id);

    List<Driver> getAll();

    Driver update(Driver driver);

    boolean delete(Long id);
}
