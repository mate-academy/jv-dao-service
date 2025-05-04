package mate.jdbc.service;

import java.util.List;
import mate.jdbc.dao.DriverDao;
import mate.jdbc.lib.Inject;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Driver;

@Service
public class DriverServiceImpl implements DriverService {
    @Inject
    private static DriverDao dao;

    @Override
    public Driver create(Driver driver) {
        return dao.create(driver);
    }

    @Override
    public Driver get(Long id) {
        return dao.get(id).orElseThrow(() -> new RuntimeException("No such driver by id: " + id));
    }

    @Override
    public List<Driver> getAll() {
        return dao.getAll();
    }

    @Override
    public Driver update(Driver driver) {
        return dao.update(driver);
    }

    @Override
    public boolean delete(Long id) {
        return dao.delete(id);
    }
}
