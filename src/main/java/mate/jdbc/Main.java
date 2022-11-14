package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Driver bob = new Driver("Bob", "12345");
        Driver alice = new Driver("Alice", "67890");
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        driverService.create(bob);
        driverService.create(alice);
        driverService.getAll().forEach(System.out::println);
        bob.setName("BOB");
        driverService.update(bob);
        System.out.println(driverService.get(bob.getId()));
        System.out.println(driverService.delete(bob.getId()));
        driverService.getAll().forEach(System.out::println);
        driverService.getAll().forEach(d -> driverService.delete(d.getId()));
        Manufacturer bmw = new Manufacturer("BMW", "Germany");
        Manufacturer toyota = new Manufacturer("Toyota", "Japan");
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        manufacturerService.create(bmw);
        manufacturerService.create(toyota);
        manufacturerService.getAll().forEach(System.out::println);
        toyota.setName("TOYOTA");
        manufacturerService.update(toyota);
        System.out.println(manufacturerService.get(toyota.getId()));
        System.out.println(manufacturerService.delete(toyota.getId()));
        manufacturerService.getAll().forEach(System.out::println);
    }
}
