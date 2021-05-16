package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        Driver billDriver = new Driver("Bill", "764587");
        Driver bobDriver = new Driver("Bob", "763445");
        Driver aliceDriver = new Driver("Alice", "333668");

        driverService.create(billDriver);
        driverService.create(bobDriver);
        driverService.create(aliceDriver);

        System.out.println(driverService.get(bobDriver.getId()));

        aliceDriver.setLicenseNumber("555555");
        driverService.update(aliceDriver);
        System.out.println(driverService.get(aliceDriver.getId()));

        driverService.delete(billDriver.getId());

        driverService.getAll().stream().forEach(System.out::println);
    }
}
