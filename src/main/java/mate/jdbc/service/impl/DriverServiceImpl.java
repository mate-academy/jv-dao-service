package mate.jdbc.service.impl;

import mate.jdbc.dao.ManufacturerDao;
import mate.jdbc.lib.Inject;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;
import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {
    @Inject
    private ManufacturerDao dao;

    @Override
    public Driver create(Driver driver) {
        return null;
    }

    @Override
    public Driver get(Long id) {
        return null;
    }

    @Override
    public List<Driver> getAll() {
        return null;
    }

    @Override
    public Driver update(Driver driver) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
