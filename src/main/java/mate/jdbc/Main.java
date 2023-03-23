package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final String DRIVER_NAME = "Bob";
    private static final String DRIVER_LICENSE_NUMBER = "111 111 111";
    private static final String DRIVER_NAME_TO_UPDATE = "Alex";
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver(null, DRIVER_NAME, DRIVER_LICENSE_NUMBER);
        driverService.create(driver);
        System.out.println(driverService.get(1L));
        driverService.getAll().forEach(System.out::println);
        driver.setName(DRIVER_NAME_TO_UPDATE);
        driverService.update(driver);
        driverService.delete(4L);
        driverService.getAll().forEach(System.out::println);
    }
}
