package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.services.DriverService;
import mate.jdbc.services.ManufacturerService;

public class Main {
    public static void main(String[] args) {
        Injector injector = Injector.getInstance("mate.jdbc");
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Acura");
        manufacturer.setCountry("Japan");
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer addedFirstManufacturer = manufacturerService.create(manufacturer);
        System.out.println(addedFirstManufacturer);
        Driver driver = new Driver();
        driver.setName("Katy");
        driver.setLicenseNumber("12345");
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver addedFirstDriver = driverService.create(driver);
        System.out.println(addedFirstDriver);
        System.out.println("--------------------");

        System.out.println("Test getting by id:");

        Driver newDriver = new Driver();
        newDriver.setName("Nik");
        newDriver.setLicenseNumber("165463");
        Driver addedDriver = driverService.create(newDriver);
        System.out.println(driverService.get(addedDriver.getId()));

        Manufacturer newManufacturer = new Manufacturer();
        newManufacturer.setName("Audi");
        newManufacturer.setCountry("Germany");
        Manufacturer addedManufacturer = manufacturerService.create(newManufacturer);
        System.out.println(manufacturerService.get(addedManufacturer.getId()));
        System.out.println("-----------------------");

        System.out.println("Test update:");

        Driver forUpdate = new Driver();
        forUpdate.setName("Vany");
        forUpdate.setLicenseNumber("5252");
        forUpdate.setId(newDriver.getId());
        System.out.println(driverService.update(forUpdate));

        Manufacturer forUpdateManufacturer = new Manufacturer();
        forUpdateManufacturer.setName("Porsche");
        forUpdateManufacturer.setCountry("Germany");
        forUpdateManufacturer.setId(newManufacturer.getId());
        System.out.println(manufacturerService.update(forUpdateManufacturer));
        System.out.println("-----------------------");

        System.out.println("Test delete:");
        System.out.println(driverService.delete(addedDriver.getId()));
        System.out.println(manufacturerService.delete(addedFirstManufacturer.getId()));
        System.out.println("-----------------------");

        System.out.println("Get all:");
        System.out.println("Drivers: ");
        driverService.getAll().stream().forEach(System.out::println);
        System.out.println("Manufacturers: ");
        manufacturerService.getAll().stream().forEach(System.out::println);

    }
}
