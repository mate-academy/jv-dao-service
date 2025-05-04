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

        Manufacturer datsun = new Manufacturer("Datsun", "Japan");
        Manufacturer toyota = new Manufacturer("Toyota", "Japan");
        manufacturerService.create(datsun);
        manufacturerService.create(toyota);

        System.out.println("All manufacturers");
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println(System.lineSeparator());

        Manufacturer manufacturer = manufacturerService.get(datsun.getId());
        System.out.println("Manufacturer by id of " + datsun.getId());
        System.out.println(manufacturer);
        System.out.println(System.lineSeparator());

        manufacturer.setName("Nissan");
        Manufacturer updatedManufacturer = manufacturerService.update(manufacturer);
        System.out.println("Updated manufacturer");
        System.out.println(updatedManufacturer);
        System.out.println(System.lineSeparator());

        manufacturerService.delete(datsun.getId());
        System.out.println("All manufacturers");
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println(System.lineSeparator());

        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);

        Driver taras = new Driver("Taras", "AA0000AA");
        Driver borys = new Driver("Borys", "AA0001AA");
        driverService.create(taras);
        driverService.create(borys);

        System.out.println("All drivers");
        driverService.getAll().forEach(System.out::println);
        System.out.println(System.lineSeparator());

        Driver driver = driverService.get(taras.getId());
        System.out.println("Driver by id of" + taras.getId());
        System.out.println(driver);
        System.out.println(System.lineSeparator());

        driver.setName("Grygorii");
        Driver updatedDriver = driverService.update(driver);
        System.out.println("Updated driver");
        System.out.println(updatedDriver);
        System.out.println(System.lineSeparator());

        driverService.delete(taras.getId());
        System.out.println("All drivers");
        driverService.getAll().forEach(System.out::println);
    }
}
