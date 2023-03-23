package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final ManufacturerService manufacturerService =
            (ManufacturerService) injector.getInstance(ManufacturerService.class);
    private static final DriverService driverService =
            (DriverService) injector.getInstance(DriverService.class);

    public static void main(String[] args) {
        driverService.create(new Driver("Bob","19283735"));
        driverService.create(new Driver("John", "17342964"));
        driverService.create(new Driver("Alice", "18452074"));
        List<Driver> allDrivers = driverService.getAll();
        allDrivers.forEach(System.out::println);
        System.out.println(driverService.get(3L));
        driverService.update(new Driver(2L, "Bill", "18345285"));
        driverService.delete(1L);

        manufacturerService.create(new Manufacturer("Reno","France"));
        manufacturerService.create(new Manufacturer("Toyota","Japan"));
        List<Manufacturer> allManufacturers = manufacturerService.getAll();
        allManufacturers.forEach(System.out::println);
        System.out.println(manufacturerService.get(3L));
        manufacturerService.update(new Manufacturer(2L, "Mazda", "China"));
        manufacturerService.delete(1L);
    }
}
