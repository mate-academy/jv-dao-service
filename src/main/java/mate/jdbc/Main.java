package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector inject = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) inject.getInstance(DriverService.class);
        Driver driver = new Driver();
        driver.setName("Mike");
        driver.setLicenseNumber("BB3030");
        Driver newDriver = driverService.create(driver);
        System.out.println(newDriver);

        ManufacturerService manufacturerService
                = (ManufacturerService) inject.getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Peugeot");
        manufacturer.setCountry("France");
        Manufacturer newManufacturer = manufacturerService.create(manufacturer);
        System.out.println(newManufacturer);

        System.out.println(driverService.update(newDriver));
        System.out.println(manufacturerService.update(newManufacturer));

        System.out.println(driverService.delete(newDriver.getId()));
        System.out.println(manufacturerService.delete(newManufacturer.getId()));

        System.out.println(driverService.get(2L));
        System.out.println(manufacturerService.get(2L));

        System.out.println(driverService.getAll().get(0));
        System.out.println(manufacturerService.getAll().get(0));
    }
}
