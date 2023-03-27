package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final ManufacturerService manufacturerService = (ManufacturerService)
            injector.getInstance(ManufacturerService.class);
    private static final DriverService driverService = (DriverService)
            injector.getInstance(DriverService.class);

    public static void main(String[] args) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("test");
        manufacturer.setCountry("Ukraine");
        System.out.println(manufacturerService.create(manufacturer));

        manufacturer.setCountry("USA");
        System.out.println(manufacturerService.update(manufacturer));

        System.out.println(manufacturerService.get(manufacturer.getId()));

        System.out.println(manufacturerService.delete(manufacturer.getId()));

        manufacturerService.getAll().forEach(System.out::println);

        Driver driver = new Driver();
        driver.setName("Bob");
        driver.setLicenseNumber("12345");
        System.out.println(driverService.create(driver));

        driver.setLicenseNumber("12312");
        System.out.println(driverService.update(driver));

        System.out.println(driverService.get(driver.getId()));

        System.out.println(driverService.delete(driver.getId()));

        driverService.getAll().forEach(System.out::println);
    }
}
