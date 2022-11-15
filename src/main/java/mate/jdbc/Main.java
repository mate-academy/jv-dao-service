package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        final DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);

        Driver driver1 = new Driver();
        driver1.setId(1L);
        driver1.setName("Driver1");
        driver1.setLicenseNumber("12345");
        driverService.create(driver1);
        driverService.getAll().forEach(System.out::println);

        driverService.delete(8L);
        driverService.getAll().forEach(System.out::println);
    }
}
