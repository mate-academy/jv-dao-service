package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector INJECTOR = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) INJECTOR.getInstance(ManufacturerService.class);
        Manufacturer mercedes = new Manufacturer("Mercedes", "Germany");
        Manufacturer bmw = new Manufacturer("BMW", "Germany");
        Manufacturer honda = new Manufacturer("Honda", "Japan");

        manufacturerService.create(mercedes);
        manufacturerService.create(bmw);
        manufacturerService.create(honda);

        System.out.println(manufacturerService.get(1L));
        System.out.println(manufacturerService.get(2L));
        System.out.println(manufacturerService.get(3L));

        manufacturerService.update(new Manufacturer(1L, "MERCEDES", "GERMANY"));

        manufacturerService.delete(3L);

        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService = (DriverService) INJECTOR.getInstance(DriverService.class);
        Driver bob = new Driver("Bob", "1234");
        Driver alice = new Driver("Alice", "3456");
        Driver ivan = new Driver("Ivan", "7890");

        driverService.create(bob);
        driverService.create(alice);
        driverService.create(ivan);

        System.out.println(driverService.get(1L));
        System.out.println(driverService.get(2L));
        System.out.println(driverService.get(3L));

        driverService.update(new Driver(1L, "BoBy", "1234"));

        driverService.delete(3L);

        driverService.getAll().forEach(System.out::println);
    }
}
