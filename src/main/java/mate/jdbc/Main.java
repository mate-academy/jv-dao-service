package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer lenovo = new Manufacturer("Lenovo", "China");

        System.out.println(manufacturerService.create(lenovo));
        System.out.println(manufacturerService.get(2L));
        lenovo.setCountry("Ukraine");
        System.out.println(manufacturerService.update(lenovo));
        System.out.println(manufacturerService.delete(4L));
        System.out.println(manufacturerService.getAll());

        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver bob = new Driver("Bob", "KX555555");

        System.out.println(driverService.create(bob));
        System.out.println(driverService.get(2L));
        bob.setLicenseNumber("KX777777");
        System.out.println(driverService.update(bob));
        System.out.println(driverService.delete(4L));
        System.out.println(driverService.getAll());
    }
}
