package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.impl.DriverService;
import mate.jdbc.service.impl.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Audi");
        manufacturer.setCountry("Germany");
        manufacturerService.create(manufacturer);
        manufacturer.setName("Skoda");
        manufacturer.setCountry("Czech");
        manufacturerService.update(manufacturer);
        manufacturerService.get(7L);
        manufacturerService.delete(1L);

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver();
        driver.setName("Oleg");
        driver.setLicenseNumber("12345");
        driverService.create(driver);
        driver.setName("Pavel");
        driver.setLicenseNumber("56789");
        driverService.update(driver);
        driverService.get(2L);
        driverService.delete(1L);

        System.out.println(driverService.getAll());
        System.out.println(manufacturerService.getAll());
    }
}
