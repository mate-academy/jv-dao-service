package mate.jdbc.service;

import java.util.List;
import java.util.Optional;
import mate.jdbc.dao.interfaces.DriverDao;
import mate.jdbc.lib.Inject;
import mate.jdbc.lib.Service;
import mate.jdbc.lib.exception.DataProcessingException;
import mate.jdbc.model.Driver;
import mate.jdbc.service.interfaces.DriverService;

@Service
public class DriverServiceImpl implements DriverService {
    @Inject
     private DriverDao driverDao;

    @Override
    public Driver create(Driver driver) {
        return driverDao.create(driver);
    }

    @Override
    public Driver get(Long id) {
        Optional<Driver> optional = driverDao.get(id);
        return optional.orElseThrow(() -> new DataProcessingException("Drivers isn't "
                + "exist by id: " + id));
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
