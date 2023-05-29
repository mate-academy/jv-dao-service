package mate.jdbc.service.impl;

import java.sql.SQLException;
import java.util.List;
import mate.jdbc.dao.DriverDao;
import mate.jdbc.exception.DataProcessingException;
import mate.jdbc.lib.Inject;
import mate.jdbc.lib.Service;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

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
        return driverDao.get(id).orElseThrow(
                () -> new RuntimeException("Failed to retrieve Driver with id: "
                        + id + " from the database.)"));
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
