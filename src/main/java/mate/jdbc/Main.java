package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {

    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final DriverService driverService = (DriverService) injector
            .getInstance(DriverService.class);

    public static void main(String[] args) {
        final Driver driverJohn = new Driver(1L,"John","2034");
        final Driver driverMike = new Driver(1L,"Mike","2035");
        driverService.create(driverJohn);
        driverService.get(1L);
        driverService.getAll().forEach(System.out::println);
        driverService.update(driverMike);
        driverService.delete(1L);

    }
}
