package mate.jdbc;

import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.impl.DriverServiceImpl;

public class Main {
    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.setId(9L);
        driver.setLicenseNumber("854565");
        driver.setName("B5ob");
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setCountry("Ukraine");
        manufacturer.setName("Zaz");
        DriverService driverService = new DriverServiceImpl();
        driverService.create(driver);
        driverService.update(driver);
        driverService.getAll().forEach(System.out::println);
    }
}
