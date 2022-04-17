package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver alex = new Driver(1L, "Alex", "123456");
        Driver igor = new Driver(2L, "Igor", "654321");
        driverService.create(alex);
        driverService.create(igor);
        System.out.println(driverService.get(2L));
        driverService.getAll().forEach(System.out::println);
        driverService.delete(1L);
    }
}
