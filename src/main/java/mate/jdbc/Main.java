package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        testDriverService(driverService);
        testManufacturerService(manufacturerService);
    }

    private static void testDriverService(DriverService driverService) {
        Driver driver = new Driver();
        driver.setLicenseNumber("EA12FC");
        driver.setName("Ivan");

        driver = driverService.create(driver);
        driver.setLicenseNumber("AAA123");

        driverService.update(driver);

        driverService.delete(driver.getId());

        Driver driver2 = new Driver();
        driver2.setLicenseNumber("EA12FC");
        driver2.setName("Petro");

        driver2 = driverService.create(driver2);

        System.out.println(driverService.getAll());
    }

    private static void testManufacturerService(ManufacturerService manufacturerService) {
        Manufacturer manufacturer1 = new Manufacturer();
        manufacturer1.setName("Volkswagen");
        manufacturer1.setCountry("Germany");

        manufacturer1 = manufacturerService.create(manufacturer1);

        Manufacturer manufacturer2 = new Manufacturer();
        manufacturer2.setName("Toyota");
        manufacturer2.setCountry("Japan");

        manufacturer2 = manufacturerService.create(manufacturer2);

        System.out.println(manufacturerService.getAll());

        manufacturer1.setCountry("USA");

        manufacturerService.update(manufacturer1);

        System.out.println(manufacturerService.get(manufacturer1.getId()));

        manufacturerService.delete(manufacturer2.getId());

        System.out.println(manufacturerService.getAll());

        manufacturerService.get(1111L);
    }
}
