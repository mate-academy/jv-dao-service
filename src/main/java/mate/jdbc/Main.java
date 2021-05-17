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
        manufacturer.setName("manu name");
        manufacturer.setCountry("Ukraine");

        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        manufacturerService.create(manufacturer);
        System.out.println(manufacturerService.get(manufacturer.getId()));
        manufacturerService.getAll().forEach(System.out::println);

        Manufacturer newManufacturer = new Manufacturer();
        newManufacturer.setName("new manu name");
        newManufacturer.setCountry("UK");
        newManufacturer.setId(manufacturer.getId());
        manufacturerService.update(newManufacturer);
        manufacturerService.delete(newManufacturer.getId());

        Driver driver = new Driver();
        driver.setName("driver name");
        driver.setLicenseNumber("KK-4850");

        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);
        driverService.createDriver(driver);
        System.out.println(driverService.getDriver(driver.getId()));
        driverService.getAllDrivers().forEach(System.out::println);

        Driver newDriver = new Driver();
        newDriver.setName("new driver name");
        newDriver.setLicenseNumber("MM-4850");
        newDriver.setId(driver.getId());
        driverService.updateDriver(newDriver);
        driverService.deleteDriver(newDriver.getId());
    }
}
