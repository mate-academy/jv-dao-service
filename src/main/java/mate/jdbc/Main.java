package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.service.DriverService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        // test your code here
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        System.out.println(driverService.get(5L));
    }
}
