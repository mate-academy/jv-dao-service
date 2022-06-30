package mate.jdbc.dao;

import mate.jdbc.model.Driver;

import java.util.List;

public interface DriverDao {

    Driver create(Driver driver);

    Driver get(Long id);

    List<Driver> getAll();

    Driver update(Driver driver);

    boolean delete(Long id);
}
