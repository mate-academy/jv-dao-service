package mate.jdbc.dao;

import java.util.List;
import mate.jdbc.model.Driver;

public interface DriverDao {

    Driver create(Driver driver);

    Driver get(Long id);

    List<Driver> getALl();

    Driver update(Driver driver);

    boolean delete(Long id);
}
