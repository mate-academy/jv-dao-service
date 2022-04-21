package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        System.out.println(driverService.get(1L));
    }
}
