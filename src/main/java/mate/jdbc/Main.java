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
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        List<Driver> drivers = List.of(
                driverService.create(new Driver("Alim", "1234")),
                driverService.create(new Driver("Anna", "2345")),
                driverService.create(new Driver("Artem", "3456"))
        );
        List<Manufacturer> manufacturers = List.of(
                manufacturerService.create(new Manufacturer("Toyota", "Japan")),
                manufacturerService.create(new Manufacturer("Ford", "USA")),
                manufacturerService.create(new Manufacturer("BMW", "German"))
        );
        Manufacturer manufacturerNew =
                manufacturerService.create(new Manufacturer("Bogdan", "Ukraine"));
        manufacturerService.update(manufacturerNew);
        manufacturerService.delete(manufacturerNew.getId());
        Driver driverNew =
                driverService.create(new Driver("Artur", "8888"));
        driverService.update(driverNew);
        driverService.delete(driverNew.getId());
    }
}
