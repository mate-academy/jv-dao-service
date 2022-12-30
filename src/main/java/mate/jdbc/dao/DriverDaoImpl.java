package mate.jdbc.dao;

import java.util.List;
import java.util.Optional;
import mate.jdbc.model.Driver;

public class DriverDaoImpl implements DriverDao {
    @Override
    public Driver create(Driver driver) {
        String insertQuery = "INSERT INTO "
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
