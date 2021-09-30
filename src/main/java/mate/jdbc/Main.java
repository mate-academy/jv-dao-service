package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");
    private static ManufacturerService manufacturerService =
            (ManufacturerService) injector.getInstance(ManufacturerService.class);
    private static DriverService driverService =
            (DriverService) injector.getInstance(DriverService.class);
    private static Manufacturer manufacturer;
    private static Driver driver;

    public static void main(String[] args) {
        manufacturer = new Manufacturer("Tesla", "USA");
        manufacturerService.create(manufacturer);
        System.out.println(manufacturerService.get(11L));
        manufacturerService.getAll().forEach(System.out::println);
        manufacturer = manufacturerService.get(33L);
        manufacturer.setName("Toyota");
        manufacturer.setCountry("Japan");
        System.out.println(manufacturerService.update(manufacturer));
        manufacturerService.delete(12L);

        driver = new Driver("Sem", "333");
        driverService.create(driver);
        System.out.println(driverService.get(2L));
        driverService.getAll().forEach(System.out::println);
        driver = driverService.get(2L);
        driver.setName("Bob");
        driver.setLicenseNumber("1");
        System.out.println(driverService.update(driver));
        driverService.delete(2L);
    }
}
