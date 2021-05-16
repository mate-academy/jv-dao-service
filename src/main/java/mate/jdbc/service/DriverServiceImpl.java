package mate.jdbc.service;

import java.util.List;
import mate.jdbc.dao.DriverDao;
import mate.jdbc.lib.Inject;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Driver;

@Service
public class DriverServiceImpl implements DriverService {
    @Inject
    private DriverDao driverDao;

    @Override
    public Driver createDriver(Driver driver) {
        return driverDao.create(driver);
    }

    @Override
    public Driver getDriver(Long id) {
        return driverDao.get(id).orElseGet(() -> new Driver("", ""));
    }

    @Override
    public List<Driver> getAllDrivers() {
        return driverDao.getAll();
    }

    @Override
    public Driver updateDriver(Driver driver) {
        return driverDao.update(driver);
    }

    @Override
    public boolean deleteDriver(Long id) {
        return driverDao.delete(id);
    }
}
