package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer toyota = new Manufacturer("Toyota", "Japan");
        Manufacturer lada = new Manufacturer("Lada", "Soviet Union");
        Manufacturer zaz = new Manufacturer("ZAZ", "Ukraine");
        Manufacturer ford = new Manufacturer("Ford", "USA");

        manufacturerService.create(toyota);
        manufacturerService.create(lada);
        manufacturerService.create(zaz);
        manufacturerService.create(ford);

        lada.setCountry("Russia");
        manufacturerService.update(lada);

        manufacturerService.delete(ford.getId());

        manufacturerService.getAll().forEach(System.out::println);
        System.out.println(manufacturerService.get(zaz.getId()));

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver alice = new Driver("Alice", "ALICE2001");
        Driver bob = new Driver("Bob", "BOB1337");

        driverService.create(alice);
        driverService.create(bob);

        alice.setLicenseNumber("ALICE2002");
        driverService.update(alice);

        driverService.getAll().forEach(System.out::println);
        System.out.println(driverService.get(alice.getId()));

        driverService.delete(bob.getId());

        driverService.getAll().forEach(System.out::println);
    }
}
