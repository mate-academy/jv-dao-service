package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        final DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);

        Driver driverOne = new Driver();
        driverOne.setId(1L);
        driverOne.setName("DriverOne");
        driverOne.setLicenseNumber("12345");
        driverService.create(driverOne);
        driverService.getAll().forEach(System.out::println);
    }
}
