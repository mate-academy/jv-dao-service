package mate.jdbc.dao;

import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import java.util.List;
import java.util.Optional;

public interface DriverDao {
    Driver create(Driver driver);

    Optional<Driver> get(Long id);

    List<Driver> getAll();

    Driver update(Driver driver);

    boolean delete(Long id);

    public void truncate();
}
