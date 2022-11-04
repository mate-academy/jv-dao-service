package mate.jdbc.service.impl;

import java.util.List;
import mate.jdbc.dao.DriverDao;
import mate.jdbc.lib.Inject;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

@Service
public class DriverServiceImpl implements DriverService {
    @Inject
    private DriverDao driverDao;

    @Override
    public Driver create(Driver driver) {
        return driverDao.create(driver);
    }

    @Override
    public Driver get(Long id) {
        if (driverDao.get(id).isEmpty()) {
            throw new RuntimeException("Couldn't get driver by id " + id
                    + ". Driver does not exist");
        }
        return driverDao.get(id).get();
    }

    @Override
    public List<Driver> getAll() {
        List<Driver> drivers = driverDao.getAll();
        if (drivers.isEmpty()) {
            throw new RuntimeException("Couldn't get list of drivers. Data base is empty");
        }
        return drivers;
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
