package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector
            = Injector.getInstance("mate.jdbc");
    private static List<Driver> driverList;

    public static void main(String[] args) {
        DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);
        deletePreviousDriversInDb(driverService);
        createListOfDrivers(driverService);
        printAllDriversFromDb(driverService);
        updateDriver("7777", "Blatnoy:)",
                driverList.get(1), driverService);
        getDriverById(driverList.get(1).getId(), driverService);
        deleteDriverById(driverList.get(2).getId(), driverService);
        printAllDriversFromDb(driverService);
    }

    private static void deleteDriverById(Long id,
                                         DriverService driverService) {
        System.out.println("Deleting driver with id: " + id);
        System.out.println(driverService.delete(driverList.get(2).getId()));
    }

    private static void getDriverById(Long id,
                                      DriverService driverService) {
        System.out.println("Getting driver with id: " + id);
        System.out.println(driverService.get(driverList.get(1).getId()));
    }

    private static void updateDriver(String licenseNumber,
                                     String name,
                                     Driver driver,
                                     DriverService driverService) {
        System.out.println("Updating driver: " + driver.getName());
        driverList.get(1).setLicenseNumber("7777");
        driverList.get(1).setName(name);
        driverService.update(driver);
    }

    private static void printAllDriversFromDb(DriverService driverService) {
        System.out.println("Printing all drivers...");
        driverService.getAll().forEach(System.out::println);
    }

    private static void deletePreviousDriversInDb(DriverService driverService) {
        System.out.println("Deleting previous drivers in DB");
        driverService.getAll().forEach(driver -> driverService.delete(driver.getId()));
    }

    private static void createListOfDrivers(DriverService driverService) {
        System.out.println("Creating list of new drivers in DB");
        driverList = List.of(
                new Driver(null, "First", "1111"),
                new Driver(null, "Second", "2222"),
                new Driver(null, "Third", "3333")
        );
        driverList.forEach(driverService::create);
    }
}
