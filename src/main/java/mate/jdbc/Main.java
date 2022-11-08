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
        firstDriver.setName("Tom");
        firstDriver.setLicenseNumber("12358F13G21");
        Driver secondDriver = new Driver();
        secondDriver.setName("Jack");
        secondDriver.setLicenseNumber("34G21F85321");
        driverService.create(firstDriver);
        driverService.create(secondDriver);
        driverService.getAll().forEach(System.out::println);
        System.out.println(driverService.delete(firstDriver.getId()));
        secondDriver.setName("Stephen");
        secondDriver.setLicenseNumber("55A34G12358");
        driverService.update(secondDriver);
        System.out.println(driverService.get(secondDriver.getId()));
        driverService.getAll().forEach(System.out::println);
        Long deleteId = Long.valueOf(1);
        driverService.delete(deleteId);
        driverService.getAll().forEach(System.out::println);
    }
}
