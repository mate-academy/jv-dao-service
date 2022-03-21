package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = driverService.create(new Driver("Vadim", "PL12345"));
        System.out.println(driverService.get(driver.getId()));
        System.out.println(driverService.getAll());
        driver.setName("Kostya");
        driverService.update(driver);
        System.out.println(driverService.get(driver.getId()));
        driverService.delete(driver.getId());
    }
}
