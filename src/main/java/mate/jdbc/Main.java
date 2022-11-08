package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Driver testDriver = new Driver();
        testDriver.setName("Ivan");
        testDriver.setLicenseNumber("123");
        Driver updateDriver = new Driver();
        updateDriver.setId(1);
        updateDriver.setName("Oleh");
        updateDriver.setLicenseNumber("456");

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        driverService.create(testDriver);
        System.out.println("After create: " + driverService.getAll());

        driverService.get(2L);
        System.out.println(driverService.getAll());

        driverService.update(updateDriver);
        System.out.println("After update: " + driverService.update(updateDriver));

        driverService.delete(1L);
        System.out.println("After delete: " + driverService.getAll());
    }
}
