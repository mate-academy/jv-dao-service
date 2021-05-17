package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);

        Manufacturer manufacturer = new Manufacturer("TEST", "TEST_COUNTRY");
        manufacturerService.create(manufacturer);
        manufacturerService.get(manufacturer.getId());
        manufacturerService.getAll();
        manufacturer.setName("test");
        manufacturerService.update(manufacturer);
        manufacturerService.delete(manufacturer.getId());

        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);

        Driver driver = new Driver("TEST_DRIVER_JOHN", "NA123467890");
        driverService.create(driver);
        driverService.get(driver.getId());
        driverService.getAll();
        driver.setName("test_driver");
        driverService.update(driver);
        driverService.delete(driver.getId());

        System.out.println("Manufacturers");
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println("Drivers");
        driverService.getAll().forEach(System.out::println);
    }
}
