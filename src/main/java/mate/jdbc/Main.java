package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Driver firstDriver = new Driver();
        firstDriver.setLicenseNumber("first");
        firstDriver.setName("Ivan");

        Driver secondDriver = new Driver();
        secondDriver.setLicenseNumber("second");
        secondDriver.setName("Alex");

        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);

        driverService.create(firstDriver);
        driverService.create(secondDriver);

        driverService.getAll().forEach(System.out::println);

        System.out.println(driverService.delete(1L));

        System.out.println(driverService.get(2L));

        Driver secondDriverNewLicense = driverService.get(2L);
        secondDriverNewLicense.setLicenseNumber("secondUpdated");
        System.out.println(driverService.update(secondDriverNewLicense));
    }
}
