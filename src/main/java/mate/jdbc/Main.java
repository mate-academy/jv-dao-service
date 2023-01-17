package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

import java.util.List;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static DriverService driverService;
    static List<Driver> driverList;

    public static void main(String[] args) {
        driverService = (DriverService) injector.getInstance(DriverService.class);
        createListOfDrivers();
        driverList.forEach(driver -> driverService.create(driver));
        System.out.println(driverService.getAll());
        driverList.get(1).setLicenseNumber("7777");
        driverList.get(1).setName("Blatnoy:)");
        driverService.update(driverList.get(1));

    }

    private static void createListOfDrivers() {
        driverList = List.of(
                new Driver(null, "First", "1111"),
                new Driver(null, "Second", "2222"),
                new Driver(null, "Third", "3333")
        );
    }
}
