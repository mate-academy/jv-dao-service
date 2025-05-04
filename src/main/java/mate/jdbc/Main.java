package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");
    private static ManufacturerService manufacturerService =
            (ManufacturerService) injector.getInstance(ManufacturerService.class);
    private static DriverService driverService =
            (DriverService) injector.getInstance(DriverService.class);

    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.setId(2L);
        driver.setName("Nelia");
        driver.setLicenseNumber("U499");
        driverService.create(driver);
        System.out.println(driverService.get(2L));
        driverService.getAll().forEach(System.out::println);
        System.out.println(driverService.update(driver));
        System.out.println(driverService.delete(1L));

        manufacturerService.getAll().forEach(System.out::println);
    }
}
