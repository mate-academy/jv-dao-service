package mate.jdbc.dao;

import java.util.List;
import java.util.Optional;
import mate.jdbc.model.Driver;

public interface DriverDao {

    Driver create(Driver driver);

    Optional<Driver> get(Long id);

    List<Driver> getAll();

    boolean delete(Long id);

    Driver update(Driver manufacturer);

}
