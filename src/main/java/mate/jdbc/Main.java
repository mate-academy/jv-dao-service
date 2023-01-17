package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        //Test operation with driver
        Driver driver = new Driver();
        driver.setName("Bob");
        driver.setLicenseNumber("AB12345");
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driverWithId = driverService.create(driver);
        driverWithId.setName("Jack");
        driverWithId.setLicenseNumber("BC45678");
        driverService.update(driverWithId);
        Driver driverFromDb = driverService.get(driverWithId.getId()).orElseThrow(()
                -> new RuntimeException("Driver not found with id " + driverWithId.getId()));
        driverService.getAll().forEach(System.out::println);
        if (!driverService.delete(driverWithId.getId())) {
            throw new RuntimeException("Can't delete driver by id " + driverWithId.getId());
        }
        //Test operation with manufacturer
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("BMW");
        manufacturer.setCountry("Germany");
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturerWithId = manufacturerService.create(manufacturer);
        manufacturerWithId.setName("Fiat");
        manufacturerWithId.setCountry("Italy");
        manufacturerService.update(manufacturerWithId);
        Manufacturer manufacturerFromDb
                = manufacturerService.get(manufacturerWithId.getId()).orElseThrow(()
                        -> new RuntimeException("Manufacturer not found with id "
                + manufacturerWithId.getId()));
        manufacturerService.getAll().forEach(System.out::println);
        if (!manufacturerService.delete(manufacturerWithId.getId())) {
            throw new RuntimeException("Can't delete manufacturer by id "
                    + manufacturerWithId.getId());
        }
    }
}
