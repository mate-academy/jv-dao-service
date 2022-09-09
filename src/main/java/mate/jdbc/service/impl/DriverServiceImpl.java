package mate.jdbc.service.impl;

import java.util.List;
import mate.jdbc.dao.impl.DriverServiceDaoImpl;
import mate.jdbc.lib.Inject;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

@Service
public class DriverServiceImpl implements DriverService {
    @Inject
    private DriverServiceDaoImpl driverServiceDao;

    @Override
    public Driver create(Driver driver) {
        return driverServiceDao.create(driver);
    }

    @Override
    public Driver get(Long id) {
        return driverServiceDao.get(id).orElseThrow(() ->
                new RuntimeException("Can't get Driver by id = " + id));
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
