package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Driver driver1 = new Driver(null, "John", "J182");
        Driver driver2 = new Driver(null, "Bob", "b123");
        DriverService manager = (DriverService) injector.getInstance(DriverService.class);
        manager.create(driver1);
        manager.create(driver2);
        System.out.println("List of all drivers:");
        manager.getAll().forEach(System.out::println);
    }
}
