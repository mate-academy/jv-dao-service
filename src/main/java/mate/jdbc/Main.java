package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Driver driver1 = new Driver("Bob", "123456");
        Driver driver2 = new Driver("john", "96585");
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        driverService.create(driver1);
        driverService.create(driver2);
        System.out.println(driverService.get(driver1.getId()));
        System.out.println(driverService.get(driver2.getId()));
        System.out.println(driverService.getAll());
        System.out.println(driverService.delete(driver2.getId()));
        System.out.println(driverService.getAll());
    }
}
