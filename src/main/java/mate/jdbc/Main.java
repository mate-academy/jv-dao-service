package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        System.out.println("Create Manufacturer:");
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Bob");
        manufacturer.setCountry("Ukraine");
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer createdManufacturer = manufacturerService.create(manufacturer);
        System.out.println(createdManufacturer);
        System.out.println("Get Manufacturer:");
        System.out.println(manufacturerService.get(createdManufacturer.getId()));
        System.out.println("Get all Manufacturers:");
        manufacturerService.getAll().forEach(System.out::println);
        createdManufacturer.setName("Jack");
        System.out.println("Update Manufacturer:");
        System.out.println(manufacturerService.update(createdManufacturer));
        System.out.println("Delete Manufacturer:");
        System.out.println(manufacturerService.delete(createdManufacturer.getId()));

        System.out.println();

        System.out.println("Create Driver:");
        Driver driver = new Driver();
        driver.setName("Bob");
        driver.setLicenseNumber("123");
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver createdDriver = driverService.create(driver);
        System.out.println(createdDriver);
        System.out.println("Get Driver:");
        System.out.println(driverService.get(createdDriver.getId()));
        System.out.println("Get all Drivers:");
        driverService.getAll().forEach(System.out::println);
        createdDriver.setName("Jack");
        System.out.println("Update Driver:");
        System.out.println(driverService.update(createdDriver));
        System.out.println("Delete Driver:");
        System.out.println(driverService.delete(createdDriver.getId()));
    }
}
