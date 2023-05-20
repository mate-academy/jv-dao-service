package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver();
        driverService.create(driver);
        driverService.get(driver.getId());
        driverService.update(driver);
        driverService.delete(driver.getId());
        driverService.getAll().stream()
                .forEach(System.out::println);
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer();
        manufacturerService.create(manufacturer);
        manufacturerService.get(manufacturer.getId());
        manufacturerService.update(manufacturer);
        manufacturerService.delete(manufacturer.getId());
        manufacturerService.getAll().stream()
                .forEach(System.out::println);
    }
}
