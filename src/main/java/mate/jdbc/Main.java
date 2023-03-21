package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        final ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        final DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);

        manufacturerService.create(new Manufacturer(null, "Hyundai", "Korea"));
        manufacturerService.get(11L);
        manufacturerService.update(new Manufacturer(11L, "Hyundai", "South Korea"));
        manufacturerService.delete(5L);
        List<Manufacturer> manufacturers = manufacturerService.getAll();
        manufacturers.forEach(System.out::println);

        driverService.create(new Driver(null, "Frodo", "9379992"));
        driverService.get(4L);
        driverService.update(new Driver(4L, "Frodo Beggins", "9379992"));
        driverService.delete(1L);
        List<Driver> drivers = driverService.getAll();
        drivers.forEach(System.out::println);
    }
}
