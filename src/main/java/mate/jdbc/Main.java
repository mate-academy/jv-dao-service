package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driverBob = new Driver("Bob", "9379992");
        driverBob = driverService.create(driverBob);
        System.out.println(driverService.get(3L));
        System.out.println(driverService.getAll());

        driverBob.setLicenseNumber("87634");
        System.out.println(driverService.update(driverBob));
        System.out.println(driverService.delete(1L));

        Manufacturer manufacturerFirst = new Manufacturer();
        manufacturerFirst.setName("Jessica");
        manufacturerFirst.setCountry("Guatemala");

        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        manufacturerFirst = manufacturerService.create(manufacturerFirst);
        System.out.println(manufacturerService.get(4L));
        System.out.println(manufacturerService.getAll());

        manufacturerFirst.setName("newName");
        manufacturerFirst.setCountry("newCountry");
        System.out.println(manufacturerService.update(manufacturerFirst));

        manufacturerService.delete(6L);
        System.out.println(manufacturerService);
    }
}
