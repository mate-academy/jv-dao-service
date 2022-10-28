package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        System.out.println(manufacturerService.getAll());
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driver1 = new Driver("Vasya", "ua12345");
        Driver driver2 = new Driver("Petya", "ua6789");
        driverService.create(driver1);
        driverService.create(driver2);
        System.out.println(driverService.get(1L));
        System.out.println(driverService.getAll());
        Driver driver3 = new Driver(2L, "Zenya", "ua666");
        System.out.println(driverService.update(driver3));
        driverService.delete(2L);
        System.out.println(driverService.getAll());
    }
}
