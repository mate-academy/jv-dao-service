package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Application {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void run() {
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);
        Manufacturer manufacturer = new Manufacturer("Audi", "German");
        Driver driver = new Driver("Black", "3942");
        manufacturer = manufacturerService.create(manufacturer);
        driver = driverService.create(driver);
        manufacturer.setName("Nissan");
        manufacturerService.update(manufacturer);
        System.out.println(manufacturerService.get(1L));
        driver.setName("White");
        driverService.update(driver);
        System.out.println(driverService.get(1L));
        manufacturerService.delete(manufacturer.getId());
        driverService.delete(driver.getId());
        List<Manufacturer> manufacturers = manufacturerService.getAll();
        manufacturers.forEach(System.out::println);
        List<Driver> drivers = driverService.getAll();
        drivers.forEach(System.out::println);
    }
}
