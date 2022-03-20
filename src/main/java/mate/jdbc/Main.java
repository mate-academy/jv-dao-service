package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        System.out.println(manufacturerService.getAll());
        Driver bob = new Driver("bob", "12345");
        Driver alice = new Driver("alice", "56789");
        driverService.create(bob);
        driverService.create(alice);
        System.out.println(driverService.getAll());
        System.out.println(driverService.get(2L));
        bob.setLicenseNumber("258963147");
        System.out.println(driverService.update(bob));
        System.out.println(driverService.getAll());
        System.out.println(driverService.delete(1L));
        System.out.println(driverService.getAll());
    }
}
