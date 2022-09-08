package mate.jdbc.service;

import mate.jdbc.model.Driver;

import java.util.List;

public interface DriverService {
    Driver create(Driver driver);

    Driver read(Long id);

    List<Driver> readAll();

    Driver update(Driver driver);

    boolean delete(Long id);
}
