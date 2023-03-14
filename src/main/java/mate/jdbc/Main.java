package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);

        Manufacturer audi = new Manufacturer("Audi", "German");
        Manufacturer ford = new Manufacturer("Ford", "USA");
        Manufacturer toyota = new Manufacturer("Toyota", "Japan");

        manufacturerService.create(audi);
        manufacturerService.create(ford);
        manufacturerService.create(toyota);

        System.out.println(manufacturerService.get(audi.getId()));
        manufacturerService.update(ford);
        manufacturerService.delete(toyota.getId());
        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        Driver bob = new Driver("Bob", "146272");
        Driver john = new Driver("John", "673298");
        Driver alice = new Driver("Alice", "967037");

        driverService.create(bob);
        driverService.create(john);
        driverService.create(alice);

        System.out.println(driverService.get(bob.getId()));
        driverService.update(john);
        driverService.delete(alice.getId());
        driverService.getAll().forEach(System.out::println);
    }
}
