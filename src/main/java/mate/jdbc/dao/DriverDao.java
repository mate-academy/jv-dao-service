package mate.jdbc.dao;

import java.util.List;
import java.util.Optional;
import mate.jdbc.model.Driver;

public interface DriverDao {
    Driver create(Driver driver);

    Optional<Driver> read(Long id);

    List<Driver> readAll();

    Driver update(Driver driver);

    boolean delete(Long id);
}
