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
    private static final ManufacturerService manufacturerService =
            (ManufacturerService) injector.getInstance(ManufacturerService.class);
    private static final DriverService driverService =
            (DriverService) injector.getInstance(DriverService.class);
    private static List<Manufacturer> allManufacturers;
    private static List<Driver> allDrivers;

    public static void main(String[] args) {
        // Testing ManufacturerService

        Manufacturer kia = new Manufacturer("Kia", "South Korea");
        Manufacturer bmw = new Manufacturer("BMW", "Germany");
        Manufacturer reno = new Manufacturer("Reno", "France");
        Manufacturer audi = new Manufacturer("Audi", "Germany");
        // create Manufacturer in DB
        System.out.println("Create manufacturers in DataBase:");
        Manufacturer kiaManufacturer = manufacturerService.create(kia);
        Manufacturer bmwManufacturer = manufacturerService.create(bmw);
        Manufacturer renoManufacturer = manufacturerService.create(reno);
        Manufacturer audiManufacturer = manufacturerService.create(audi);
        // getAll
        System.out.println("Get all manufacturers from DataBase:");
        allManufacturers = manufacturerService.getAll();
        allManufacturers.forEach(System.out::println);
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
        boolean deletedManufacturer = manufacturerService.delete(INDEX);
        System.out.println(deletedManufacturer);
        //Testing DriverService
        Driver bob = new Driver("Bob", "0001");
        Driver alice = new Driver("Alice", "0002");
        Driver stepan = new Driver("Stepan", "0003");
        Driver petro = new Driver("Petro", "0004");
        //create Drivers in DB
        System.out.println("Create drivers in DataBase:");
        Driver bobDriver = driverService.create(bob);
        Driver aliceDriver = driverService.create(alice);
        Driver stepanDriver = driverService.create(stepan);
        Driver petroDriver = driverService.create(petro);
        //getAll
        System.out.println("Get all drivers from DataBase:");
        allDrivers = driverService.getAll();
        allDrivers.forEach(System.out::println);
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
        boolean deletedDriver = driverService.delete(INDEX);
        System.out.println(deletedDriver);
    }
}
