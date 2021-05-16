package mate.jdbc.dao;

import java.util.List;
import java.util.Optional;
import mate.jdbc.model.Driver;

public interface DriverDao {
    Driver create(Driver driver);

    Optional<mate.jdbc.model.Driver> get(Long id);

    List<mate.jdbc.model.Driver> getAll();

    Driver update(Driver driver);

    boolean delete(Long id);
}
