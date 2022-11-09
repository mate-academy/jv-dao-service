package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Driver driverBob = new Driver(null, "Bob", "1234");
        Driver driverALice = new Driver(1L, "ALice", "5678");
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        //driverService.create(driverBob);
        driverService.get(1L);
        driverService.update(driverALice);
        driverService.getAll();
        driverService.delete(1L);
    }
}
