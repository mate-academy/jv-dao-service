package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final ManufacturerService manufacturerService =
            (ManufacturerService) injector.getInstance(ManufacturerService.class);
    private static final DriverService driverService =
            (DriverService) injector.getInstance(DriverService.class);

    public static void main(String[] args) {
        Manufacturer testManufacturer = new Manufacturer(4L, "Bob", "Ukraine");
        System.out.println(manufacturerService.create(testManufacturer));
        System.out.println(manufacturerService.update(testManufacturer));
        System.out.println(manufacturerService.get(3L));
        System.out.println(manufacturerService.delete(9L));
        manufacturerService.getAll().forEach(System.out::println);

        Driver testDriver1 = new Driver(2L, "John", "NDFU957054SM9IJ");
        Driver testDriver2 = new Driver(1L, "Tommy", "GHFU859024SM8IJ");
        System.out.println(driverService.create(testDriver1));
        System.out.println(driverService.update(testDriver2));
        System.out.println(driverService.get(2L));
        System.out.println(driverService.delete(3L));
        driverService.getAll().forEach(System.out::println);
    }
}
