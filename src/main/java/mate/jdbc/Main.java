package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("bmw");
        manufacturer.setCountry("germany");
        System.out.println(manufacturerService.create(manufacturer));
        System.out.println(manufacturerService.get(manufacturer.getId()));
        manufacturerService.getAll().forEach(System.out::println);
        manufacturer.setName("mercedes-benz");
        System.out.println(manufacturerService.update(manufacturer));
        System.out.println(manufacturerService.delete(manufacturer.getId()));

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver();
        driver.setName("bob");
        driver.setLicenseNumber("b123");
        System.out.println(driverService.create(driver));
        System.out.println(driverService.get(driver.getId()));
        driverService.getAll().forEach(System.out::println);
        driver.setLicenseNumber("l456");
        System.out.println(driverService.update(driver));
        System.out.println(driverService.delete(driver.getId()));
    }
}
