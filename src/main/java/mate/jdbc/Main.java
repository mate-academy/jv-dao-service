package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.impl.DriverService;
import mate.jdbc.service.impl.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        driverServiseTest(driverService);
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        manufacturerServiceTest(manufacturerService);
    }

    private static void manufacturerServiceTest(ManufacturerService manufacturerService) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Daewo");
        manufacturer.setCountry("Sweden");
        System.out.println(manufacturerService.create(manufacturer));
        System.out.println(manufacturerService.get(1L));
        System.out.println(manufacturerService.delete(2L));
        System.out.println(manufacturerService.update(manufacturer));
        manufacturerService.getAll().forEach(System.out::println);
    }

    private static void driverServiseTest(DriverService driverService) {
        Driver driver = new Driver();
        driver.setName("Arthur");
        driver.setLicenseNumber("666");
        System.out.println(driverService.create(driver));
        System.out.println(driverService.get(1L));
        System.out.println(driverService.delete(2L));
        System.out.println(driverService.update(driver));
        driverService.getAll().forEach(System.out::println);
    }
}
