package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    public static void main(String[] args) {
        Injector injector = Injector.getInstance("mate.jdbc");
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        List<Manufacturer> manufacturers = manufacturerService.getAll();
        List<Driver> drivers = driverService.getAll();
        System.out.println("Original data");
        printDataToConsole(manufacturers, drivers);
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Tesla");
        manufacturer.setCountry("USA");
        manufacturer = manufacturerService.create(manufacturer);
        System.out.println("Added: " + manufacturer);
        Driver driver = new Driver();
        driver.setName("Ivan");
        driver.setLicenseNumber("12345678");
        driver = driverService.create(driver);
        System.out.println("Added: " + driver);
        System.out.println("After adding");
        manufacturers = manufacturerService.getAll();
        drivers = driverService.getAll();
        printDataToConsole(manufacturers, drivers);
        Manufacturer newManufacturer = new Manufacturer();
        newManufacturer.setId(manufacturer.getId());
        newManufacturer.setCountry("Japan");
        newManufacturer.setName("Suzuki");
        showDifference(manufacturer, newManufacturer);
        manufacturerService.update(newManufacturer);
        Driver newDriver = new Driver();
        newDriver.setId(driver.getId());
        newDriver.setName("Leonid");
        newDriver.setLicenseNumber("87654321");
        showDifference(driver, newDriver);
        driverService.update(newDriver);
        System.out.println("After replacing");
        manufacturers = manufacturerService.getAll();
        drivers = driverService.getAll();
        printDataToConsole(manufacturers, drivers);
        System.out.println("Delete: " + newManufacturer);
        System.out.println("Delete: " + newDriver);
        manufacturerService.delete(newManufacturer.getId());
        driverService.delete(newDriver.getId());
        System.out.println("After deleting");
        manufacturers = manufacturerService.getAll();
        drivers = driverService.getAll();
        printDataToConsole(manufacturers, drivers);
    }

    private static void showDifference(Object oldObject, Object newObject) {
        System.out.println("Replaced "
                + oldObject + " by "
                + newObject);
    }

    private static void printDataToConsole(List<Manufacturer> manufacturers,
                                           List<Driver> drivers) {
        System.out.println("Manufacturers: " + manufacturers);
        System.out.println("Drivers: " + drivers);
    }
}
