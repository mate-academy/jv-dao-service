package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        //        CREATE
        Driver driver = new Driver();
        driver.setName("Taras");
        driver.setLicenseNumber("p130ras");
        System.out.println(driverService.create(driver));
        //        READ
        System.out.println(driverService.get(1L));
        System.out.println(driverService.getAll());
        //        UPDATE
        driver.setId(1L);
        driver.setName("iiiiiiiiii");
        driverService.update(driver);
        System.out.println(driverService.getAll());
        //        DELETE
        driverService.delete(1L);
        System.out.println(driverService.getAll());
    }
}
