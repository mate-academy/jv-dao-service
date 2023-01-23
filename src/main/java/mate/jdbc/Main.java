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
        List<Manufacturer> manufacturers = List.of(
                new Manufacturer("Dodge", "USA"),
                new Manufacturer("Renault", "France"),
                new Manufacturer("Peugeot", "France"),
                new Manufacturer("BMW", "Germany"),
                new Manufacturer("Mercedes", "Germany"),
                new Manufacturer("Hyundai", "Korea"),
                new Manufacturer("Subaru", "Japan")
        );
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);

        System.out.println("Manufacturers data will be displayed");
        
        manufacturers.forEach(manufacturerService::create);
        System.out.println(manufacturerService.get(4L));
        System.out.println(manufacturerService.update(
                new Manufacturer(4L, "Volvo", "Sweden")));
        manufacturerService.delete(5L);
        manufacturerService.getAll().forEach(System.out::println);

        List<Driver> drivers = List.of(
                new Driver("Alex", "Ukraine"),
                new Driver("Scott", "Poland"),
                new Driver("Shamil", "Iraq"),
                new Driver("Jezz", "England"),
                new Driver("Anna", "Korea"),
                new Driver("Mary", "Germany"),
                new Driver("Dori", "Spain")
        );
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);

        System.out.println("Drivers data will be displayed");

        drivers.forEach(driverService::create);
        System.out.println(driverService.get(3L));
        System.out.println(driverService.update(
                new Driver(3L, "Boris", "Slovakia")));
        driverService.delete(6L);
        driverService.getAll().forEach(System.out::println);
    }
}
