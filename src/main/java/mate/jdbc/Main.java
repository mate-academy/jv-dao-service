package mate.jdbc;

import mate.jdbc.dao.DriverDaoImpl;
import mate.jdbc.dao.ManufacturerDaoImpl;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.DriverServiceImpl;
import mate.jdbc.service.ManufacturerService;
import mate.jdbc.service.ManufacturerServiceImpl;

public class Main {

    private static final Injector service = Injector.getInstance("mate.jdbc.service");

    public static void main(String[] args) {
        ManufacturerService manufacturerService
                = new ManufacturerServiceImpl(new ManufacturerDaoImpl());
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("AUdi");
        manufacturer.setCountry("Germany");
        manufacturerService.create(manufacturer);
        manufacturerService.get(manufacturer.getId());
        manufacturerService.delete(manufacturer.getId());
        manufacturerService.update(manufacturer);
        manufacturerService.getAll().forEach(System.out::println);
        DriverService driverService = new DriverServiceImpl(new DriverDaoImpl());
        Driver driver = new Driver();
        driver.setLicenseNumber("12345678");
        driver.setName("Maks");
        driverService.create(driver);
        driverService.get(driver.getId());
        driverService.delete(1L);
        driverService.update(driver);
        driverService.getAll().forEach(System.out::println);
    }
}
