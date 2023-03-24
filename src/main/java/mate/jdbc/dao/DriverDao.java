package mate.jdbc.dao;

import java.util.List;
import java.util.Optional;
import mate.jdbc.model.Driver;

public interface DriverDao {
    Optional<Driver> get(Long id);

    List<Driver> getAll();

    Driver create(Driver driver);

    Driver update(Driver driver);

    boolean delete(Long id);
}
