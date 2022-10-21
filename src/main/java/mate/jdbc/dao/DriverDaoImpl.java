package mate.jdbc.dao;

import mate.jdbc.model.Driver;
import java.util.List;
import java.util.Optional;

public class DriverDaoImpl implements DriverDao {
    @Override
    public Driver create(final Driver driver) {
        return null;
    }

    @Override
    public Optional<Driver> get(final Long id) {
        return Optional.empty();
    }

    @Override
    public List<Driver> getAll() {
        return null;
    }

    @Override
    public Driver update(final Driver driver) {
        return null;
    }

    @Override
    public boolean delete(final Long id) {
        return false;
    }
}
