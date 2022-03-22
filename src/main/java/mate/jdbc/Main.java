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
        firstDriver.setName("Jon");
        firstDriver.setLicenseNumber("123");
        driverService.create(firstDriver);
        Driver secondDriver = new Driver("Cris", "654");
        driverService.create(secondDriver);
        secondDriver.setName("Kevin");
        driverService.update(secondDriver);
        driverService.delete(firstDriver.getId());
        driverService.getAll().forEach(System.out::println);
        System.out.println(driverService.get(secondDriver.getId()));
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        manufacturerService.getAll().forEach(System.out::println);

    }
}
