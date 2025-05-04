package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final long NON_EXISTING_DRIVER_ID = 3L;
    private static final long DRIVER_ID = 4L;

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);
        driverService.getAll().forEach(System.out::println);
        Driver denis = new Driver();
        denis.setName("Denis");
        denis.setLicenseNumber("20114555");
        System.out.println(driverService.create(denis));
        driverService.getAll().forEach(System.out::println);
        denis.setLicenseNumber("20224555");
        System.out.println(driverService.update(denis));
        driverService.getAll().forEach(System.out::println);
        System.out.println(driverService.get(DRIVER_ID));
        System.out.println(driverService.delete(NON_EXISTING_DRIVER_ID));
        driverService.getAll().forEach(System.out::println);
    }
}
