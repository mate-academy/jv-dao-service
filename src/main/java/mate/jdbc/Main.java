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
        Manufacturer manufacturer = new Manufacturer("BMW","Germany");
        manufacturerService.create(manufacturer);
        manufacturer.setName("Nissan");
        manufacturer.setCountry("Japan");
        Manufacturer manufacturerId = manufacturerService.update(manufacturer);
        manufacturerService.get(manufacturerId.getId());
        manufacturerService.delete(manufacturerId.getId());

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver();
        driver.setName("Alex");
        driver.setLicenseNumber("1499");
        driverService.create(driver);
        driver.setName("Artem");
        driver.setLicenseNumber("0982");
        Driver driverId = driverService.update(driver);
        driverService.get(driverId.getId());
        driverService.delete(driverId.getId());

        System.out.println(driverService.getAll());
        System.out.println(manufacturerService.getAll());
    }
}
