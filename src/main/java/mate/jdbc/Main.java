package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        Driver bob = new Driver("Bob","12345");
        System.out.println("Driver was created: " + driverService.create(bob) + "\n");

        bob.setLicenseNumber("789000");
        System.out.println("Driver was updated to: " + driverService.update(bob) + "\n");

        System.out.println("get driver " + driverService.get(189L) + "\n");

        driverService.getAll().forEach(System.out::println);

        System.out.println("\n" + "Driver was deleted : " + driverService.delete(189L));

    }
}
