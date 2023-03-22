package mate.jdbc.dao;

import java.util.List;
import mate.jdbc.model.Driver;

public interface DriverDao {
    public Driver create(Driver driver);

    public Driver get(Long id);

    public List<Driver> getAll();

    public Driver update(Driver driver);

    public boolean delete(Long id);
}
