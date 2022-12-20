package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver(3L, "Kate", "H905");
        driverService.create(driver);
        System.out.println(driverService.get(3L));
        Driver updatedDriver = new Driver(3L, "Simon", "Y458");
        driverService.update(updatedDriver);
        driverService.delete(1L);
        driverService.getAll().forEach(System.out::println);

    }
}
