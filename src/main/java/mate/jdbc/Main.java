package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Driver driverJane = new Driver();
        driverJane.setLicenseNumber("000050");
        driverJane.setName("Jane");
        Driver driverBob = new Driver();
        driverBob.setLicenseNumber("000162");
        driverBob.setName("Bob");
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        driverService.create(driverBob);
        driverService.create(driverJane);
        driverService.getAll().forEach(System.out::println);
        System.out.println(driverService.get(driverBob.getId()));
        driverBob.setLicenseNumber("002630");
        driverService.update(driverBob);
        driverService.delete(driverJane.getId());
    }
}
