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
    private DriverDao driverDao;

    @Override
    public Driver create(Driver model) {
        return driverDao.create(model);
    }

    @Override
    public Driver get(Long id) {
        Optional<Driver> optionalDriver = driverDao.get(id);
        return optionalDriver.get();
    }

    @Override
    public List<Driver> getAll() {
        return driverDao.getAll();
    }

    @Override
    public Driver update(Driver model) {
        return driverDao.update(model);
    }

    @Override
    public boolean delete(Long id) {
        return driverDao.delete(id);
    }
}
