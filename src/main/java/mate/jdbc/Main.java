package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        Driver firstDriver = new Driver();
        firstDriver.setName("Bob");
        firstDriver.setLicenseNumber("777");
        System.out.println(driverService.create(firstDriver));
        driverService.delete(firstDriver.getId());
        driverService.getAll().forEach(System.out::println);
        System.out.println();

        Driver secondDriver = new Driver();
        secondDriver.setName("John");
        secondDriver.setLicenseNumber("99999");
        System.out.println(driverService.create(secondDriver));
        secondDriver.setLicenseNumber("12345");
        driverService.update(secondDriver);
        driverService.getAll().forEach(System.out::println);

        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        manufacturerService.getAll().forEach(System.out::println);

    }
}
