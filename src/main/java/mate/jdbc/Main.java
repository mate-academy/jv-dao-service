package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.services.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        final Driver driverIvan = new Driver(1L, "Ivan", "1111");
        final Driver driverDima = new Driver(2L, "Dima", "2222");
        driverService.create(driverDima);
        driverService.create(driverIvan);
        driverService.update(driverDima);
        System.out.println(driverService.get(40L));
        System.out.println(driverService.get(46L));
        driverService.delete(1L);
    }
}
