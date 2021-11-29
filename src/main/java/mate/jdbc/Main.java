package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        System.out.println("Test ManufacturerService:");
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer("Wolkswagen", "France");
        System.out.println(manufacturerService.create(manufacturer));
        System.out.println("--------------------------------------------");
        System.out.println(manufacturerService.getAll());
        System.out.println("--------------------------------------------");
        System.out.println(manufacturerService.get(manufacturer.getId()));
        System.out.println("--------------------------------------------");
        manufacturerService.create(manufacturer);
        manufacturer.setName("Mitsubisi");
        manufacturer.setCountry("Japan");
        System.out.println(manufacturerService.update(manufacturer));
        System.out.println("--------------------------------------------");
        manufacturerService.create(manufacturer);
        System.out.println(manufacturerService.getAll());
        manufacturerService.delete(manufacturer.getId());
        System.out.println(manufacturerService.getAll());
        System.out.println("Test DriverService:");
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver("Bob", "AA-4513");
        System.out.println(driverService.create(driver));
        System.out.println("--------------------------------------------");
        System.out.println(driverService.getAll());
        System.out.println("--------------------------------------------");
        System.out.println(driverService.get(driver.getId()));
        System.out.println("--------------------------------------------");
        driverService.create(driver);
        driver.setName("Alice");
        driver.setLicenseNumber("AB-1613");
        System.out.println(driverService.update(driver));
        System.out.println("--------------------------------------------");
        driverService.create(driver);
        System.out.println(driverService.getAll());
        driverService.delete(driver.getId());
        System.out.println(driverService.getAll());
    }
}
