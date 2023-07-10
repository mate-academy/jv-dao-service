package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        for (int i = 1; i < 4; i++) {
            Driver driver = new Driver();
            driver.setName("Driver" + i);
            driver.setLicenseNumber("LicenseNumber #" + i);
            System.out.println("створили: " + driverService.create(driver));
        }
        System.out.println("\n Виводимо всіх водіїв на екран:");
        driverService.getAll().stream()
                .forEach(d -> System.out.println(d));

        System.out.println("\n Видаляємо водія з індексом 2 " + driverService.delete(2L));

        Driver driver = new Driver(3L, "Changed name", "LicenseNumber #3");
        System.out.println("\n Оновили name на \"Changed name\" водія з індексом 3 "
                + driverService.update(driver));

        System.out.println("\n Виводимо всіх водіїв на екран:");
        driverService.getAll().stream()
                .forEach(d -> System.out.println(d));

    }
}
