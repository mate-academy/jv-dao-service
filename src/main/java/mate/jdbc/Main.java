package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        System.out.println("CREATION MANUFACTURERS:");
        Manufacturer manufacturer = new Manufacturer(
                null, "Ford Motor", "United States");
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer savedManufacturer = manufacturerService.create(manufacturer);
        System.out.println(savedManufacturer);
        manufacturer.setId(100L);
        manufacturer.setName("Toyota Motor");
        manufacturer.setCountry("Japan");
        System.out.println(manufacturerService.create(manufacturer));
        System.out.println("RETRIEVING ONE MANUFACTURER:");
        Manufacturer retrievedManufacturer = manufacturerService.get(2L);
        System.out.println(retrievedManufacturer);
        // The commented statement throw IllegalArgumentException
        // System.out.println(manufacturerService.get(1000L));
        System.out.println("RETRIEVING ALL MANUFACTURERS:");
        List<Manufacturer> retrievedAllManufacturers = manufacturerService.getAll();
        retrievedAllManufacturers.forEach(System.out::println);
        System.out.println("UPDATING MANUFACTURER:");
        manufacturer.setId(1L);
        manufacturer.setName("Hyundai Motor");
        manufacturer.setCountry("South Korea");
        Manufacturer updatedManufacturer = manufacturerService.update(manufacturer);
        System.out.println(updatedManufacturer);
        System.out.println("DELETING MANUFACTURER:");
        boolean deletedManufacturer = manufacturerService.delete(1L);
        System.out.println(deletedManufacturer);
        System.out.println("RETRIEVING MANUFACTURERS AFTER DELETING:");
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println(manufacturerService.get(1L));
        System.out.println("CREATION DRIVERS:");
        Driver driver = new Driver(
                null, "John", "AA-123");
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver savedDriver = driverService.create(driver);
        System.out.println(savedDriver);
        driver.setId(100L);
        driver.setName("Kate");
        driver.setLicenseNumber("BB-456");
        System.out.println(driverService.create(driver));
        System.out.println("RETRIEVING ONE DRIVER:");
        Driver retrievedDriver = driverService.get(2L);
        System.out.println(retrievedDriver);
        // The commented statement throw IllegalArgumentException
        // System.out.println(driverService.get(1000L));
        System.out.println("RETRIEVING ALL DRIVERS:");
        List<Driver> retrievedAllDrivers = driverService.getAll();
        retrievedAllDrivers.forEach(System.out::println);
        System.out.println("UPDATING DRIVER:");
        driver.setId(1L);
        driver.setName("Bob");
        driver.setLicenseNumber("CC-789");
        Driver updatedDriver = driverService.update(driver);
        System.out.println(updatedDriver);
        System.out.println("DELETING DRIVERS:");
        boolean deletedDriver = driverService.delete(1L);
        System.out.println(deletedDriver);
        System.out.println("RETRIEVING DRIVERS AFTER DELETING:");
        driverService.getAll().forEach(System.out::println);
        System.out.println(driverService.get(1L));
    }
}
