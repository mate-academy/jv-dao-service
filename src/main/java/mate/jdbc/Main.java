package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver alice = new Driver("Alice", "123456789");
        Driver bob = new Driver("Bob", "987654321");
        Driver john = new Driver("John", "43219875");
        driverService.create(alice);
        driverService.create(bob);
        driverService.create(john);
        System.out.println("===All records after create-block===");
        driverService.getAll().forEach(System.out::println);
        driverService.delete(john.getId());
        driverService.update(new Driver(alice.getId(), "Alice", "111111111"));
        System.out.println("===All records after modified-block===");
        driverService.getAll().forEach(System.out::println);
        System.out.println("===Get`s the first record===");
        System.out.println(driverService.get(alice.getId()));
        System.out.println();
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer audi = new Manufacturer("Audi", "Germany");
        Manufacturer gmc = new Manufacturer("GMC", "USA");
        Manufacturer honda = new Manufacturer("Honda", "Japan");
        manufacturerService.create(audi);
        manufacturerService.create(gmc);
        manufacturerService.create(honda);
        System.out.println("===All records after create-block===");
        manufacturerService.getAll().forEach(System.out::println);
        manufacturerService.delete(gmc.getId());
        manufacturerService.update(new Manufacturer(honda.getId(), "Hyundai", "South Korea"));
        System.out.println("===All records after modified-block===");
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println("===Get`s the first record===");
        System.out.println(manufacturerService.get(audi.getId()));
    }
}
