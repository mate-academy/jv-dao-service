package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver sam = new Driver("Sam", "999");
        driverService.create(sam);
        Driver ivan = new Driver("ivan", "889");
        driverService.create(ivan);
        System.out.println(driverService.get(3L));
        driverService.delete(ivan.getId());
        driverService.getAll().stream().forEach(System.out::println);
    }
}
