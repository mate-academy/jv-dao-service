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
        manufacturer.setName("car1");
        manufacturer.setCountry("country1");
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        manufacturerService.create(manufacturer);
        Manufacturer manufacturer1 = manufacturerService.get(38L);
        manufacturerService.delete(38L);
        manufacturerService.getAll().forEach(System.out::println);

        Driver driver = new Driver();
        driver.setName("Bob");
        driver.setLicenseNumber("123");
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        driverService.create(driver);
        Driver driver1 = driverService.get(4L);
        driver1.setName("Bill");
        driverService.update(driver1);
        driverService.delete(1L);
        driverService.getAll().forEach(System.out::println);
    }
}
