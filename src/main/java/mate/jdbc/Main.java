package mate.jdbc;

import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;
import mate.jdbc.util.Injector;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver();
        driver.setName("Bob");
        driver.setLicenseNumber("11111");
        System.out.println(driverService.create(driver));
        System.out.println(driverService.get(2L));
        System.out.println(driverService.getAll());
        System.out.println(driverService.update(driver));
        System.out.println(driverService.delete(1L));
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Jeep");
        manufacturer.setCountry("German");
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        System.out.println(manufacturerService.create(manufacturer));
        System.out.println(manufacturerService.get(1L));
        System.out.println(manufacturerService.getAll());
        System.out.println(manufacturerService.update(manufacturer));
        System.out.println(manufacturerService.delete(30L));
    }
}
