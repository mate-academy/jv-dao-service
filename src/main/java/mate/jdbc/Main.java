package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Manufacturer sony = new Manufacturer("Sony", "Japan");
        Manufacturer asus = new Manufacturer("Asus", "Taiwan");
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);

        System.out.println(manufacturerService.create(sony));
        System.out.println(manufacturerService.create(asus));
        System.out.println(manufacturerService.get(asus.getId()));
        manufacturerService.getAll().forEach(System.out::println);
        sony.setCountry("JPN");
        System.out.println(manufacturerService.update(sony));
        System.out.println(manufacturerService.delete(sony.getId()));

        Driver bob = new Driver("Bob", "AV322");
        Driver mark = new Driver("Mark", "RW015");
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);

        System.out.println(driverService.create(bob));
        System.out.println(driverService.create(mark));
        System.out.println(driverService.get(bob.getId()));
        driverService.getAll().forEach(System.out::println);
        bob.setLicenseNumber("23JFG");
        System.out.println(driverService.update(bob));
        System.out.println(driverService.delete(bob.getId()));
    }
}
