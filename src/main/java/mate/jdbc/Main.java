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
        List<Manufacturer> allManufacturers = manufacturerService.getAll();
        allManufacturers.stream().forEach(System.out::println);
        System.out.println(manufacturerService.get(2L));
        Manufacturer testManufacturer =
                manufacturerService.create(new Manufacturer("Kia", "South Korea"));
        System.out.println(testManufacturer);
        manufacturerService.delete(3L);
        manufacturerService.update(new Manufacturer(2L,"Tesla", "USA"));
        //test DriverService
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        List<Driver> allDrivers = driverService.getAll();
        allDrivers.forEach(System.out::println);
        System.out.println(driverService.get(2L));
        Driver testDriver = driverService.create(new Driver("Bob", "MG8593845"));
        System.out.println(testDriver);
        driverService.delete(3L);
        driverService.update(new Driver(2L,"Mycola", "ND897986087"));
    }
}
