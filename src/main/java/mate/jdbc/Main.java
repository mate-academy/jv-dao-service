package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        Manufacturer toyota = new Manufacturer();
        toyota.setName("Toyota");
        toyota.setCountry("Japan");
        manufacturerService.create(toyota);
        manufacturerService.getAll().forEach(System.out::println);
        manufacturerService.delete(1L);
        System.out.println(manufacturerService.get(2L));
        manufacturerService.update(new Manufacturer(2L, "Volvo", "Swedish"));
        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        Driver driver = new Driver();
        driver.setName("Bob");
        driver.setLicenseNumber("4321");
        driverService.create(driver);
        driverService.getAll().forEach(System.out::println);
        System.out.println(driverService.get(3L));
        driverService.delete(1L);
        driverService.getAll().forEach(System.out::println);
        driverService.update(new Driver(2L, "Philip", "2587"));
        driverService.getAll().forEach(System.out::println);

    }
}
