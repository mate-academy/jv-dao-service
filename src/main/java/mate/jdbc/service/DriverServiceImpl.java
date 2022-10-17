package mate.jdbc.service;

import java.util.List;
import mate.jdbc.dao.DriverDao;
import mate.jdbc.dao.DriverDaoImpl;
import mate.jdbc.exception.DataProcessingException;
import mate.jdbc.lib.Inject;
import mate.jdbc.model.Driver;

@Inject
public class DriverServiceImpl implements DriverService {
    private final DriverDao driverDao = new DriverDaoImpl();

    @Override
    public Driver create(Driver driver) {
        return driverDao.create(driver);
    }

    @Override
    public Driver get(Long id) {
        try {
            return driverDao.get(id).orElseThrow();
        } catch (Exception e) {
            throw new DataProcessingException("Couldn't get driver by id " + id, e);
        }
    }

    @Override
    public List<Driver> getAll() {
        return driverDao.getAll();
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
