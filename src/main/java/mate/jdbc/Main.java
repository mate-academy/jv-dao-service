package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer(null, "Test name", "Test country");
        // initialize field values using setters or constructor
        manufacturerService.create(manufacturer);
        // test other methods from ManufacturerDao
        System.out.println("Created manufacturer: " + manufacturer);
        manufacturer.setName("New name");
        manufacturer.setCountry("New country");
        manufacturerService.update(manufacturer);
        System.out.println("Updated manufacturer: " + manufacturer);
        Manufacturer manufacturer1 = manufacturerService.get(manufacturer.getId());
        System.out.println("Manufacturer by id " + manufacturer.getId() + ": " + manufacturer1);
        manufacturerService.delete(manufacturer.getId());
        manufacturerService.getAll().forEach(System.out::println);
        Manufacturer manufacturer2 = manufacturerService.get(12345L);
        System.out.println("Manufacturer by id 12335: " + manufacturer2);

        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);
        Driver driver = new Driver(null, "Test name", "ААА123456");
        // initialize field values using setters or constructor
        driverService.create(driver);
        // test other methods from ManufacturerDao
        System.out.println("Created driver: " + driver);
        driver.setName("New name");
        driver.setLicenseNumber("BBB123456");
        driverService.update(driver);
        System.out.println("Updated driver: " + driver);
        Driver driver1 = driverService.get(driver.getId());
        System.out.println("Driver by id " + driver.getId() + ": " + driver1);
        driverService.delete(driver.getId());
        driverService.getAll().forEach(System.out::println);
        Driver driver2 = driverService.get(56789L);
        System.out.println("Driver by id 56789: " + driver2);
    }
}
