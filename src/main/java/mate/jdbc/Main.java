package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver();
        Driver alice = driverService.create(new Driver("Alice", "001984"));
        Driver bob = driverService.create(new Driver("Bob", "112355"));
        Driver joe = driverService.create(new Driver("Joe", "123456"));
        System.out.println(driverService.get(alice.getId()));
        driverService.getAll().forEach(System.out::println);
        System.out.println(driverService.delete(bob.getId()));
        System.out.println(driverService.update(bob));
        System.out.println(driverService.delete(50L));
        System.out.println(driverService.get(50L));
    }
}
