package mate.jdbc.services.impl;

import mate.jdbc.dao.DriverDao;
import mate.jdbc.lib.Inject;
import mate.jdbc.model.Driver;
import mate.jdbc.services.Service;

import java.util.List;
import java.util.Optional;

@mate.jdbc.lib.Service
public class DriverService implements Service<Driver> {
    @Inject
    DriverDao driverDao;

    @Override
    public Driver create(Driver driver) {
        return driverDao.create(driver);
    }

    @Override
    public Optional<Driver> get(Long id) {
        return driverDao.get(id);
    }

    @Override
    public List<Driver> getALl() {
        return driverDao.getAll();
    }

    @Override
    public Driver update(Driver driver) {
        return driverDao.update(driver);
    }

    @Override
    public boolean delete(Long id) {
        return driverDao.delete(id);
    }
}
