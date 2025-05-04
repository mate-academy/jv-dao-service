package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver();
        driver.setName("Jack Daniel");
        driver.setLicenseNumber("1234");
        driverService.create(driver);
        driver = driverService.get(1L);
        driver.setLicenseNumber("12345");
        driverService.update(driver);
        driverService.getAll().forEach(System.out::println);
        driverService.delete(1L);
        driverService.getAll().forEach(System.out::println);
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Jeneral Motors");
        manufacturer.setCountry("Ukraine");
        manufacturerService.create(manufacturer);
        manufacturer = manufacturerService.get(4L);
        manufacturer.setCountry("USA");
        manufacturerService.update(manufacturer);
        manufacturerService.getAll().forEach(System.out::println);
        manufacturerService.delete(4L);
        manufacturerService.getAll().forEach(System.out::println);
    }
}
