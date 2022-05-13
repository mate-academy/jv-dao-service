package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.services.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        // test your code here
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver sashko = new Driver(1L, "Alex", "12345");
        Driver viktor = new Driver(2L, "Viktor", "21345");
        driverService.create(sashko);
        driverService.create(viktor);
        System.out.println(driverService.get(viktor.getId()));
        sashko.setLicenseNumber("9999");
        driverService.update(sashko);
        driverService.delete(viktor.getId());
        System.out.println(driverService.getAll());
    }
}
