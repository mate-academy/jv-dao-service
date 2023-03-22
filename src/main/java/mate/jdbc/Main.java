package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Long INDEX = 3L;
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        // Testing ManufacturerService
        // create Manufacturer in DB
        System.out.println("Create manufacturers in DataBase:");
        List<Manufacturer> manufacturerList =
                List.of(new Manufacturer("Kia", "SouthKorea"),
                new Manufacturer("BMW", "Germany"),
                new Manufacturer("Zaporozhets", "Ukraine"),
                new Manufacturer("Audi", "Germany"));
        for (Manufacturer manufacturer : manufacturerList) {
            System.out.println(manufacturerService.create(manufacturer));
        }
        // getAll
        System.out.println("Get all manufacturers from DataBase:");
        manufacturerService.getAll().forEach(System.out::println);
        // get
        System.out.println("Get manufacturer by id:");
        Manufacturer manufacturer = manufacturerService.get(INDEX);
        System.out.println(manufacturer);
        // update
        System.out.println("Update manufacturer in DataBase:");
        manufacturer.setName("Bentley");
        manufacturer.setCountry("Great Britain");
        Manufacturer updateManufacturer = manufacturerService.update(manufacturer);
        System.out.println(updateManufacturer);
        //delete
        System.out.println("Delete manufacturer in DataBase:");
        System.out.println(manufacturerService.delete(INDEX));
        //Testing DriverService
        //create
        System.out.println("Create drivers in DataBase:");
        List<Driver> driversList =
                List.of(new Driver("Bob", "0001"),
                new Driver("Alice", "0002"),
                new Driver("Stepan", "0003"),
                new Driver("Petro", "0004"));
        for (Driver driver : driversList) {
            System.out.println(driverService.create(driver));
        }
        //getAll
        System.out.println("Get all drivers from DataBase:");
        driverService.getAll().forEach(System.out::println);
        //get
        System.out.println("Get driver by id");
        Driver driver = driverService.get(INDEX);
        System.out.println(driver);
        //update
        System.out.println("Update driver in DataBase:");
        driver.setName("Stephania");
        driver.setLicenseNumber("0005");
        Driver updateDriver = driverService.update(driver);
        System.out.println(updateDriver);
        //delete
        System.out.println("Delete driver from DataBase:");
        System.out.println(driverService.delete(INDEX));
    }
}
