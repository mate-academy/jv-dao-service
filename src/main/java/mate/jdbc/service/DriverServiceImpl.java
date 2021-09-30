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
    public Driver create(Driver driver) {
        if (driver == null || (driver.getName() == null
                && driver.getLicenseNumber() == null)) {
            throw new RuntimeException("Can't insert driver with null values");
        }
        return driverDao.create(driver);
    }

    @Override
    public Driver get(Long id) {
        if (id == null) {
            throw new RuntimeException("Can't get driver by null id");
        }
        return driverDao.get(id).orElseThrow(()
                -> new RuntimeException("Driver with id " + id + " does not exist"));
    }

    @Override
    public List<Driver> getAll() {
        return driverDao.getAll();
    }

    @Override
    public Driver update(Driver driver) {
        if (driver == null || driver.getId() == null) {
            throw new RuntimeException("Can't update null value driver "
                    + "or driver with null id");
        }
        return driverDao.update(driver);
    }

    @Override
    public boolean delete(Long id) {
        if (id == null) {
            throw new RuntimeException("Can't delete driver by null id");
        }
        return driverDao.delete(id);
    }
}
