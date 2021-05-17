package mate.jdbc;

import java.util.Objects;
import java.util.Optional;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        Driver driverBob = new Driver();
        driverBob.setName("Robert Kennedy");
        driverBob.setLicenseNumber("12345");
        driverService.create(driverBob);
        Driver driverAlice = new Driver();
        driverAlice.setName("Alice Wonderland");
        driverAlice.setLicenseNumber("67890");
        driverService.create(driverAlice);
        driverService.getAll().forEach(System.out::println);

        driverAlice.setName("Alice Kennedy");
        driverService.update(driverAlice);

        Driver driverJohn = new Driver();
        driverJohn.setName("John Kennedy");
        driverJohn.setLicenseNumber("13579");
        driverService.create(driverJohn);
        Optional<Driver> optionalJohn = driverService.get(driverJohn.getId());
        System.out.println(Objects.equals(optionalJohn.get().getId(),
                driverJohn.getId()));

        boolean johnDeleted = driverService.delete(driverJohn.getId());
        System.out.println("John deleted" + johnDeleted);
        driverService.getAll().forEach(System.out::println);

        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturerMersedes = new Manufacturer();
        manufacturerMersedes.setName("Mersedes");
        manufacturerMersedes.setCountry("Germany");
        manufacturerService.create(manufacturerMersedes);
        Manufacturer manufacturerLexus = new Manufacturer();
        manufacturerMersedes.setName("Lexus");
        manufacturerMersedes.setCountry("Japan");
        manufacturerService.create(manufacturerLexus);
        System.out.println(manufacturerService.delete(manufacturerMersedes.getId()));

        Manufacturer manufacturerTesla = new Manufacturer();
        manufacturerTesla.setName("Tesla");
        manufacturerTesla.setCountry("USA");
        manufacturerService.create(manufacturerTesla);
        manufacturerTesla.setCountry("USA, California");
        manufacturerService.update(manufacturerTesla);

        Optional<Manufacturer> lexusOptional = manufacturerService.get(manufacturerLexus.getId());
        System.out.println(Objects.equals(lexusOptional.get().getId(),
                manufacturerMersedes.getId()));

        boolean teslaDeleted = manufacturerService.delete(manufacturerTesla.getId());
        System.out.println("Tesla deleted" + teslaDeleted);
        manufacturerService.getAll().forEach(System.out::println);
    }
}
