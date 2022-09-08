package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("ZAZ");
        manufacturer.setCountry("Ukraine");
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);

        System.out.println("Test of creating manufacturer:");
        System.out.println(manufacturerService.create(manufacturer));

        System.out.println("Test of getting manufacturer by id:");
        Manufacturer gottenManufacturer = manufacturerService.get(manufacturer.getId());
        System.out.println(gottenManufacturer);

        System.out.println("Test of updating manufacturer:");
        manufacturer.setName("LuAZ");
        System.out.println(manufacturerService.update(manufacturer));

        System.out.println("Test of deleting manufacturer:");
        boolean deletedManufacturer = manufacturerService.delete(manufacturer.getId());
        System.out.println(deletedManufacturer);

        System.out.println("Test of getting all manufacturers:");
        System.out.println(manufacturerService.getAll());
        System.out.println();

        Driver driver = new Driver();
        driver.setName("Valentyn");
        driver.setLicenseNumber("11111111");
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);

        System.out.println("Test of creating driver:");
        System.out.println(driverService.create(driver));

        System.out.println("Test of getting driver by id:");
        Driver gottenDriver = driverService.get(driver.getId());
        System.out.println(gottenDriver);

        System.out.println("Test of updating driver:");
        driver.setLicenseNumber("88888888");
        System.out.println(driverService.update(driver));

        System.out.println("Test of deleting driver:");
        boolean deletedDriver = driverService.delete(driver.getId());
        System.out.println(deletedDriver);

        System.out.println("Test of getting all drivers:");
        System.out.println(driverService.getAll());
    }
}
