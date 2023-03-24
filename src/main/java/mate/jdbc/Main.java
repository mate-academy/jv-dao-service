package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector
            .getInstance("mate.jdbc");
    private static final ManufacturerService manufacturerService = (ManufacturerService) injector
            .getInstance(ManufacturerService.class);
    public static final DriverService driverService = (DriverService) injector
            .getInstance(DriverService.class);

    public static void main(String[] args) {
        Manufacturer toyotaManufacturer = new Manufacturer("Toyota", "Japan");
        manufacturerService.create(toyotaManufacturer);

        System.out.println(manufacturerService
                .get(toyotaManufacturer.getId()));

        List<Manufacturer> manufacturers = manufacturerService.getAll();
        manufacturers.forEach(System.out::println);

        toyotaManufacturer.setCountry("Nepal");
        manufacturerService.update(toyotaManufacturer);
        boolean isDeleted = manufacturerService.delete(toyotaManufacturer.getId());
        System.out.println(isDeleted);

        Driver driver = new Driver("Artem", "MN605640");
        driverService.create(driver);

        List<Driver> drivers = driverService.getAll();
        drivers.forEach(System.out::println);

        driver.setName("Artas");
        driverService.update(driver);
        System.out.println(driverService.get(driver.getId()));
        boolean isDeletedDriver = driverService.delete(driver.getId());
        System.out.println(isDeletedDriver);
    }
}
