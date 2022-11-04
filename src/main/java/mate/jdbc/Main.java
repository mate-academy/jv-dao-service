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
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);

        testDriverService(driverService);

        testManufacturerService(manufacturerService);
    }

    private static void testManufacturerService(ManufacturerService manufacturerService) {
        manufacturerService.create(new Manufacturer("Tesla", "Germany"));
        manufacturerService.get(1L);
        manufacturerService.delete(5L);
        for (Manufacturer allManufacturers : manufacturerService.getAll()) {
            System.out.println(allManufacturers);
        }
        manufacturerService.update(new Manufacturer(1L, "Opel", "Germany"));
    }

    private static void testDriverService(DriverService driverService) {
        driverService.create(new Driver(11L, "Afanasij", "2150120"));
        driverService.get(3L);
        driverService.delete(5L);
        for (Driver allDrivers: driverService.getAll()) {
            System.out.println(allDrivers);
        }
        driverService.update(new Driver(1L, "Anton", "0235987"));
    }
}
