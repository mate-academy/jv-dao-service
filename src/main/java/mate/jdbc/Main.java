package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static Injector injector = Injector.getInstance("mate");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        driverService.deleteAll();
        Driver bob = driverService.create(new Driver("bob", "license"));
        Driver john = driverService.create(new Driver("john", "license"));
        System.out.println(bob);
        System.out.println(john);
        System.out.println(driverService.get(bob.getId()));
        john.setLicense("super license");
        System.out.println(driverService.update(john));
        System.out.println(driverService.getAll());
        System.out.println(driverService.delete(john.getId()));
        System.out.println(driverService.delete(bob.getId()));
        System.out.println(driverService.getAll());
    }
}
