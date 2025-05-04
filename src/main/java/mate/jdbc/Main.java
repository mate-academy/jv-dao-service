package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        manufacturerService.getAll().forEach(System.out::println);
        Manufacturer manufacturer = new Manufacturer("<SONY>", "Japan");
        manufacturerService.create(manufacturer);
        manufacturer = new Manufacturer("DELL", "Usa");
        manufacturer = manufacturerService.create(manufacturer);
        System.out.println(manufacturerService.get(manufacturer.getId()));
        manufacturer.setCountry(manufacturer.getCountry().toUpperCase());
        System.out.println(manufacturerService.update(manufacturer));
        manufacturerService.delete(manufacturer.getId());
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        driverService.getAll().forEach(System.out::println);
        Driver driver = new Driver("Petro", "UA1234567");
        driverService.create(driver);
        driver = new Driver("Max", "UA7777777");
        driver = driverService.create(driver);
        System.out.println(driverService.get(driver.getId()));
        driver.setName(driver.getName().toUpperCase());
        System.out.println(driverService.update(driver));
        driverService.delete(driver.getId());

    }
}
