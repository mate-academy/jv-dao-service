package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");
    private static DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
    private static ManufacturerService manufacturerService = (ManufacturerService) injector.getInstance(ManufacturerService.class);

    public static void main(String[] args) {
        Driver driver = new Driver("Statik", "gfh123");
        driverService.create(driver);
        driver.setName("Stas");
        driverService.update(driver);
        driverService.delete(1L);
        driverService.getAll().forEach(System.out::println);
        Manufacturer manufacturer = new Manufacturer("Alex", "Ukraine");
        manufacturerService.create(manufacturer);
        driver.setName("Lecha");
        manufacturerService.update(manufacturer);
        manufacturerService.delete(1L);
        manufacturerService.getAll().forEach(System.out::println);
    }
}
