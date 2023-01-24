package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final DriverService driverService
            = (DriverService) injector.getInstance(DriverService.class);

    public static void main(String[] args) {
        List<Driver> driversList = List.of(
                new Driver("Michael", "SC123456"),
                new Driver("Catherine", "AM654321"),
                new Driver("Janusz", "RP654841")
        );
        driversList.forEach(driver -> {
            driverService.create(driver);
            System.out.println(driver);
        });
        driverService.getAll().forEach(System.out::println);
        System.out.println(driverService.get(driversList.get(1).getId()));
        driversList.get(1).setLicenseNumber("SU132465");
        System.out.println(driverService.update(driversList.get(1)));
        System.out.println(driverService.get(driversList.get(2).getId()));
        System.out.println(driverService.delete(driversList.get(1).getId()));
        driverService.getAll().forEach(System.out::println);
    }
}
