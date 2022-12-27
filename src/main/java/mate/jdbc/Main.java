package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        driverService.getAll().forEach(System.out::println);

        System.out.println(driverService.get(1L));

        driverService.create(new Driver(null, "Alonso", "9999"));

        driverService.delete(2L);
        driverService.update(new Driver(4L, "Alonso", "999"));
    }
}
