package mate.jdbc.dao;

import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface DriverDao {
    Manufacturer create(Driver driver);

    Optional<Manufacturer> get(Long id);

    List<Manufacturer> getAll();

    Manufacturer update(Driver driver);

    boolean delete(Long id);
}
