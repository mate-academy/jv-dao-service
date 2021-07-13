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
        Manufacturer manufacturer1 = new Manufacturer("Toyota", "Japan");
        manufacturerService.create(manufacturer1);
        manufacturer1.setCountry("USA");
        manufacturer1.setName("Tesla");
        manufacturerService.update(manufacturer1);
        manufacturerService.delete(1L);
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver driver1 = new Driver("Bob", "12345");
        driverService.create(driver1);
        driver1.setLicenseNumber("12346");
        driverService.update(driver1);
    }
}
