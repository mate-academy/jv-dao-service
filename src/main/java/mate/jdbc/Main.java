package mate.jdbc;

import java.util.Optional;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final ManufacturerService manufacturerService = (ManufacturerService)
            injector.getInstance(ManufacturerService.class);
    private static final DriverService driverService = (DriverService)
            injector.getInstance(DriverService.class);

    public static void main(String[] args) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Toyota");
        manufacturer.setCountry("Japan");
        manufacturerService.create(manufacturer);
        Optional<Manufacturer> optionalManufacturer = manufacturerService.get(1L);
        if (optionalManufacturer.isPresent()) {
            manufacturer = optionalManufacturer.get();
            manufacturer.setName("Renault");
            manufacturer.setCountry("France");
            Manufacturer updatedManufacturer = manufacturerService.update(manufacturer);
            System.out.println(updatedManufacturer);
        }
        manufacturerService.delete(1L);
        manufacturerService.getAll().forEach(System.out::println);
        Driver driver = new Driver();
        driver.setName("Jack");
        driver.setLicenseNumber("443789");
        driverService.create(driver);
        Optional<Driver> optionalDriver = driverService.get(2L);
        if (optionalDriver.isPresent()) {
            driver = optionalDriver.get();
            driver.setName("Mark");
            driver.setLicenseNumber("589456");
            Driver updatedDriver = driverService.update(driver);
            System.out.println(updatedDriver);
        }
        driverService.delete(3L);
        driverService.getAll().forEach(System.out::println);
    }
}
