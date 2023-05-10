package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    public static void main(String[] args) {
        // test your code here
        Injector injector = Injector.getInstance("mate.jdbc");
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        Driver driver1 = new Driver("Bob", "licenseForBob");
        Driver driver2 = new Driver("Tom", "licenseForTom");
        Driver driver1Created = driverService.create(driver1);
        Driver driver2Created = driverService.create(driver2);

        System.out.println("Returned drivers: ");
        System.out.println(driver1Created);
        System.out.println(driver2Created);
        System.out.println();

        System.out.println("Get all:");
        List<Driver> drivers = driverService.getAll();
        drivers.forEach(System.out::println);
        System.out.println();

        System.out.println("Driver by id 2: ");
        System.out.println(driverService.get(2L));
        System.out.println();

        System.out.println("Updating driver with id 2");
        driver2Created.setLicenseNumber("licenseForTomUpdated");
        driverService.update(driver2Created);

        System.out.println("Get all after update:");
        List<Driver> driversUpdated = driverService.getAll();
        driversUpdated.forEach(System.out::println);
        System.out.println();

        System.out.println("Deleting driver with id 1");
        driverService.delete(driver1Created.getId());

        System.out.println("Get all after delete:");
        List<Driver> driversDeleted = driverService.getAll();
        driversDeleted.forEach(System.out::println);
    }
}
