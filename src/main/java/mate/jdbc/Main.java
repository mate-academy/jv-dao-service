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
        driverService.create(new Driver("Bob", "1234"));
        driverService.create(new Driver("Alice", "5678"));
        driverService.create(new Driver("John", "3456"));
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        manufacturerService.create(new Manufacturer("BMW", "Germany"));
        manufacturerService.create(new Manufacturer("Volvo", "Sweden"));
        manufacturerService.create(new Manufacturer("Mazda", "Japan"));

        driverService.delete(1L);
        manufacturerService.delete(2L);

        driverService.getAll().forEach(System.out::println);
        manufacturerService.getAll().forEach(System.out::println);
    }
}
