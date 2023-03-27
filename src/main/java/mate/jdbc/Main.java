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
        manufacturerService.create(manufacturer);
        manufacturer.setCountry("USA");
        manufacturerService.create(manufacturer);

        System.out.println(manufacturerService.get(1L));

        manufacturerService.delete(1L);

        manufacturer.setCountry("Ukraine");
        manufacturerService.update(manufacturer);

        manufacturerService.getAll().forEach(System.out::println);

        Driver driver = new Driver();
        driver.setName("Bob");
        driver.setLicenseNumber("12345");
        driverService.create(driver);
        driver.setLicenseNumber("54321");
        driverService.create(driver);

        System.out.println(driverService.get(1L));

        driverService.delete(1L);

        driver.setLicenseNumber("12312");
        driverService.update(driver);

        driverService.getAll().forEach(System.out::println);
    }
}
