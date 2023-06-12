package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);

        Manufacturer manufacturer = new Manufacturer("Volkswagen","Germany");
        manufacturerService.create(manufacturer);
        manufacturer.setName("Toyota");
        manufacturer.setCountry("Japan");
        manufacturerService.update(manufacturer);
        manufacturerService.get(7L);
        manufacturerService.delete(1L);

        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);
        Driver driver = new Driver();
        driver.setName("Roma");
        driver.setLicenseNumber("1047");
        driverService.create(driver);
        driver.setName("Serhii");
        driver.setLicenseNumber("5839");
        driverService.update(driver);
        driverService.get(3L);
        driverService.delete(1L);
        System.out.println(driverService.getAll());
        System.out.println(manufacturerService.getAll());
    }
}
