package mate.jdbc.dao;

import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import java.util.List;
import java.util.Optional;

public class DriverDaoImpl implements DriverDao {
    @Override
    public Manufacturer create(Driver driver) {
        return null;
    }

    @Override
    public Optional<Driver> get(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Driver> getAll() {
        return null;
    }

    @Override
    public Manufacturer update(Driver driver) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
