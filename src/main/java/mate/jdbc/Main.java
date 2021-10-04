package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Driver driver = new Driver("Vasiliy","13335");
        Manufacturer manufacturer = new Manufacturer("volkswagen", "Germany");
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        driverService.create(driver);
        manufacturerService.create(manufacturer);
        driverService.getAll().forEach(System.out::println);
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println(driverService.get(1L));
        System.out.println(manufacturerService.get(27L));
        System.out.println(driverService.update(driver));
        System.out.println(manufacturerService.update(manufacturer));
        driverService.delete(1L);
        manufacturerService.delete(25L);
        driverService.getAll().forEach(System.out::println);
        manufacturerService.getAll().forEach(System.out::println);
    }
}
