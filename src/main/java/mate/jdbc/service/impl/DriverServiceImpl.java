package mate.jdbc.service.impl;

import mate.jdbc.dao.DriverDao;
import mate.jdbc.lib.Inject;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {
    @Inject
    DriverDao driverDao;

    @Override
    public Driver create(Driver driver) {
        return driverDao.create(driver);
    }

    @Override
    public Driver get(Long id) {
        return null;
    }

    @Override
    public List<Driver> getAll() {
        return driverDao.getAll();
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
