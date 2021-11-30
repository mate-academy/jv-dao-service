package mate.jdbc.service;

import java.util.List;
import mate.jdbc.dao.driver.DriverDao;
import mate.jdbc.lib.Inject;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Driver;

@Service
public class DriverServiceImpl implements DriverService {
    @Inject
    private DriverDao driverDao;

    @Override
    public Driver create(Driver driver) {
        long id = driverDao.getAll().stream()
                .filter(e -> e.getName().contains(driver.getName())
                        && e.getLicenseNumber().contains(driver.getLicenseNumber()))
                .mapToLong(Driver::getId)
                .min().orElse(0);
        if (id != 0 && driverDao.get(id).isPresent()) {
            return driverDao.get(id).get();
        }
        return driverDao.create(driver);
    }

    @Override
    public Driver get(Long id) {
        return driverDao.get(id).orElseThrow();
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
