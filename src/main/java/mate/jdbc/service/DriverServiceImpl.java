package mate.jdbc.service;

import java.util.List;
import mate.jdbc.dao.DriverDao;
import mate.jdbc.lib.Inject;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Driver;

@Service
public class DriverServiceImpl implements DriverService {
    @Inject
    private DriverDao manufacturerDao;

    @Override
    public Driver create(Driver manufacturer) {
        return manufacturerDao.create(manufacturer);
    }

    @Override
    public Driver get(Long id) {
        return manufacturerDao.get(id).orElseThrow();
    }

    @Override
    public List<Driver> getAll() {
        return manufacturerDao.getAll();
    }

    @Override
    public Driver update(Driver manufacturer) {
        return manufacturerDao.update(manufacturer);
    }

    @Override
    public boolean delete(Long id) {
        return manufacturerDao.delete(id);
    }
}
