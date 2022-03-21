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
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Audi");
        manufacturer.setCountry("Germany");
        manufacturerService.create(manufacturer);
        manufacturer.setName("Peugeot");
        manufacturer.setCountry("France");
        manufacturer = manufacturerService.create(manufacturer);
        manufacturer.setName("Renault");
        manufacturerService.update(manufacturer);
        List<Manufacturer> allManufacturers = manufacturerService.getAll();
        allManufacturers.stream().forEach(System.out::println);
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        Driver driver = new Driver();
        driver.setName("SomeName");
        driver.setLicenseNumber("12345");
        driverService.create(driver);
        driver.setName("NameSome");
        driver.setLicenseNumber("67890");
        driver = driverService.create(driver);
        driver.setName("42");
        driverService.update(driver);
        List<Driver> allDrivers = driverService.getAll();
        allDrivers.stream().forEach(System.out::println);
    }
}
