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
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Audi");
        manufacturer.setCountry("Germany");

        manufacturerService.create(manufacturer);

        manufacturerService.get(manufacturer.getId());

        manufacturerService.getAll();

        manufacturer.setName("BMV");
        manufacturerService.update(manufacturer);

        manufacturerService.delete(manufacturer.getId());

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver();
        driver.setName("Adam");
        driver.setLicenseNumber("38Q564L");

        driverService.create(driver);

        driverService.get(driver.getId());

        driverService.getAll();

        driver.setLicenseNumber("7D348P2");
        driverService.update(driver);

        driverService.delete(driver.getId());
    }
}
