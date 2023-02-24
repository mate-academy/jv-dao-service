package mate.jdbc;

import mate.jdbc.dao.DriverDaoImpl;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.impl.DriverServiceImpl;

public class Main {
    private static final Injector injector = Injector.getInstance("mate");

    public static void main(String[] args) {

        final Driver driver = new Driver();
        driver.setName("Roman");
        driver.setLicenseNumber("22");

        DriverService driverService = new DriverServiceImpl(new DriverDaoImpl());

        driverService.createDriver(driver);
        driverService.getDriver(2L);
        driverService.getAllDriver();
        driverService.updateDriver(driver);
        driverService.deleteDriver(2L);

    }
}
