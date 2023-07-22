package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Application {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void run() {
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        Driver driver = new Driver("Jane", "qwerty007");
        driverService.create(driver);
        driverService.getAll();
        driverService.get(driver.getId());
        driver.setName("Mike");
        driver.setLicenseNumber("qwerty003");
        driverService.update(driver);
        driverService.delete(driver.getId());

        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer("Volvo", "Germany");
        manufacturerService.create(manufacturer);
        manufacturerService.getAll();
        manufacturerService.get(manufacturer.getId());
        manufacturer.setName("Lexus");
        manufacturer.setCountry("Japan");
        manufacturerService.update(manufacturer);
        manufacturerService.delete(manufacturer.getId());
    }
}
