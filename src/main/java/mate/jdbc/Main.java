package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        Manufacturer toyota = new Manufacturer();
        toyota.setName("Toyota");
        toyota.setCountry("Japan");
        manufacturerService.create(toyota);
        System.out.println(manufacturerService.get(5L));
        toyota.setName("ToyotaCars");
        manufacturerService.update(toyota);
        System.out.println(manufacturerService.getAll());
        manufacturerService.delete(6L);
        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);
        Driver bobDriver = new Driver();
        bobDriver.setName("Bob");
        bobDriver.setLicenseNumber("12345678");
        driverService.create(bobDriver);
        System.out.println(driverService.get(2L));
        bobDriver.setLicenseNumber("87654321");
        driverService.update(bobDriver);
        System.out.println(driverService.getAll());
        driverService.delete(3L);
    }
}
