package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver driverWilliam = new Driver(null, "William", "307");
        driverWilliam = driverService.create(driverWilliam);
        System.out.println("Added driver William: " + driverService.get(driverWilliam.getId()));
        driverWilliam.setLicenseNumber("308");
        driverWilliam = driverService.update(driverWilliam);
        System.out.println("Updated William license: " + driverService.get(driverWilliam.getId()));
        Driver driverDaniel = new Driver(null, "Daniel", "309");
        driverDaniel = driverService.create(driverDaniel);
        System.out.println("Two drivers from DB: " + driverService.getAll());
        System.out.println("Successful Daniel deleting from DB: "
                + driverService.delete(driverDaniel.getId()));
        System.out.println("Drivers without Daniel: " + driverService.getAll());
    }
}
