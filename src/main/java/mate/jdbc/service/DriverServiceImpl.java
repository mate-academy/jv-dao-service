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
        driverDao.create(driver);
        return driver;
    }

    @Override
    public Driver read(Long id) {
        return driverDao.read(id).orElseThrow(
                () -> new RuntimeException("There are no driver with this id: "
                        + id + " in the DB.")
        );
    }

    @Override
    public List<Driver> readAll() {
        return driverDao.readAll();
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
