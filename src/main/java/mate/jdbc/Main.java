package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver("Bob", "9999");
        driverService.create(driver);
        System.out.println(driverService.get(driver.getId()));
        driver.setName("Alice");
        driverService.update(driver);
        driverService.getAll().forEach(System.out::println);
        System.out.println(driverService.delete(driver.getId()));
    }
}
