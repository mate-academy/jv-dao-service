package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    public static void main(String[] args) {
        Injector injector = Injector.getInstance("mate.jdbc");

        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);

        manufacturerService.create(new Manufacturer("Datsun", "Japan"));
        manufacturerService.create(new Manufacturer("Toyota", "Japan"));

        System.out.println("All manufacturers");
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println(System.lineSeparator());

        Manufacturer manufacturer = manufacturerService.get(1L);
        System.out.println("Manufacturer by id of 1");
        System.out.println(manufacturer);
        System.out.println(System.lineSeparator());

        manufacturer.setName("Nissan");
        Manufacturer updatedManufacturer = manufacturerService.update(manufacturer);
        System.out.println("Updated manufacturer");
        System.out.println(updatedManufacturer);
        System.out.println(System.lineSeparator());

        manufacturerService.delete(1L);
        System.out.println("All manufacturers");
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println(System.lineSeparator());

        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);

        driverService.create(new Driver("Taras", "AA0000AA"));
        driverService.create(new Driver("Borys", "AA0001AA"));

        System.out.println("All drivers");
        driverService.getAll().forEach(System.out::println);
        System.out.println(System.lineSeparator());

        Driver driver = driverService.get(1L);
        System.out.println("Driver by id of 1");
        System.out.println(driver);
        System.out.println(System.lineSeparator());

        driver.setName("Grygorii");
        Driver updatedDriver = driverService.update(driver);
        System.out.println("Updated driver");
        System.out.println(updatedDriver);
        System.out.println(System.lineSeparator());

        driverService.delete(1L);
        System.out.println("All drivers");
        driverService.getAll().forEach(System.out::println);
    }
}
