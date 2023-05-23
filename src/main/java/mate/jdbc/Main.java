package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        final DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("BYD");
        manufacturer.setCountry("China");
        manufacturerService.create(manufacturer);
        manufacturer.setCountry("Ukraine");
        manufacturerService.update(manufacturer);
        manufacturerService.delete(manufacturer.getId());
        manufacturerService.getAll();
        Driver driver = new Driver();
        driver.setName("Melnychuk");
        driver.setLicenseNumber("ZX1234");
        driverService.create(driver);
        driver.setLicenseNumber("ZC1357");
        driverService.update(driver);
        driverService.delete(driver.getId());
        driverService.getAll();
    }
}
