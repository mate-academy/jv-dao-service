package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Manufacturer manufacturer = new Manufacturer("Ford", "USA");
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        manufacturerService.create(manufacturer);
        manufacturerService.get(manufacturer.getId());
        manufacturerService.getAll();
        manufacturerService.update(manufacturer);
        manufacturerService.delete(manufacturer.getId());
        System.out.println();
        Driver driver = new Driver("Alex", "02847");
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        driverService.create(driver);
        driverService.get(driver.getId());
        driverService.getAll();
        driverService.update(driver);
        driverService.delete(driver.getId());
    }
}
