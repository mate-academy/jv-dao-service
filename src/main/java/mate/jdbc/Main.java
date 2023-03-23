package mate.jdbc;

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

        var manufacturers = manufacturerService.getAll();
        manufacturers.forEach(System.out::println);

        toyotaManufacturer.setCountry("Nepal");
        manufacturerService.update(toyotaManufacturer);
        manufacturerService.delete(toyotaManufacturer.getId());

        Driver driver = new Driver("Artem", "MN605640");
        driverService.create(driver);

        var drivers = driverService.getAll();
        drivers.forEach(System.out::println);

        driver.setName("Artas");
        driverService.update(driver);
        driverService.get(driver.getId());
        driverService.delete(driver.getId());
    }
}
