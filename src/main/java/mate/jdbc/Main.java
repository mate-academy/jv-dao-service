package mate.jdbc;

import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;
import mate.jdbc.service.impl.DriverServiceImpl;
import mate.jdbc.service.impl.ManufacturerServiceImpl;

public class Main {
    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.setId(9L);
        driver.setLicenseNumber("854565");
        driver.setName("B5ob");
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setCountry("Ukraine");
        manufacturer.setName("Zaz");
        ManufacturerService manufacturerService = new ManufacturerServiceImpl();
        manufacturerService.get(8L);
        DriverService driverService = new DriverServiceImpl();
        driverService.create(driver);
        driverService.update(driver);
        driverService.getAll().forEach(System.out::println);
    }
}
