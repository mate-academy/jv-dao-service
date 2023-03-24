package mate.jdbc;

import java.util.Arrays;
import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final ManufacturerService manufacturerService =
            (ManufacturerService) injector.getInstance(ManufacturerService.class);
    private static final DriverService driverService =
            (DriverService) injector.getInstance(DriverService.class);

    public static void main(String[] args) {
        List<Manufacturer> manufacturers = Arrays.asList(
                new Manufacturer("Hyundai", "South Korea"),
                new Manufacturer("Toyota", "Japan"),
                new Manufacturer("Tesla", "USA"));
        manufacturers.forEach(manufacturerService::create);
        Manufacturer manufacturer = manufacturerService.get(1L);
        manufacturerService.delete(manufacturer.getId());
        manufacturerService.update(new Manufacturer("Renault", "France"));
        List<Driver> drivers = Arrays.asList(
                new Driver("Petrovych", "DT23453"),
                new Driver("Ivanovych", "SC25325"),
                new Driver("Antonovych", "FF35654")
        );
        drivers.forEach(driverService::create);
        Driver driver = driverService.get(1L);
        driverService.delete(driver.getId());
        driverService.update(new Driver(1L,"Volodymyrovych", "KK325564"));
        System.out.println(manufacturerService.getAll());
        System.out.println(driverService.getAll());
    }
}
