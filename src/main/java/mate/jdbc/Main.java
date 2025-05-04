package mate.jdbc;

import java.util.ArrayList;
import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector =
            Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        List<Driver> drivers = new ArrayList<>();
        // Driver Bob
        Driver bob = new Driver();
        bob.setName("Bob");
        bob.setLicenseNumber("123");
        drivers.add(bob);
        // Driver Max
        Driver max = new Driver();
        max.setName("Max");
        max.setLicenseNumber("190");
        drivers.add(max);
        // Driver Michael
        Driver michael = new Driver();
        michael.setName("Michael");
        michael.setLicenseNumber("456");
        drivers.add(michael);

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        // Create drivers
        //drivers.forEach(driverService::create); // drivers successfully created

        // Get Max from DB
        max.setId(2L);
        System.out.println(driverService.get(max.getId())); // success

        // Get all drivers from DB
        List<Driver> getAllDrivers = driverService.getAll();
        System.out.println(getAllDrivers); // success

        // Update Bob driver
        bob.setId(1L);
        System.out.println(driverService.get(1L));
        Driver driverToUpdate = new Driver(1L, "Olha", "876");
        driverService.update(driverToUpdate);
        System.out.println(driverService.get(1L)); // success

        // Delete driver and try to get him
        System.out.println(driverService.delete(1L));
        System.out.println(driverService.get(1L)); //success
    }
}
