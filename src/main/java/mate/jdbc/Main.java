package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final ManufacturerService manufacturerService
            = (ManufacturerService) injector.getInstance(ManufacturerService.class);
    private static final DriverService driverService
            = (DriverService) injector.getInstance(DriverService.class);

    public static void main(String[] args) {
        Manufacturer manufacturer =
                manufacturerService.create(new Manufacturer("Tesla", "USA"));
        System.out.println(manufacturer);
        System.out.println(manufacturerService.get(2L));
        manufacturerService.delete(1L);
        manufacturerService.update(new Manufacturer(2L,"WF", "Germany"));
        List<Manufacturer> allManufacturers = manufacturerService.getAll();
        allManufacturers.forEach(System.out::println);
        Driver driver = driverService.create(new Driver("Alice", "KB123456"));
        System.out.println(driver);
        System.out.println(driverService.get(1L));
        List<Driver> allDrivers = driverService.getAll();
        allDrivers.forEach(System.out::println);
        driverService.update(new Driver(1L,"Ivan", "KB654321"));
        driverService.delete(1L);
    }
}
