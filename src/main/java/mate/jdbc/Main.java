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
        System.out.println(driverService.create(driver));
        System.out.println(driverService.get(1L));
        System.out.println(driverService.delete(2L));
        System.out.println(driverService.update(driver));
        System.out.println(driverService.getAll());
        driverService.getAll().forEach(System.out::println);

        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer("Toyota", "Japan");
        System.out.println(manufacturerService.create(manufacturer));
        System.out.println(manufacturerService.get(1L));
        System.out.println(manufacturerService.delete(2L));
        System.out.println(manufacturerService.update(manufacturer));
        System.out.println(manufacturerService.getAll());
        driverService.getAll().forEach(System.out::println);
    }
}
