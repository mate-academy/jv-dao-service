package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        Driver bob = new Driver("Bob","1234");
        driverService.create(bob);

        Driver john = new Driver("John","2345");
        driverService.create(john);

        Driver jack = new Driver("Jack","4567");
        driverService.create(jack);

        driverService.delete(bob.getId());
        System.out.println(driverService.get(john.getId()));

        john.setLicenseNumber("3456");
        driverService.update(john);
        System.out.println(driverService.get(jack.getId()));
        System.out.println(driverService.getAll());
    }
}
