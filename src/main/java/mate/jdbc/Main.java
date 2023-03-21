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
        //test ManufacturerService
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        // Manufacturer create test
        Manufacturer testManufacturer =
                manufacturerService.create(new Manufacturer("Kia", "South Korea"));
        System.out.println(testManufacturer);
        // Manufacturer get test
        System.out.println(manufacturerService.get(2L));
        // Manufacturer delete test
        manufacturerService.delete(3L);
        // Manufacturer update test
        manufacturerService.update(new Manufacturer(2L,"Tesla", "USA"));
        // Manufacturer getAll test
        List<Manufacturer> allManufacturers = manufacturerService.getAll();
        allManufacturers.forEach(System.out::println);

        //test DriverService
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        // Driver create test
        Driver testDriver = driverService.create(new Driver("Bob", "MG8593845"));
        System.out.println(testDriver);
        // Driver get test
        System.out.println(driverService.get(2L));
        // Driver update test
        driverService.update(new Driver(2L,"Mycola", "ND897986087"));
        // Driver delete test
        driverService.delete(3L);
        // Driver getAll test
        List<Driver> allDrivers = driverService.getAll();
        allDrivers.forEach(System.out::println);
    }
}
