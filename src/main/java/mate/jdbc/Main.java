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

        // test for Manufacturer
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        List<Manufacturer> manufacturers;

        // Delete record from manufacturer table
        System.out.println(manufacturerService.delete(6L) ? "Record deleted" : "Record not found");
        manufacturers = manufacturerService.getAll();
        manufacturers.forEach(System.out::println);

        // Get record from manufacturer table
        System.out.println("Got manufacturer by id:" + manufacturerService.get(7L));

        //Update record in manufacturer table
        Manufacturer toUpdateManufacturer = new Manufacturer(11L,"Lada", "USSR");
        Manufacturer updatedManufacturer = manufacturerService.update(toUpdateManufacturer);
        System.out.println("Updated manufacturer: " + updatedManufacturer);

        //Add new record to manufacturer table
        Manufacturer newManufacturer = new Manufacturer("Cherry9", "China");
        Manufacturer addedManufacturer = manufacturerService.create(newManufacturer);
        System.out.println("Added manufacturer: " + addedManufacturer);

        //Get All records of Manufacturer
        manufacturers = manufacturerService.getAll();
        manufacturers.forEach(System.out::println);

        // test for Driver
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        List<Driver> drivers;

        // Delete record from driver table
        System.out.println(driverService.delete(6L) ? "Record deleted" : "Record not found");
        drivers = driverService.getAll();
        drivers.forEach(System.out::println);

        // Get record from driver table
        System.out.println("Got driver by id:" + driverService.get(2L));

        //Update record in driver table
        Driver toUpdateDriver = new Driver(2L,"Max", "876786ty657");
        Driver updatedDriver = driverService.update(toUpdateDriver);
        System.out.println("Updated driver: " + updatedDriver);

        //Add new record to driver table
        Driver newDriver = new Driver("Albert", "546854jk65466");
        Driver addedDriver = driverService.create(newDriver);
        System.out.println("Added driver: " + addedDriver);

        //Get All records of Drivers
        drivers = driverService.getAll();
        drivers.forEach(System.out::println);
    }
}
