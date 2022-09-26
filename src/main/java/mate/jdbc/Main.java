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
        System.out.println(manufacturerService.create(new Manufacturer("Audi", "Germany")));
        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        System.out.println(driverService.create(new Driver("Bob", "GT45896")));
        System.out.println(driverService.create(new Driver("Alisa Yevtushenko", "GT89476")));
        System.out.println(driverService.create(new Driver("Valerii Rudenko", "GT32459")));
        System.out.println(driverService.update(new Driver(1L, "Bob Kobzar", "GT45896")));
        System.out.println(driverService.delete(4L));
        manufacturerService.getAll().forEach(System.out::println);
    }
}
