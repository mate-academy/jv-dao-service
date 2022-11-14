package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");
    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturerFrance = new Manufacturer(null,"Renault", "France");
        manufacturerService.create(manufacturerFrance);
        System.out.println("Manufacturer created example: ");
        System.out.println(manufacturerService.getAll());
        manufacturerFrance.setName("Bugatti");
        manufacturerFrance.setCountry("France");
        manufacturerService.update(manufacturerFrance);
        System.out.println("Manufacturer updated example: ");
        System.out.println(manufacturerService.getAll());
        manufacturerService.delete(manufacturerFrance.getId());
        System.out.println("Manufacturer deleted example: ");
        System.out.println(manufacturerService.getAll());
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver(null,"Slavik","1715");
        driverService.create(driver);
        System.out.println("Driver created example: ");
        System.out.println(driverService.getAll());
        driver.setName("John");
        driver.setLicenseNumber("1517");
        driverService.update(driver);
        System.out.println("Driver updated example: ");
        System.out.println(driverService.getAll());
        driverService.delete(driver.getId());
        System.out.println("Driver deleted example: ");
        System.out.println(driverService.getAll());
    }
}
