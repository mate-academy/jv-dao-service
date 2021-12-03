package mate.jdbc.dao;

import java.util.List;
import java.util.Optional;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;

public interface DriverDao {
    Driver create(Driver driver);

    Optional<Driver> get(Long id);

    List<Driver> getAll();

    Driver update(Driver driver);

    boolean delete(Long id);
}
