package mate.jdbc.service.impl;

import java.util.List;
import java.util.Optional;
import mate.jdbc.dao.DriverDao;
import mate.jdbc.lib.Inject;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

@Service
public class DriverServiceImpl implements DriverService {
    @Inject
   private DriverDao driverDao;

    public DriverServiceImpl(DriverDao driverDao) {
        this.driverDao = driverDao;
    }

    @Override
    public Driver createDriver(Driver driver) {
        return driverDao.create(driver);
    }

    @Override
    public Optional<Driver> getDriver(Long id) {
        return driverDao.get(id);
    }

    @Override
    public List<Driver> getAllDriver() {
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
