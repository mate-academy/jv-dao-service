package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.setName("Vitaliy");
        driver.setLicenseNumber("vua413a13");
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        driver = driverService.create(driver);
        System.out.println(driverService.get(driver.getId()));
        System.out.println(driverService.getAll());
        driver.setName("Viktor");
        System.out.println(driverService.update(driver));
        System.out.println(driverService.delete(driver.getId()));
        System.out.println(driverService.getAll());
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Peugeot");
        manufacturer.setCountry("France");
        System.out.println(manufacturerService.create(manufacturer));
        System.out.println(manufacturerService.get(manufacturer.getId()));
        manufacturer.setName("Renault");
        System.out.println(manufacturerService.update(manufacturer));
        System.out.println(manufacturerService.delete(manufacturer.getId()));
        manufacturerService.getAll().forEach(System.out::println);
    }
}
