package mate.jdbc.service;

import mate.jdbc.dao.DriverDao;
import mate.jdbc.lib.Inject;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Driver;
import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {
    @Inject
    private DriverDao driverDao;

    @Override
    public Driver create(final Driver driver) {
        return driverDao.create(driver);
    }

    @Override
    public Driver get(final Long id) {
        return driverDao.get(id).get();
    }

    @Override
    public List<Driver> getAll() {
        return driverDao.getAll();
    }

    @Override
    public Driver update(final Driver driver) {
        return driverDao.update(driver);
    }

    @Override
    public boolean delete(final Long id) {
        return driverDao.delete(id);
    }
}
