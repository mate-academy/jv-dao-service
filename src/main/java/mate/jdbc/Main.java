package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        final DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        final ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);

        System.out.println("**************** TEST DRIVER SERVICE *******************");
        Driver driver = new Driver(0L, "driverServiceDriver", "007");
        System.out.println("**************** CREATE DRIVER *******************");
        driverService.create(driver);
        System.out.println("**************** GET ALL DRIVERS *******************");
        driverService.getAll().forEach(System.out::println);
        System.out.println("**************** GET ONE DRIVER *******************");
        System.out.println(driverService.get(20L));
        System.out.println("**************** UPDATE DRIVER *******************");
        driver = driverService.update(new Driver(7L, "Updated driver", "NEW LICENSE"));
        System.out.println(driver);
        System.out.println("**************** DELETE DRIVER *******************");
        System.out.println(driverService.delete(15L));
        System.out.println("**************** TEST MANUFACTURER SERVICE *******************");
        Manufacturer manufacturer = new Manufacturer(0L, "manufacturerServiceManufacturer", "007");
        System.out.println("**************** CREATE MANUFACTURER *******************");
        manufacturerService.create(manufacturer);
        System.out.println("**************** GET ALL MANUFACTURERS *******************");
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println("**************** GET ONE MANUFACTURER *******************");
        System.out.println(manufacturerService.get(20L));
        System.out.println("**************** UPDATE MANUFACTURER *******************");
        manufacturer = manufacturerService.update(
                new Manufacturer(7L, "Updated manufacturer", "NEW COUNTRY"));
        System.out.println(manufacturer);
        System.out.println("**************** DELETE MANUFACTURER *******************");
        System.out.println(manufacturerService.delete(15L));
    }
}
