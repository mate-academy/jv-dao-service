package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver("Alex", "51252");
        Driver driverId = driverService.create(driver);
        System.out.println(driverService.get(driverId.getId()));
        System.out.println(driverService.delete(driverId.getId()));
        System.out.println(driverService.update(driver));
        System.out.println(driverService.getAll());
        driverService.getAll().forEach(System.out::println);

        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer("Toyota", "Japan");
        Manufacturer manufacturerId = manufacturerService.create(manufacturer);
        System.out.println(manufacturerService.get(manufacturerId.getId()));
        System.out.println(manufacturerService.delete(manufacturerId.getId()));
        System.out.println(manufacturerService.update(manufacturer));
        System.out.println(manufacturerService.getAll());
        driverService.getAll().forEach(System.out::println);
    }
}
