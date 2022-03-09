package mate.jdbc;

import java.util.Optional;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final ManufacturerService manufacturerService =
            (ManufacturerService) injector.getInstance(ManufacturerService.class);
    private static final DriverService driverService =
            (DriverService) injector.getInstance(DriverService.class);

    public static void main(String[] args) {
        //
        //Testing ManufacturerService
        //
        System.out.println("Testing ManufacturerService:");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        Manufacturer manufacturer1 = manufacturerService.create(
                new Manufacturer("name1", "country1"));
        System.out.println("Add to db new manufacturer:" + manufacturer1);
        Manufacturer manufacturer2 = manufacturerService.create(
                new Manufacturer("name2", "country2"));
        System.out.println("Add to db new manufacturer:" + manufacturer2);
        Manufacturer manufacturer3 = manufacturerService.create(
                new Manufacturer("name3", "country3"));
        System.out.println("Add to db new manufacturer:" + manufacturer3);
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        Optional<Manufacturer> getFromDbManufacturer = manufacturerService.get(1L);
        System.out.println("Result of get(id = 1): " + getFromDbManufacturer.get());
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        Manufacturer updatedManufacturer2 = new Manufacturer(2L, "name", "country");
        manufacturerService.update(updatedManufacturer2);
        System.out.println("getAll() result after update manufacturer with id = 2:");
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        boolean isDeletedManufacturer = manufacturerService.delete(2L);
        System.out.println("Manufacturer with id = " + 2L
                + " is deleted: " + isDeletedManufacturer);
        System.out.println("getAll() result after delete manufacturer with id = 2:");
        manufacturerService.getAll().forEach(System.out::println);
        //
        //Testing DriverService
        //
        System.out.println("Testing DriverService:");
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        Driver driver1 = driverService.create(new Driver("name1", "license1"));
        System.out.println("Add to db new driver:" + driver1);
        Driver driver2 = driverService.create(new Driver("name2", "license2"));
        System.out.println("Add to db new driver:" + driver2);
        Driver driver3 = driverService.create(new Driver("name3", "license3"));
        System.out.println("Add to db new driver:" + driver3);
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        Optional<Driver> getFromDbDriver = driverService.get(1L);
        System.out.println("Result of get(id = 1): " + getFromDbDriver.get());
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        Driver updatedDriver2 = new Driver(2L, "name", "license");
        driverService.update(updatedDriver2);
        System.out.println("getAll() result after update driver with id = 2:");
        driverService.getAll().forEach(System.out::println);
        System.out.println(".");
        System.out.println(".");
        System.out.println(".");
        boolean isDeletedDriver = driverService.delete(2L);
        System.out.println("Driver with id = " + 2L
                + " is deleted: " + isDeletedDriver);
        System.out.println("getAll() result after delete driver with id = 2:");
        driverService.getAll().forEach(System.out::println);
    }
}
