package mate.jdbc.dao;

import java.util.List;
import java.util.Optional;
import mate.jdbc.model.Driver;

public interface DriverDao {
    List<Driver> getAll();

    Optional<Driver> get(Long id);

    Driver create(Driver driver);

    boolean delete(Long id);

    Driver update(Driver driver);
}

