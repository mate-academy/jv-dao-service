package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        final DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);

        Driver firstDriver = new Driver();
        firstDriver.setName("Denys");
        firstDriver.setLicenseNumber("12345");
        Driver secondDriver = new Driver();
        secondDriver.setName("Anton");
        secondDriver.setLicenseNumber("1234567");

        driverService.create(firstDriver);
        driverService.create(secondDriver);

        driverService.getAll().forEach(System.out::println);

        System.out.println(driverService.delete(firstDriver.getId()));

        secondDriver.setName("Antonio");
        driverService.update(secondDriver);

        System.out.println(driverService.get(secondDriver.getId()));

        driverService.getAll().forEach(System.out::println);
    }
}
