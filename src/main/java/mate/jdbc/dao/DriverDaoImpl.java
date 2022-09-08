package mate.jdbc.dao;

import java.util.List;
import java.util.Optional;
import mate.jdbc.lib.Dao;
import mate.jdbc.model.Driver;

@Dao
public class DriverDaoImpl implements DriverDao {
    @Override
    public Driver create(Driver driver) {
        return null;
    }

    @Override
    public Optional<Driver> read(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Driver> readAll() {
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
