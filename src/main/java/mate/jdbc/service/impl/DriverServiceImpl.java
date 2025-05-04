package mate.jdbc.service.impl;

import java.util.List;
import mate.jdbc.dao.DriverDao;
import mate.jdbc.exception.EntityNotFoundException;
import mate.jdbc.lib.Dao;
import mate.jdbc.lib.Inject;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.DriverValidationService;

@Dao
@Inject
public class DriverServiceImpl implements DriverService {
    private DriverDao driverDao;
    private DriverValidationService validationService;

    public DriverServiceImpl(DriverDao driverDao, DriverValidationService validationService) {
        this.driverDao = driverDao;
        this.validationService = validationService;
    }

    @Override
    public Driver createDriver(Driver driver) {
        validationService.validateBeforeCreate(driver);
        return driverDao.create(driver);
    }

    @Override
    public Driver getDriverById(Long id) {
        return driverDao.get(id).orElseThrow(() -> new EntityNotFoundException("Couldn't"
                + "find a driver with id: " + id));
    }

    @Override
    public List<Driver> getAllDrivers() {
        return driverDao.getAll();
    }

    @Override
    public Driver updateDriver(Driver driver) {
        validationService.validateBeforeUpdate(driver);
        return driverDao.update(driver);
    }

    @Override
    public boolean deleteDriver(Long id) {
        return driverDao.delete(id);
    }
}
