package mate.jdbc.dao.impl;

import mate.jdbc.lib.Dao;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;
import java.util.List;

@Dao
public class DriverDaoImpl implements DriverService {
    @Override
    public Driver create(Driver driver) {
        return null;
    }

    @Override
    public Driver get(Long id) {
        return null;
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
