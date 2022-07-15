package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver denys = new Driver("Denys", "123");
        Driver andrew = new Driver("Andrew", "234");
        Driver antony = new Driver("Antony", "345");
        driverService.create(denys);
        driverService.create(andrew);
        driverService.create(antony);
        System.out.println(driverService.get(andrew.getId()));
        denys.setLicenseNumber("23456");
        driverService.update(denys);
        driverService.delete(andrew.getId());
        System.out.println(driverService.getAll());
    }
}
