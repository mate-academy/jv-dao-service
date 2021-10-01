package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        // test your code here
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = Driver.builder()
                .name("Bob")
                .licenseNumber("3856")
                .build();
        driver = driverService.create(driver);
        driver = driverService.get(driver.getId());
        driver.setName("Alice");
        driver = driverService.update(driver);
        driverService.delete(driver.getId());
        Driver driverTom = Driver.builder()
                .name("Tom")
                .licenseNumber("3856")
                .build();
        driverService.create(driverTom);
        driverService.create(driverTom);
        driverService.getAll().forEach(System.out::println);
    }
}
