package mate.jdbc.dao;

import java.util.List;
import mate.jdbc.model.Driver;

public interface DriverDao {
    Driver create(Driver driver);

    Object get(Long id);

    List<Driver> getAll();

    Driver update(Driver driver);

    boolean delete(Long id);
}
