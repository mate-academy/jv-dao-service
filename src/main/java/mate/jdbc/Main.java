package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        List<Driver> allDrivers = driverService.getAll();
        driverService.update(new Driver(allDrivers.get(0).getId(), "Maria", "777-777"));
        driverService.delete(1L);
        driverService.getAll().stream().forEach(System.out::println);

        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        List<Manufacturer> allManufacturers = manufacturerService.getAll();
        manufacturerService.delete(1L);
        manufacturerService.update(new Manufacturer(allManufacturers.get(0).getId(),
                "Infiniti", "Japan"));
        manufacturerService.getAll().forEach(System.out::println);
    }
}

