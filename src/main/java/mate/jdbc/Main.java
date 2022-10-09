package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        System.out.println(manufacturerService.delete(1L));
        System.out.println(manufacturerService.create(new Manufacturer("Toyota", "Japan")));
        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        System.out.println(driverService.create(new Driver("Mike", "9712")));
        System.out.println(driverService.create(new Driver("John", "4524")));
        System.out.println(driverService.create(new Driver("Alice", "7356")));
        System.out.println(driverService.update(new Driver(1L, "Max", "1823")));
        System.out.println(driverService.delete(4L));
        manufacturerService.getAll().forEach(System.out::println);
    }
}
