package mate.jdbc;

import java.util.List;
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
        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);
        Manufacturer manufacturer = new Manufacturer("Honda", "Japan");
        Driver driver = new Driver("Bob", "12345");
        manufacturerService.create(manufacturer);
        driverService.create(driver);
        List<Manufacturer> manufacturers = manufacturerService.getAll();
        manufacturers.forEach(System.out::println);
        List<Driver> drivers = driverService.getAll();
        drivers.forEach(System.out::println);
        manufacturer.setName("Toyota");
        manufacturerService.update(manufacturer);
        driver.setName("Alice");
        driverService.update(driver);
        System.out.println(manufacturerService.get(1L));
        System.out.println(driverService.get(1L));
        manufacturerService.delete(manufacturer.getId());
        driverService.delete(driver.getId());
        manufacturers = manufacturerService.getAll();
        manufacturers.forEach(System.out::println);
        drivers = driverService.getAll();
        drivers.forEach(System.out::println);
    }
}
