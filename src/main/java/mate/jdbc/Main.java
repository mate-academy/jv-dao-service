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
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer("BMV", "Germany");
        Manufacturer insertedManufacturer = manufacturerService.create(manufacturer);
        Manufacturer manufacturerFromDB = manufacturerService.get(2L);
        List<Manufacturer> allManufacturersFromDB = manufacturerService.getAll();
        Manufacturer updateManufacturer = new Manufacturer(7L, "Volkswagen", "Germany");
        Manufacturer updatedManufacturer = manufacturerService.update(updateManufacturer);
        boolean deletedManufacturer = manufacturerService.delete(6L);
        printAllManufacturerActions(insertedManufacturer, manufacturerFromDB,
                allManufacturersFromDB, updatedManufacturer, deletedManufacturer);
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver("Mary Burns", "T37954403");
        Driver insertedDriver = driverService.create(driver);
        Driver driverFromDB = driverService.get(3L);
        List<Driver> allDriversFromDB = driverService.getAll();
        Driver updateDriver = new Driver(3L, "Lily Black", "S21850043");
        Driver updatedDriver = driverService.update(updateDriver);
        boolean deletedDriver = driverService.delete(1L);
        printAllDriverActions(insertedDriver, driverFromDB,
                allDriversFromDB, updatedDriver, deletedDriver);
    }

    private static void printAllManufacturerActions(Manufacturer insertedManufacturer,
                                                    Manufacturer manufacturerFromDB,
                                                    List<Manufacturer> allFromDB,
                                                    Manufacturer updatedManufacturer,
                                                    boolean deleted) {
        System.out.println("insertedManufacturer = " + insertedManufacturer.toString());
        System.out.println("manufacturerFromDB = " + manufacturerFromDB.toString());
        System.out.println("All from DB:");
        for (Manufacturer manufacturer : allFromDB) {
            System.out.println("manufacturer = " + manufacturer.toString());
        }
        System.out.println("updatedManufacturer = " + updatedManufacturer.toString());
        System.out.println("deleted = " + deleted);
    }

    private static void printAllDriverActions(Driver insertedDriver, Driver driverFromDB,
                                              List<Driver> allFromDB, Driver updatedDriver,
                                              boolean deleted) {
        System.out.println("insertedDriver = " + insertedDriver.toString());
        System.out.println("driverFromDB = " + driverFromDB.toString());
        System.out.println("All from DB:");
        for (Driver driver : allFromDB) {
            System.out.println("driver = " + driver.toString());
        }
        System.out.println("updatedDriver = " + updatedDriver.toString());
        System.out.println("deleted = " + deleted);
    }
}
