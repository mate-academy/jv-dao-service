package mate.jdbc.service.impl;

import java.util.List;
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
    public Driver create(Driver driver) {
        checkDriver(driver, "CREATE", false);
        return driverDao.create(driver);
    }

    @Override
    public Driver get(Long id) {
        return driverDao.get(id).orElseThrow(() ->
                new RuntimeException("Can't find in DB driver with ID: " + id));
    }

    @Override
    public List<Driver> getAll() {
        return driverDao.getAll();
    }

    @Override
    public Driver update(Driver driver) {
        checkDriver(driver, "UPDATE", true);
        return driverDao.update(driver);
    }

    @Override
    public boolean delete(Long id) {
        return driverDao.delete(id);
    }

    private void checkDriver(Driver driver, String operation, boolean isId) {
        if (driver == null) {
            throw new RuntimeException("Operation " + operation + " failed! "
                    + "Driver can't be NULL");
        }
        if (driver.getId() == null && isId) {
            throw new RuntimeException("Operation " + operation + " failed! "
                    + "It requires driver's ID but actual is NULL: " + driver);
        }
        if (driver.getName() == null || driver.getLicenseNumber() == null
                || driver.getName().isBlank() || driver.getLicenseNumber().isBlank()) {
            throw new RuntimeException("Operation " + operation + " failed!"
                    + " The fields: 'name' and 'licenseNumber' can't be empty or NULL"
                    + System.lineSeparator() + "Accepted Driver is: " + driver);
        }
    }
}
