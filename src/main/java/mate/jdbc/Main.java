package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver("Bob", "12345");
        Driver driver1 = new Driver("Alice", "56789");
        Driver newDriver = driverService.create(driver);
        Driver newDriver1 = driverService.create(driver1);

        driver.setName("John");
        driverService.update(newDriver);

        System.out.println(driverService.get(1L));
        System.out.println(driverService.get(2L));

        driverService.delete(2L);

        driverService.getAll().forEach(System.out::println);
    }
}
