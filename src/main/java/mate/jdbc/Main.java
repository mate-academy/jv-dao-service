package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        Driver driver = new Driver("Ivan", "598565669");
        driverService.create(driver);
        driver.setName("Bohdan");
        driverService.update(driver);
        System.out.println(driverService.get(driver.getId()));
        driverService.delete(driver.getId());
        driverService.getAll().forEach(System.out::println);
    }
}
