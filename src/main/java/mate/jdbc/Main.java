package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.services.DriverService;
import mate.jdbc.services.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        testManufacturers();
        System.out.println();
        testDrivers();
    }

    private static void testManufacturers() {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        System.out.println("All manufacturers:");
        List<Manufacturer> manufacturers = manufacturerService.getAll();
        manufacturers.stream()
                .map(Manufacturer::toString)
                .forEach(System.out::println);
        System.out.println(System.lineSeparator() + "Manufacturer with id 2:");
        Manufacturer manufacturer = manufacturerService.get(2L);
        System.out.println(manufacturer);
        System.out.println(System.lineSeparator() + "Add new manufacturer:");
        manufacturer = new Manufacturer("Peugeot", "France");
        System.out.println(manufacturerService.create(manufacturer));
        System.out.println(System.lineSeparator() + "Delete manufacturer with id 1:");
        System.out.println(manufacturerService.delete(1L));
        System.out.println(System.lineSeparator() + "Update manufacturer with id 4:");
        manufacturer = new Manufacturer("Honda", "Japan");
        manufacturer.setId(4L);
        System.out.println(manufacturerService.update(manufacturer));
        System.out.println(System.lineSeparator() + "All manufacturers:");
        manufacturers = manufacturerService.getAll();
        manufacturers.stream()
                .map(Manufacturer::toString)
                .forEach(System.out::println);
    }

    private static void testDrivers() {
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        System.out.println("All drivers:");
        List<Driver> drivers = driverService.getAll();
        drivers.stream()
                .map(Driver::toString)
                .forEach(System.out::println);
        System.out.println(System.lineSeparator() + "Driver with id 3:");
        Driver driver = driverService.get(3L);
        System.out.println(driver);
        System.out.println(System.lineSeparator() + "Add new driver:");
        driver = new Driver("Alex", "1927");
        System.out.println(driverService.create(driver));
        System.out.println(System.lineSeparator() + "Delete driver with id 2:");
        System.out.println(driverService.delete(2L));
        System.out.println(System.lineSeparator() + "Update driver with id 1:");
        driver = new Driver("Bob", "5336");
        driver.setId(1L);
        System.out.println(driverService.update(driver));
        System.out.println(System.lineSeparator() + "All drivers:");
        drivers = driverService.getAll();
        drivers.stream()
                .map(Driver::toString)
                .forEach(System.out::println);
    }
}
