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
        firstDriver.setName("name1");
        firstDriver.setLicenseNumber("license1");
        Driver secondDriver = new Driver();
        secondDriver.setName("name2");
        secondDriver.setLicenseNumber("license2");

        driverService.create(firstDriver);
        driverService.create(secondDriver);

        driverService.getAll().forEach(System.out::println);

        System.out.println(driverService.delete(firstDriver.getId()));

        secondDriver.setName("newName");
        driverService.update(secondDriver);

        System.out.println(driverService.get(secondDriver.getId()));

        driverService.getAll().forEach(System.out::println);
    }
}
