package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance("mate.jdbc");
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Daewoo");
        manufacturer.setCountry("Korea");

        manufacturerService.create(manufacturer);

        manufacturerService.getAll().forEach(System.out::println);
        System.out.println(manufacturerService.get(1L));

        manufacturer.setCountry("USA");
        manufacturer.setId(3L);
        manufacturerService.update(manufacturer);
        manufacturerService.getAll().forEach(System.out::println);

        manufacturerService.delete(3L);
        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService = (DriverService) injector.getInstance("mate.jdbc");
        Driver driver = new Driver();
        driver.setName("Boris");
        driver.setLicenceNumber("123321");

        driverService.create(driver);

        driverService.getAll().forEach(System.out::println);
        System.out.println(driverService.get(1L));

        driver.setName("Maksim");
        driver.setId(5L);
        driverService.update(driver);
        driverService.getAll().forEach(System.out::println);

        driverService.delete(5L);
        driverService.getAll().forEach(System.out::println);
    }
}
