package mate.jdbc.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import mate.jdbc.dao.DriverDao;
import mate.jdbc.exception.DataProcessingException;
import mate.jdbc.lib.Inject;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

@Service
public class DriverServiceImpl implements DriverService {
    @Inject
    private DriverDao dao;

    @Override
    public Driver create(Driver driver) {
        return dao.create(driver);
    }

    @Override
    public Driver get(Long id) {
        try {
            return dao.get(id).orElseThrow();
        } catch (NoSuchElementException e) {
            throw new DataProcessingException("Couldn't get a driver with id: " + id, e);
        }
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
