package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.service.driver.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (mate.jdbc.service.driver.DriverService)
                injector.getInstance(DriverService.class);
        driverService.getAll().forEach(System.out::println);
    }
}
