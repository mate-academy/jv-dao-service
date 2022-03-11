package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    public static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("bmw");
        manufacturer.setCountry("germany");
        System.out.println("manufacturer create " + manufacturerService.create(manufacturer));
        List<Manufacturer> getAllManufacturers = manufacturerService.getAll();
        System.out.println("manufacturer getAll:");
        getAllManufacturers.forEach(System.out::println);
        System.out.println("manufacturer get " + manufacturerService.get(manufacturer.getId()));
        manufacturer.setName("audi");
        System.out.println("manufacturer update " + manufacturerService.update(manufacturer));
        System.out.println("manufacturer delete "
                + manufacturerService.delete(manufacturer.getId()));
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver();
        driver.setName("Shevchenko Taras");
        driver.setLicenseNumber("12345");
        System.out.println("Driver create: " + driverService.create(driver));
        List<Driver> getAllDrivers = driverService.getAll();
        System.out.println("Driver getAll:");
        getAllDrivers.forEach(System.out::println);
        System.out.println("Driver get: " + driverService.get(driver.getId()));
        driver.setLicenseNumber("54321");
        System.out.println("Driver update: " + driverService.update(driver));
        System.out.println("Driver delete: " + driverService.delete(driver.getId()));
    }
}
