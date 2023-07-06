package mate.jdbc.dao;

import java.util.Optional;
import java.util.List;
import mate.jdbc.model.Driver;


public interface DriverDao {
    Driver create(Driver driver);

    Optional<Driver> get(Long id);

    List<Driver> getAll();

    Driver update(Driver driver);

    boolean delete(Long id);
}
