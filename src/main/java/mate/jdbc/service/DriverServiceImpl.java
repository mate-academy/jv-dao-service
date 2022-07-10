package mate.jdbc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import mate.jdbc.dao.DriverDao;
import mate.jdbc.lib.Dao;
import mate.jdbc.lib.Inject;
import mate.jdbc.model.Driver;

@Dao
public class DriverServiceImpl implements DriverService {

    @Inject
    private DriverDao driverDao;

    @Override
    public Driver create(Driver driver) {
        return driverDao.create(driver);
    }

    @Override
    public Driver get(Long id) {
        Optional<Driver> optionalDriver = driverDao.get(id);
        if (optionalDriver.isPresent()) {
            return optionalDriver.get();
        }
        return null;

    }

    @Override
    public List<Driver> getAll() {

        List<Driver> allDrivers = new ArrayList<>();
        allDrivers = driverDao.getAll();
        return allDrivers;
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
