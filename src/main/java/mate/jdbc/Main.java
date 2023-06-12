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
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);

        System.out.println(manufacturerService.getAll());

        Manufacturer manufacturer = new Manufacturer("Chevrolet", "USA");
        System.out.println(manufacturerService.create(manufacturer));
        System.out.println(manufacturerService.get(manufacturer.getId()));

        manufacturer.setCountry("DAEWOO-ZAZ");
        manufacturer.setName("Ukraine");
        System.out.println(manufacturerService.update(manufacturer));

        System.out.println(manufacturerService.delete(manufacturer.getId()));

        System.out.println(manufacturerService.getAll());

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        System.out.println(driverService.getAll());

        Driver driver = new Driver("Sofia", "4");
        driverService.create(driver);
        driverService.get(driver.getId());

        driver.setName("Alice");
        driver.setLicenseNumber("12");
        driverService.update(driver);
        driverService.delete(driver.getId());

        System.out.println(driverService.getAll());

    }
}
