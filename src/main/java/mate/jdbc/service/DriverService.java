package mate.jdbc.service;

import java.util.List;
import mate.jdbc.model.Driver;

public interface DriverService {

    public Driver create(Driver driver);

    public Driver get(Long id);

    public List<Driver> getAll();

    public Driver update(Driver driver);

    public boolean delete(Long id);
}
