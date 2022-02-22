package mate.jdbc;

import java.util.ArrayList;
import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);

        addingDataToDb(driverService);

        createManufacturerInDb(driverService);

        getManufacturerFromDb(driverService);

        getAllManufacturersFromDb(driverService);

        updateManufacturerInDb(driverService);

        deleteManufacturerById(driverService);
    }

    private static void addingDataToDb(DriverService driverService) {
        Driver driverBob = new Driver();
        driverBob.setName("Bob");
        driverBob.setLicenseNumber("45432");
        Driver driverAlice = new Driver();
        driverAlice.setName("Alice");
        driverAlice.setLicenseNumber("48599");
        Driver driverJohn = new Driver();
        driverJohn.setName("John");
        driverJohn.setLicenseNumber("41211");
        List<Driver> drivers = new ArrayList<>();
        drivers.add(driverBob);
        drivers.add(driverAlice);
        drivers.add(driverJohn);
        for (Driver driver : drivers) {
            driverService.create(driver);
        }
    }

    private static void createManufacturerInDb(DriverService driverService) {
        Driver driver = new Driver();
        driver.setName("Joe");
        driver.setLicenseNumber("17799");
        System.out.println("Created a new driver in DB: "
                + driverService.create(driver));
    }

    private static void getManufacturerFromDb(DriverService driverService) {
        Long driverBobId = 1L;
        System.out.println("Bob driver from DB: "
                + driverService.get(driverBobId));
    }

    private static void getAllManufacturersFromDb(DriverService driverService) {
        List<Driver> drivers = driverService.getAll();
        System.out.println("All manufacturers from DB: ");
        drivers.forEach(System.out::println);
    }

    private static void updateManufacturerInDb(DriverService driverService) {
        Long driverAliveId = 2L;
        Driver newDriverForUpdate =
                new Driver(driverAliveId, "Alice", "11122");
        System.out.println("Updated driver in DB: "
                + driverService.update(newDriverForUpdate));
    }

    private static void deleteManufacturerById(DriverService driverService) {
        Long driverBobId = 1L;
        System.out.println("Deleted driver from DB by ID one: "
                + driverService.delete(driverBobId));
    }
}
