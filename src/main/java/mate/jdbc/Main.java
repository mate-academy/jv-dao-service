package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);

        Driver driver = new Driver();
        driver.setName("Schumacher");
        driver.setLicenseNumber("12345");
        driver = driverService.create(driver);
        System.out.println(driver);
        System.out.println(driverService.get(driver.getId()));
        driver.setName("Hakkinen");
        driver.setLicenseNumber("23456");
        System.out.println(driverService.update(driver));
        System.out.println(driverService.delete(driver.getId()));
        System.out.println(driverService.getAll());
    }
}
