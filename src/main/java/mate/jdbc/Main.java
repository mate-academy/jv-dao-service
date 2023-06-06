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
        List<Manufacturer> manufacturers = List.of(
                new Manufacturer("Ford", "Usa"),
                new Manufacturer("Mercedes", "Germany"),
                new Manufacturer("Lamborghini", "Italy"));
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        manufacturers.forEach(manufacturerService::create);
        Manufacturer manufacturer = manufacturerService.get(2L);
        manufacturer.setName("Bmw");
        manufacturerService.update(manufacturer);
        manufacturerService.getAll().forEach(System.out::println);
        manufacturerService.delete(manufacturer.getId());
        List<Driver> drivers = List.of(
                new Driver("Ivan", "123456"),
                new Driver("Vlad", "723858"),
                new Driver("Alexander", "234694"));
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        drivers.forEach(driverService::create);
        Driver driver = driverService.get(1L);
        driver.setName("Ilya");
        driverService.update(driver);
        driverService.getAll().forEach(System.out::println);
        driverService.delete(driver.getId());
    }
}
