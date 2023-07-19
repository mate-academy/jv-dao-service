package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector INJECTOR = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) INJECTOR.getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setCountry("Japan");
        manufacturer.setName("Toyota");

        Manufacturer createdManufacture = manufacturerService.create(manufacturer);

        System.out.println(manufacturerService.get(29L));

        manufacturerService.getAll().forEach(System.out::println);

        manufacturer.setCountry("USA");
        System.out.println(manufacturerService.update(manufacturer));

        manufacturerService.delete(25L);

        DriverService driverService = (DriverService) INJECTOR.getInstance(DriverService.class);
        Driver driver = new Driver();
        driver.setLicenseNumber("1234");
        driver.setName("John Wick");

        Driver createdDriver = driverService.create(driver);

        System.out.println(driverService.get(1L));

        driverService.getAll().forEach(System.out::println);

        driver.setName("Dominic Toretto");
        System.out.println(driverService.update(driver));

        driverService.delete(1L);
    }
}
