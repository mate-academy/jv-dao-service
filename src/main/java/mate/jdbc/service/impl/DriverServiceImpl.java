package mate.jdbc.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
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
    public List<Driver> getAll() {
        return driverDao.getAll();
    }

    @Override
    public Driver create(Driver manufacturer) {
        return driverDao.create(manufacturer);
    }

    @Override
    public Driver get(Long id) {
        return driverDao.get(id).orElseThrow(() ->
                new NoSuchElementException("Can't get driver with that id: " + id));
    }

    @Override
    public Driver update(Driver manufacturer) {
        return driverDao.update(manufacturer);
    }

    @Override
    public boolean delete(Long id) {
        return driverDao.delete(id);
    }
}
