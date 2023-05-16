package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    public static void main(String[] args) {
        Injector injector = Injector.getInstance("mate.jdbc");
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        Driver driver1 = new Driver("Ihor", "20473AB");
        Driver driver2 = new Driver("Ivan", "40573VB");
        Driver driver3 = new Driver("Stepan", "34473VB");
        final Driver dbDriver1 = driverService.create(driver1);
        final Driver dbDriver2 = driverService.create(driver2);
        final Driver dbDriver3 = driverService.create(driver3);

        System.out.println("Get all:");
        List<Driver> drivers = driverService.getAll();
        drivers.forEach(System.out::println);
        System.out.println();

        System.out.println("Driver by id 1: ");
        System.out.println(driverService.get(1L));
        System.out.println();

        System.out.println("Updating driver with id 1");
        dbDriver1.setLicenseNumber("0000000");
        driverService.update(dbDriver1);

        System.out.println("Get all after update:");
        List<Driver> driversUpdated = driverService.getAll();
        driversUpdated.forEach(System.out::println);
        System.out.println();

        System.out.println("Deleting driver with id 1");
        driverService.delete(dbDriver1.getId());

        System.out.println("Get all after delete:");
        List<Driver> driversDeleted = driverService.getAll();
        driversDeleted.forEach(System.out::println);

    }
}
