package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final ManufacturerService manufacturerService =
            (ManufacturerService) injector.getInstance(ManufacturerService.class);
    private static final DriverService driverService =
            (DriverService) injector.getInstance(DriverService.class);

    public static void main(String[] args) {
        Driver bob = new Driver("Bob", "N765576");
        Driver john = new Driver("John", "N342243");

        System.out.println(driverService.create(bob));
        System.out.println(driverService.create(john));
        System.out.println(driverService.get(bob.getId()));
        System.out.println(driverService.delete(john.getId()));
        bob.setLicenseNumber("N765576P");
        System.out.println(driverService.update(bob));
        System.out.println(driverService.getAll());

        Manufacturer tesla = new Manufacturer("Tesla", "United States");
        System.out.println(manufacturerService.create(tesla));
        System.out.println(manufacturerService.get(tesla.getId()));
        System.out.println(manufacturerService.update(tesla));
        System.out.println(manufacturerService.getAll());
        System.out.println(manufacturerService.delete(tesla.getId()));
    }
}
