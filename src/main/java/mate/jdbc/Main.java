package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.serviceimpl.DriverService;
import mate.jdbc.serviceimpl.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);

        Manufacturer manufacturer = new Manufacturer("Lanos","Ukraine");
        manufacturerService.create(manufacturer);
        manufacturer.setName("Mitsubishi");
        manufacturer.setCountry("Japan");
        manufacturerService.update(manufacturer);
        manufacturerService.get(1L);
        manufacturerService.delete(2L);

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver("Petro", "123");
        driverService.create(driver);
        driver.setName("Stefania");
        driver.setLicenseNumber("321");
        driverService.update(driver);
        driverService.get(2L);
        driverService.delete(1L);

        System.out.println(driverService.getAll());
        System.out.println(manufacturerService.getAll());
    }
}
