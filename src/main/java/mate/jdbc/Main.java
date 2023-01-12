package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector =
            Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        List<Driver> drivers = List.of(
                new Driver("Bob", "123"),
                new Driver("Alice", "456"),
                new Driver("Mike", "789")
        );
        drivers.forEach(driver -> {
            driver = driverService.create(driver);
            System.out.println(driver);
        });
        drivers = driverService.getAll();
        drivers.forEach(System.out::println);
        drivers.forEach(driver -> {
            driver.setName("new " + driver.getName());
            driverService.update(driver);
            System.out.println(driverService.get(driver.getId()));
        });
        drivers.forEach(driver ->
                System.out.println(driverService.delete(driver.getId())));

        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        List<Manufacturer> manufacturers = List.of(
                new Manufacturer("BMW", "Germany"),
                new Manufacturer("BMW", "Germany"),
                new Manufacturer("ZAZ", "Ukraine")
        );
        manufacturers.forEach(manufacturer -> {
            manufacturer = manufacturerService.create(manufacturer);
            System.out.println(manufacturer);
        });
        manufacturers = manufacturerService.getAll();
        manufacturers.forEach(System.out::println);
        manufacturers.forEach(manufacturer -> {
            manufacturer.setName("new " + manufacturer.getName());
            manufacturerService.update(manufacturer);
            System.out.println(manufacturerService.get(manufacturer.getId()));
        });
        manufacturers.forEach(manufacturer ->
                System.out.println(manufacturerService.delete(manufacturer.getId())));
    }
}
