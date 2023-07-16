package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        manufacturerService.create(new Manufacturer("BMW", "Germany"));
        manufacturerService.create(new Manufacturer("Audi", "Germany"));
        manufacturerService.create(new Manufacturer("Mercedes", "Germany"));

        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        driverService.create(new Driver("Nik", "AA0102ZZ"));
        driverService.create(new Driver("Alex", "AA0103ZZ"));
        driverService.create(new Driver("John", "AA0104ZZ"));

        System.out.println();
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println();
        driverService.getAll().forEach(System.out::println);

        System.out.println();
        System.out.println(manufacturerService.get(2L));
        System.out.println(driverService.get(2L));

        manufacturerService.update(new Manufacturer(2L, "updated BMW", "Germany"));
        driverService.update(new Driver(2L, "updated John", "AA0104ZZ"));

        System.out.println();
        System.out.println(manufacturerService.delete(1L));
        System.out.println(driverService.delete(3L));

        System.out.println();
        manufacturerService.getAll().forEach(System.out::println);
        driverService.getAll().forEach(System.out::println);

    }
}
