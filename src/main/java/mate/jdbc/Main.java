package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        Driver driverBob = new Driver("Robert Kennedy", "12345");
        driverService.create(driverBob);
        Driver driverAlice = new Driver("Alice Wonderland", "67890");
        driverService.create(driverAlice);
        driverService.getAll().forEach(System.out::println);

        driverAlice.setName("Alice Kennedy");
        driverService.update(driverAlice);

        Driver driverJohn = new Driver("John Kennedy", "13579");
        driverService.create(driverJohn);
        Driver optionalJohn = driverService.get(driverJohn.getId());
        System.out.println(optionalJohn);

        boolean johnDeleted = driverService.delete(driverJohn.getId());
        System.out.println("John deleted" + johnDeleted);
        driverService.getAll().forEach(System.out::println);

        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturerMersedes = new Manufacturer("Mersedes", "Germany");
        manufacturerService.create(manufacturerMersedes);
        Manufacturer manufacturerLexus = new Manufacturer("Lexus", "Japan");
        manufacturerService.create(manufacturerLexus);
        System.out.println(manufacturerService.delete(manufacturerMersedes.getId()));

        Manufacturer manufacturerTesla = new Manufacturer("Tesla", "USA");
        manufacturerService.create(manufacturerTesla);
        manufacturerTesla.setCountry("USA, California");
        manufacturerService.update(manufacturerTesla);

        Manufacturer getLexus = manufacturerService.get(manufacturerLexus.getId());
        System.out.println(getLexus);

        boolean teslaDeleted = manufacturerService.delete(manufacturerTesla.getId());
        System.out.println("Tesla deleted" + teslaDeleted);
        manufacturerService.getAll().forEach(System.out::println);
    }
}
