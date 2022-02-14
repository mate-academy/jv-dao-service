package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer exitManufacturer = manufacturerService.create(getNewManufacturer());
        exitManufacturer.setCountry("Poland");
        manufacturerService.update(exitManufacturer);
        manufacturerService.delete(1L);
        System.out.println(manufacturerService.getAll());

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver exitDriver = driverService.create(getNewDriver());
        driverService.update(exitDriver);
        driverService.delete(1L);
        System.out.println(driverService.getAll());
    }

    private static Manufacturer getNewManufacturer() {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setCountry("Germany");
        manufacturer.setName("Audi");
        return manufacturer;
    }

    private static Driver getNewDriver() {
        Driver driver = new Driver();
        driver.setName("Bob Dilan");
        driver.setLicenseNumber("124356AV");
        return driver;
    }
}
