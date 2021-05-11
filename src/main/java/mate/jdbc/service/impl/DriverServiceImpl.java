package mate.jdbc.service.impl;

import java.util.List;
import mate.jdbc.dao.driver.DriverDao;
import mate.jdbc.lib.Inject;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

@Service
public class DriverServiceImpl implements DriverService {
    @Inject
    private DriverDao driverDao;

    public Driver create(Driver driver) {
        return driverDao.create(driver);
    }

    public Driver get(Long id) {
        return driverDao.get(id).orElse(null);
    }

    public List<Driver> getAll() {
        return driverDao.getAll();
    }

    public Driver update(Driver driver) {
        return driverDao.update(driver);
    }

    public boolean delete(Long id) {
        return driverDao.delete(id);
    }
}
