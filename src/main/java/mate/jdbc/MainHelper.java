package mate.jdbc;

import java.util.NoSuchElementException;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class MainHelper {
    private final ManufacturerService manufacturerService;
    private final DriverService driverService;

    public MainHelper(ManufacturerService manufacturerService, DriverService driverService) {
        this.manufacturerService = manufacturerService;
        this.driverService = driverService;
    }

    public void createManufacturer(Long id, String name, String country) {
        Manufacturer manufacturer = new Manufacturer(id, name, country);
        manufacturerService.create(manufacturer);
    }

    public void updateManufacturer(Long id, String name, String country) {
        Manufacturer manufacturer = manufacturerService.get(id);
        manufacturer.setName(name);
        manufacturer.setCountry(country);
        manufacturerService.update(manufacturer);
    }

    public void deleteManufacturer(Long id) {
        manufacturerService.delete(id);
    }

    public void getDriver(Long id) {
        try {
            Driver driver = driverService.get(id);
            System.out.println(driver);
        } catch (NoSuchElementException e) {
            System.out.println("Driver not found");
        }
    }

    public Driver createDriver(Long id, String name, String licenseNumber) {
        Driver driver = new Driver(id, name, licenseNumber);
        return driverService.create(driver);
    }

    public void deleteDriver(Long id) {
        driverService.delete(id);
    }
}
