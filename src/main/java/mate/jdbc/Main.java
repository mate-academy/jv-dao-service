package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        Driver driver = new Driver();
        driver.setName("Driver One");
        driver.setLicenseNumber("#12345");
        driverService.create(driver);

        driver.setLicenseNumber("#56789");
        driverService.update(driver);

        driver.setName("Driver Second");
        driver.setLicenseNumber("#22222");
        driverService.create(driver);

        driver.setLicenseNumber("#56789");
        driverService.update(driver);

        driverService.delete(driver.getId());

        System.out.println(driverService.getAll());
    }
}
