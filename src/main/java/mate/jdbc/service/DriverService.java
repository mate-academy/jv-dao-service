package mate.jdbc.service;

import java.util.List;
import mate.jdbc.dao.DriverDao;
import mate.jdbc.dao.DriverDaoImpl;
import mate.jdbc.lib.Inject;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Driver;

@Service
@Inject
public class DriverService {
    private DriverDao driverDao = new DriverDaoImpl();

    public Driver create(Driver driver) {
        return driverDao.create(driver);
    }

    public Driver get(Long id) {
        return driverDao.get(id).get();
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
