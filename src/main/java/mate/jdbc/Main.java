package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = driverService.create(new Driver("Kostya", "12345"));
        driverService.get(driver.getId());
        driverService.getAll();
        driver.setName("Alice");
        driverService.update(driver);
        driverService.delete(driver.getId());
    }
}
