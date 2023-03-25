package mate.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final ManufacturerService manufacturerService
            = (ManufacturerService) injector.getInstance(ManufacturerService.class);
    private static final DriverService driverService
            = (DriverService) injector.getInstance(DriverService.class);

    public static void main(String[] args) {
        createManufacturers().forEach(manufacturerService::create);
        Manufacturer manufacturer = manufacturerService.getAll().stream()
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("Couldn't get any manufacturer"));
        manufacturer.setCountry(manufacturer.getCountry().toUpperCase());
        manufacturerService.update(manufacturer);
        manufacturerService.get(manufacturer.getId());
        manufacturerService.delete(manufacturer.getId());
        createDrivers().forEach(driverService::create);
        Driver driver = driverService.getAll().stream()
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("Couldn't get any driver"));
        driver.setLicenseNumber(driver.getLicenseNumber().toUpperCase());
        driverService.update(driver);
        driverService.get(driver.getId());
        driverService.delete(driver.getId());
    }

    private static List<Manufacturer> createManufacturers() {
        List<Manufacturer> manufacturers = new ArrayList<>();
        manufacturers.add(new Manufacturer(0L, "Audi", "Germany"));
        manufacturers.add(new Manufacturer(0L, "BMW", "Germany"));
        manufacturers.add(new Manufacturer(0L, "Chevrolet", "USA"));
        return manufacturers;
    }

    private static List<Driver> createDrivers() {
        List<Driver> drivers = new ArrayList<>();
        drivers.add(new Driver(0L, "Alice", "aa1111"));
        drivers.add(new Driver(0L, "Bob", "bb2222"));
        drivers.add(new Driver(0L, "Charles", "cc3333"));
        return drivers;
    }
}
