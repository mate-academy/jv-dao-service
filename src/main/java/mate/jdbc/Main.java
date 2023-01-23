package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        Driver driverBob = new Driver();
        driverBob.setName("Bob");
        driverBob.setLicenseNumber("1234");
        System.out.println(driverService.create(driverBob));
        Driver driverAlice = new Driver();
        driverAlice.setName("Alice");
        driverAlice.setLicenseNumber("5678");
        System.out.println(driverService.create(driverAlice));
        System.out.println(driverService.get(driverBob.getId()));
        driverBob.setName("Steve");
        driverBob.setLicenseNumber("7777");
        System.out.println(driverService.update(driverBob));
        System.out.println(driverService.delete(driverBob.getId()));
        driverService.getAll().forEach(System.out::println);
    }
}
