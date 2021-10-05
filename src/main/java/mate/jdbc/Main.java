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
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver("Stas", "123456789");
        Manufacturer manufacturer = new Manufacturer("Ford", "USA");
        Manufacturer manufacturerCreate = manufacturerService.create(manufacturer);
        Driver driverCreate = driverService.create(driver);
        Manufacturer manufacturerFromId = manufacturerService.get(2L);
        Driver driverFromId = driverService.get(2L);
        Manufacturer manufacturerUpdate =
                manufacturerService.update(new Manufacturer(1L, "BMW", "Germany"));
        Driver driverUpdate =
                driverService.update(new Driver(1L, "Kolya", "987654321"));
        boolean driverDel = driverService.delete(1L);
        boolean manufacturerDel = manufacturerService.delete(1L);
        List<Manufacturer> manufacturers = manufacturerService.getAll();
        List<Driver> drivers = driverService.getAll();
        manufacturers.forEach(System.out::println);
        drivers.forEach(System.out::println);
    }
}
