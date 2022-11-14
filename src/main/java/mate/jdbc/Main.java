package mate.jdbc;

import java.util.Optional;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {

        System.out.println("Testing manufacturer service:");
        Manufacturer manufacturerVW = new Manufacturer("Volkswagen","Germany");
        Manufacturer manufacturerFiat = new Manufacturer("Fiat","Italy");
        Manufacturer manufacturerToyota = new Manufacturer("Toyota", "Japan");

        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        manufacturerService.create(manufacturerVW);
        manufacturerService.create(manufacturerFiat);
        manufacturerService.create(manufacturerToyota);

        System.out.println("Currently in manufacturers table:");
        System.out.println(manufacturerService.getAll());
        System.out.println();

        Optional<Manufacturer> manufacturerById2 = Optional.ofNullable(manufacturerService.get(2L));
        System.out.println("Manufacturer by id = 2:" + manufacturerById2);
        System.out.println();

        manufacturerVW.setCountry("XXXXXXX");
        manufacturerService.update(manufacturerVW);
        System.out.println("Changed VW manufacturer country" + manufacturerService.get(1L));

        System.out.println("Currently in manufacturers table:");
        System.out.println(manufacturerService.getAll());

        manufacturerService.delete(3L);
        System.out.println("After deleting manufacturer");
        System.out.println("Currently in manufacturers table:");
        System.out.println(manufacturerService.getAll());
        System.out.println();

        System.out.println("Testing driver service:");
        Driver driverBob = new Driver("Bob", "XXXXX");
        Driver driverAlice = new Driver("Alice", "YYYYY");

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        driverService.create(driverBob);
        driverService.create(driverAlice);

        System.out.println("Currently in drivers table:");
        System.out.println(driverService.getAll());
        System.out.println();

        Optional<Driver> driverById1 = Optional.ofNullable(driverService.get(1L));
        System.out.println("Driver by id = 1:" + driverById1);

        driverBob.setName("Bohdan");
        driverService.update(driverBob);
        System.out.println("Changed driverBob name to Bohdan" + driverService.get(1L));

        System.out.println("Currently in drivers table:");
        System.out.println(driverService.getAll());
        System.out.println();

        driverService.delete(2L);
        System.out.println("After deleting driver:");
        System.out.println("Currently in drivers table:");
        System.out.println(driverService.getAll());
        System.out.println();

    }
}
