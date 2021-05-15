package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Manufacturer bmw = new Manufacturer("BMW", "Germany");
        Manufacturer toyota = new Manufacturer("Toyota", "Japan");
        Manufacturer tesla = new Manufacturer("Tesla", "USA");
        Manufacturer mercedes = new Manufacturer("Mercedes", "Germany");
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);

        System.out.println(manufacturerService.create(bmw));
        System.out.println(manufacturerService.create(toyota));
        System.out.println(manufacturerService.create(tesla));
        System.out.println(manufacturerService.create(mercedes));

        System.out.println(manufacturerService.get(1L));
        System.out.println(manufacturerService.get(2L));

        toyota.setName("Toyota Corolla");
        System.out.println(manufacturerService.update(toyota));

        System.out.println(manufacturerService.delete(3L));

        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        Driver alice = new Driver("Alice", "7700909");
        Driver bob = new Driver("Bob", "67676767");
        Driver boris = new Driver("Boris", "11122233");

        System.out.println(driverService.create(alice));
        System.out.println(driverService.create(bob));
        System.out.println(driverService.create(boris));

        System.out.println(driverService.get(10L));
        System.out.println(driverService.get(11L));
        System.out.println(driverService.get(12L));

        bob.setName("NotBob");
        System.out.println(driverService.update(bob));
        System.out.println(driverService.delete(1L));
        System.out.println(driverService.delete(2L));
        driverService.getAll().forEach(System.out::println);
    }
}
