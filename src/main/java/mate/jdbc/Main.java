package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        System.out.println("* Testing ManufacturerService");
        ManufacturerService manufacturerService = (ManufacturerService) injector.getInstance(
                ManufacturerService.class);
        System.out.println("* Test getAll");
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println("* Test create");
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Ford");
        manufacturer.setCountry("USA");
        Manufacturer createdManufacturer = manufacturerService.create(manufacturer);
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println("* Test get");
        Long manufacturerId = createdManufacturer.getId();
        Manufacturer obtainedManufacturer = manufacturerService.get(manufacturerId);
        System.out.println(obtainedManufacturer);
        System.out.println("* Test update");
        Manufacturer manufacturerToUpdate = new Manufacturer(manufacturerId,
                "Toyota", "Japan");
        manufacturerService.update(manufacturerToUpdate);
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println("* Test delete");
        manufacturerService.delete(manufacturerId);
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println("* Testing DriverService");
        DriverService driverService = (DriverService) injector.getInstance(
                DriverService.class);
        System.out.println("* Test getAll");
        driverService.getAll().forEach(System.out::println);
        System.out.println("* Test create");
        Driver driver = new Driver();
        driver.setName("Bob");
        driver.setLicenseNumber("AAA 000001");
        Driver createdDriver = driverService.create(driver);
        driverService.getAll().forEach(System.out::println);
        System.out.println("* Test get");
        Long driverId = createdDriver.getId();
        Driver obtainedDriver = driverService.get(driverId);
        System.out.println(obtainedDriver);
        System.out.println("* Test update");
        Driver driverToUpdate = new Driver(driverId, "Alice", "BBB 000000");
        driverService.update(driverToUpdate);
        driverService.getAll().forEach(System.out::println);
        System.out.println("* Test delete");
        driverService.delete(driverId);
        driverService.getAll().forEach(System.out::println);
    }
}
