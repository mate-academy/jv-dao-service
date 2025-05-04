package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        Driver bob = new Driver();
        bob.setName("Bob");
        bob.setLicenseNumber("12345");
        Driver bobFromDb = driverService.create(bob);
        System.out.println("Created driver from DB: " + bobFromDb);
        System.out.println("Get Bob driver from DB by ID: " + driverService.get(bob.getId()));
        List<Driver> allDriversFromDB = driverService.getAll();
        System.out.println("All drivers from DB: ");
        allDriversFromDB.forEach(System.out::println);
        bobFromDb.setLicenseNumber("98745");
        Driver updatedBobFromDB = driverService.update(bobFromDb);
        System.out.println("Updated driver from DB: " + updatedBobFromDB);
        System.out.println("Deleted driver by ID from DB: "
                + driverService.delete(updatedBobFromDB.getId()));
    }
}
