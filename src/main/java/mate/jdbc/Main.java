package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("KIA");
        manufacturer.setCountry("Korea");
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        manufacturerService.create(manufacturer);
        manufacturer.setCountry("Japan");
        manufacturerService.update(manufacturer);
        manufacturerService.delete(manufacturer.getId());
        manufacturerService.getAll();
        Driver driver = new Driver();
        driver.setLicenseNumber("1111-0000-2222");
        driver.setName("Frank");
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        driverService.create(driver);
        driver.setLicenseNumber("1010101010");
        driverService.update(driver);
        driverService.delete(driver.getId());
        driverService.getAll();
    }
}
