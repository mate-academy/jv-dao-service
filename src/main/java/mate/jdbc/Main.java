package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Driver driver = new Driver("nameCreated", "licenseCreated");
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        driverService.getAll().forEach(System.out::println);
        System.out.print(System.lineSeparator());
        driver = driverService.create(driver);
        driverService.getAll().forEach(System.out::println);
        System.out.print(System.lineSeparator());
        System.out.println(driverService.get(driver.getId()));
        System.out.print(System.lineSeparator());
        driver.setName("nameUpdated");
        driverService.update(driver);
        driverService.getAll().forEach(System.out::println);
        driverService.delete(driver.getId());
        System.out.print(System.lineSeparator());
        driverService.getAll().forEach(System.out::println);
        System.out.println(System.lineSeparator());
    }
}
