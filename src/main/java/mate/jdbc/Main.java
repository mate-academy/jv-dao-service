package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);
        Driver driver = new Driver();
        driver.setName("Nazar");
        driver.setLicenseNumber("113TY67IO");
        driverService.create(driver);
        driver.setLicenseNumber("LI766P34K");
        driverService.update(driver);
        driverService.getAll().forEach(System.out::println);
        driverService.delete(driver.getId());
        driverService.getAll().forEach(System.out::println);

        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Lexus");
        manufacturer.setCountry("Japan");
        manufacturerService.create(manufacturer);
        manufacturerService.getAll().forEach(System.out::println);
        manufacturer.setCountry("China");
        manufacturerService.update(manufacturer);
        manufacturerService.getAll().forEach(System.out::println);
        manufacturerService.delete(manufacturer.getId());
        manufacturerService.getAll().forEach(System.out::println);
    }
}
