package mate.jdbc.service;

import java.util.List;
import java.util.Optional;
import mate.jdbc.dao.DriverServiceDao;
import mate.jdbc.lib.Inject;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Driver;

@Service
public class DriverServiceImpl implements DriverService {
    @Inject
    private DriverServiceDao driverServiceDao;

    @Override
    public Driver create(Driver driver) {
        return driverServiceDao.create(driver);
    }

    @Override
    public Optional<Driver> get(Long id) {
        return driverServiceDao.get(id);
    }

    @Override
    public List<Driver> getAll() {
        return driverServiceDao.getAll();
    }

    @Override
    public Driver update(Driver driver) {
        return driverServiceDao.update(driver);
    }

    @Override
    public boolean delete(Long id) {
        return driverServiceDao.delete(id);
    }
}
