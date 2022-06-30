package mate.jdbc.service;

import mate.jdbc.lib.Inject;
import mate.jdbc.model.Driver;

import java.util.List;

@Inject
public class DriverServiceImpl implements DriverService {
    @Inject
    private mate.jdbc.dao.DriverDao driverDao;

    @Override
    public Driver create(Driver driver) {
        return driverDao.create(driver);
    }

    @Override
    public Driver get(Long id) {
        return driverDao.get(id);
    }

    @Override
    public List<Driver> getAll() {
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
