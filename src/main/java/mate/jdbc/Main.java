package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver(1L, "Ivan", "12345");
        driverService.create(driver);
        System.out.println(driverService.get(1L));
        Driver updatedDriver = new Driver(1L, "Pavel", "67890");
        driverService.update(updatedDriver);
        driverService.delete(1L);
        driverService.getAll().forEach(System.out::println);
    }
}
