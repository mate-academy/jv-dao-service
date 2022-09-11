package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        System.out.println("# Test ManufacturerService #");
        System.out.println("Create new Manufacturer (Uber from USA)");
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Uber");
        manufacturer.setCountry("USA");
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        System.out.println(manufacturerService.create(manufacturer));
        System.out.println("-----------------------------");
        System.out.println("Create new Manufacturer (Uklon from Ukraine)");
        manufacturer = new Manufacturer();
        manufacturer.setName("Uklon");
        manufacturer.setCountry("Ukraine");
        System.out.println(manufacturerService.create(manufacturer));
        System.out.println("-----------------------------");
        System.out.println("Create new Manufacturer (Gett from United Kingdom)");
        manufacturer = new Manufacturer();
        manufacturer.setName("Gett");
        manufacturer.setCountry("United Kingdom");
        System.out.println(manufacturerService.create(manufacturer));
        System.out.println("-----------------------------");
        System.out.println("Get manufacturer by index = 2");
        System.out.println(manufacturerService.get(2L));
        System.out.println("-----------------------------");
        System.out.println("Get all manufacturers");
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println("-----------------------------");
        System.out.println("Delete manufacturer by index 2");
        System.out.println(manufacturerService.delete(2L));
        System.out.println("-----------------------------");
        System.out.println("Get all manufacturers");
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println("-----------------------------");
        System.out.println("Update manufacturer Gett from United Kingdom"
                + " SET country Poland");
        manufacturer.setCountry("Poland");
        System.out.println(manufacturerService.update(manufacturer));
        System.out.println("-----------------------------");
        System.out.println("Get all manufacturers");
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println("-----------------------------");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("-----------------------------");
        System.out.println("# Test DriverService #");
        System.out.println("Create new Driver (George with licenseNumber = 233445)");
        Driver driver = new Driver();
        driver.setName("George");
        driver.setLicenseNumber("233445");
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        System.out.println(driverService.create(driver));
        System.out.println("-----------------------------");
        System.out.println("Create new Driver (Alex with licenseNumber = 567644)");
        driver = new Driver();
        driver.setName("Alex");
        driver.setLicenseNumber("567644");
        System.out.println(driverService.create(driver));
        System.out.println("-----------------------------");
        System.out.println("Create new Driver (Michael with licenseNumber = 123341)");
        driver = new Driver();
        driver.setName("Michael");
        driver.setLicenseNumber("123341");
        System.out.println(driverService.create(driver));
        System.out.println("-----------------------------");
        System.out.println("Get Driver by index 1");
        System.out.println(driverService.get(1L));
        System.out.println("-----------------------------");
        System.out.println("Get all Drivers");
        driverService.getAll().forEach(System.out::println);
        System.out.println("-----------------------------");
        System.out.println("Delete Driver by index 2");
        System.out.println(driverService.delete(2L));
        System.out.println("-----------------------------");
        System.out.println("Get all Drivers");
        driverService.getAll().forEach(System.out::println);
        System.out.println("-----------------------------");
        System.out.println("Update driver (Michael with licenseNumber = 123341) "
                + " SET licenseNumber = 685743");
        driver.setLicenseNumber("685743");
        System.out.println(driverService.update(driver));
        System.out.println("-----------------------------");
        System.out.println("Get all Drivers");
        driverService.getAll().forEach(System.out::println);
        System.out.println("-----------------------------");
    }
}
