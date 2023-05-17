package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        manufacturerService.getAll().forEach(System.out::println);
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        driverService.getAll().forEach(System.out::println);
        Driver driver = new Driver();
        driver.setName("Alice");
        driver.setLicenseNumber("123545434");
        driver.setId(1L);
        driverService.update(driver);
        driverService.getAll().forEach(System.out::println);
    }
}
