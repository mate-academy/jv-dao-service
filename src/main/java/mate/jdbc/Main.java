package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver("Michael", "000111");
        driverService.create(driver);
        System.out.println("Driver created: " + driverService.get(driver.getId()));
        driver.setName("Marya");
        driver.setLicenseNumber("000777");
        driverService.update(driver);
        System.out.println("Driver updated: " + driverService.get(driver.getId()));
        driverService.delete(driver.getId());
        System.out.println("ALL drivers: " + driverService.getAll());

    }
}
