package mate.jdbc.dao;

import mate.jdbc.model.Driver;

import java.util.List;
import java.util.Optional;

public class DriverDaoImpl implements DriverDao {
    @Override
    public Driver create(Driver driver) {
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
    public Driver update(Driver driver) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
