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
        Manufacturer manufacturer = new Manufacturer(null, "ZAZ", "Ukraine");
        manufacturerService.create(manufacturer);
        manufacturerService.create(new Manufacturer(null, "OPEL", "GERMANY"));
        manufacturerService.getAll().forEach(System.out::println);
        manufacturer.setName("FORD");
        manufacturer.setCountry("USA");
        manufacturerService.update(manufacturer);
        manufacturerService.getAll().forEach(System.out::println);
        manufacturerService.delete(2L);
        manufacturerService.getAll().forEach(System.out::println);
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver(null, "Vova", "123321");
        driverService.create(driver);
        driverService.create(new Driver(null, "Kolya", "777777"));
        driverService.getAll().forEach(System.out::println);
        driver.setName("Pasha");
        driver.setLicenseNumber("456654");
        driverService.update(driver);
        driverService.getAll().forEach(System.out::println);
        driverService.delete(2L);
        driverService.getAll().forEach(System.out::println);
    }
}
