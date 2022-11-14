package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    public static void main(String[] args) {
        Injector injector = Injector.getInstance("mate.jdbc");

        final DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);
        final ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);

        manufacturerService.getAll().forEach(System.out::println);
        Manufacturer manufacturer = manufacturerService.get(1L);
        manufacturer.setCountry("Ukraine");
        manufacturerService.update(manufacturer);
        manufacturerService.getAll().forEach(System.out::println);

        driverService.getAll().forEach(System.out::println);
        Driver driver = driverService.get(1L);
        driver.setLicenseNumber("000000");
        driverService.update(driver);
        driverService.getAll().forEach(System.out::println);
    }
}
