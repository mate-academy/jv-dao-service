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
    private DriverDao driverDaoDao;

    @Override
    public Driver create(Driver driver) {
        return driverDaoDao.create(driver);
    }

    @Override
    public Driver get(Long id) {
        return driverDaoDao.get(id).orElseThrow(() ->
                new RuntimeException("There is no driver, at id: " + id));
    }

    @Override
    public List<Driver> getAll() {
        return driverDaoDao.getAll();
    }

    @Override
    public Driver update(Driver driver) {
        return driverDaoDao.update(driver);
    }

    @Override
    public boolean delete(Long id) {
        return driverDaoDao.delete(id);
    }
}
