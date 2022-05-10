package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        Driver driver = new Driver(null, "Alex", "1255532");
        Driver secondDriver = new Driver(null, "Bob", "4932493");
        driverService.create(driver);
        driverService.create(secondDriver);
        driverService.getAll().forEach(System.out::println);
        driverService.delete(secondDriver.getId());

        ManufacturerService manufacturer = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        Manufacturer firstManufacturer = new Manufacturer(null, "FORD", "USA");
        Manufacturer secondManufacturer = new Manufacturer(null, "RENO", "FRANC");
        manufacturer.create(firstManufacturer);
        manufacturer.create(secondManufacturer);
        manufacturer.getAll().forEach(System.out::println);
        manufacturer.delete(secondManufacturer.getId());
    }
}
