package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driverPishta = new Driver("Pishta", "OT103976");
        Driver driverBob = new Driver("Bob", "ST103942");
        driverService.create(driverBob);
        driverService.create(driverPishta);
        driverBob.setLicenseNumber("PU190953");
        driverService.update(driverBob);
        List<Driver> drivers = driverService.getAll();
        driverService.delete(driverPishta.getId());
    }
}
