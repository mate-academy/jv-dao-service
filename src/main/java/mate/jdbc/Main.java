package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        driverService.create(new Driver(null, "Oleg Vovk", "124568692"));
        driverService.create(new Driver(null, "Vikor Duda", "124871481"));
        driverService.getAll().forEach(System.out::println);
        driverService.update(new Driver(3L, "Ostap Klen", "124859321"));
        System.out.println(driverService.get(3L));
        driverService.delete(4L);
        driverService.getAll().forEach(System.out::println);

        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        manufacturerService.create(
                new Manufacturer(null, "Mitsubishi Motors Corporation", "Japan"));
        manufacturerService.getAll().forEach(System.out::println);
        manufacturerService.update(new Manufacturer(9L, "Ford", "U.S.A."));
        System.out.println(manufacturerService.get(9L));
        manufacturerService.delete(8L);
        manufacturerService.getAll().forEach(System.out::println);
    }
}
