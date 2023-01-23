package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);
        Driver driver = new Driver();
        driver.setName("Bob");
        driver.setLicenseNumber("123");
        driverService.create(driver);
        Driver driver1 = new Driver();
        driver.setName("Bill");
        driver.setLicenseNumber("321");
        driverService.create(driver1);
        driver.setName("Bobby");
        driverService.update(driver);
        driverService.delete(driver1.getId());
        System.out.println(driverService.get(driver.getId()));
        driverService.getAll().forEach(System.out::println);
    }
}
