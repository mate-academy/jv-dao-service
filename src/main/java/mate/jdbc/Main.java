package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        Driver driverJohn = new Driver("John", "123");
        Driver driverLeonard = new Driver("Leonard", "456");
        Driver driverMike = new Driver("Mike", "789");
        Driver driverKate = new Driver(Long.valueOf(2), "Kate", "999");

        driverService.create(driverJohn);
        driverService.create(driverLeonard);
        driverService.create(driverMike);

        driverService.update(driverKate);

        driverService.delete(Long.valueOf(3));

        System.out.println("Driver with id #1 is: " + driverService.get(Long.valueOf(1)));

        driverService.getAll().forEach(System.out::println);
    }
}
