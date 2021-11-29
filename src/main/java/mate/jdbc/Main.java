package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.driver.DriverService;
import mate.jdbc.service.manufacturer.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver("Konstantin", "777");
        driverService.create(driver);
        driverService.getAll().forEach(System.out::println);
        System.out.println(driverService.get(driver.getId()));
        driver.setLicenseNumber("666");
        driverService.update(driver);
        driverService.delete(driver.getId());
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer("volkswagen", "Ukraine");
        manufacturerService.create(manufacturer);
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println(manufacturerService.get(manufacturer.getId()));
        manufacturer.setName("Germany");
        System.out.println(manufacturerService.update(manufacturer));
        manufacturerService.delete(manufacturer.getId());
    }
}
