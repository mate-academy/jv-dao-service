package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        driverService.create(new Driver("Bob", "123"));
        driverService.create(new Driver("Alice", "234"));
        driverService.create(new Driver("John", "345"));
        System.out.println(driverService.getAll());
        System.out.println(driverService.get(2L));
        driverService.update(new Driver(1L,"Paul", "456"));
        System.out.println(driverService.get(1L));
        driverService.delete(3L);
    }
}
