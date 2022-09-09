package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    public static void main(String[] args) {
        Injector injector = Injector.getInstance("mate.jdbc");
        DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver("Oleg", "GH851678");
        System.out.println(driverService.create(driver));
        driver = new Driver("Jhon", "FI841687");
        System.out.println(driverService.create(driver));
        driver = new Driver("Max", "FI886538");
        System.out.println(driverService.create(driver));
        System.out.println(driverService.get(driver.getId()));
        System.out.println(driverService.update(driver));
        System.out.println(driverService.delete(driver.getId()));
        driverService.getAll().forEach(System.out::println);
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        manufacturerService.getAll().forEach(System.out::println);
        Manufacturer manufacturer = new Manufacturer("ford", "USA");
        System.out.println(manufacturerService.create(manufacturer));
        System.out.println(manufacturerService.get(manufacturer.getId()));
        System.out.println(manufacturerService.update(manufacturer));
        manufacturerService.delete(manufacturer.getId());
    }
}
