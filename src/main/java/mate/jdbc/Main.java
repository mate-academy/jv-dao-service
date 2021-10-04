package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.setName("Pavel");
        driver.setLicenseNumber("pa123");
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        driverService.create(driver);
        driver.setName("Ivan");
        driver.setLicenseNumber("iv123");
        driverService.create(driver);
        driverService.getAll().forEach(System.out::println);
        System.out.println(driverService.get(1L));
        driver.setId(1L);
        System.out.println(driverService.update(driver));
        System.out.println(driverService.delete(1L));
        System.out.println(System.lineSeparator());
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("mazda");
        manufacturer.setCountry("japan");
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        manufacturerService.create(manufacturer);
        manufacturer.setName("skoda");
        manufacturer.setCountry("czech republic");
        manufacturerService.create(manufacturer);
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println(manufacturerService.get(1L));
        manufacturer.setId(1L);
        System.out.println(manufacturerService.update(manufacturer));
        System.out.println(manufacturerService.delete(1L));
    }
}
