package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        // test your code here
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver(null, "Alex", "1234567");
        driver = driverService.create(driver);
        System.out.println("Created driver: " + driver);
        driver = driverService.get(2L);
        System.out.println("Received driver: " + driver);
        List<Driver> drivers = driverService.getAll();
        drivers.forEach(System.out::println);
        driver = driverService.update(driver);
        System.out.println("Updated driver: " + driver);
        System.out.println("Is deleted driver: " + driver
                + " - " + driverService.delete(driver.getId()));
    }
}
