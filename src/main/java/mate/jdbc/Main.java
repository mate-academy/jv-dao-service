package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Driver driver = new Driver();
    private static final Long INDEX_1 = 1L;
    private static final Long INDEX_2 = 2L;
    private static final String LICENCE_NUMBER = "21214";
    private static final String DRIVER_NAME = "Anatoliy";
    private static Injector injector =
            Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);
        deleteDriverById(INDEX_1, driverService);
        updateDriver(INDEX_1, LICENCE_NUMBER, DRIVER_NAME, driverService);
        getDriverById(INDEX_1, driverService);
        createDriver(INDEX_2, LICENCE_NUMBER, DRIVER_NAME, driverService);
    }

    private static void deleteDriverById(Long id,
                                         DriverService driverService) {
        driverService.delete(id);
    }

    private static Driver getDriverById(Long id,
                                                  DriverService driverService) {
        return driverService.get(id);
    }

    private static void updateDriver(Long id, String licenseNumber,
                                     String name,
                                     DriverService driverService) {
        driver.setId(id);
        driver.setName(name);
        driver.setLicenseNumber(licenseNumber);
        driverService.update(driver);
    }

    private static void createDriver(Long id, String name,
                                     String licenceNumber, DriverService driverService) {
        driver.setId(id);
        driver.setName(name);
        driver.setLicenseNumber(licenceNumber);
        driverService.create(driver);
    }
}
