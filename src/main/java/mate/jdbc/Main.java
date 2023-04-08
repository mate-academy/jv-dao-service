package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.service.DriverService;

public class Main {
    public static void main(String[] args) {
        // test your code here
        Injector injector = Injector.getInstance("mate.jdbc");
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        driverService.delete(1L);
        driverService.getAll().forEach(System.out::println);
    }
}
