package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        final DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver bob = new Driver();
        bob.setName("Bob");
        bob.setLicenceNumber("3968722");
        Driver alice = new Driver();
        alice.setName("Alice");
        alice.setLicenceNumber("4472652");
        Driver john = new Driver();
        john.setName("John");
        john.setLicenceNumber("88833162");
        driverService.create(bob);
        driverService.create(alice);
        driverService.create(john);
        driverService.getAll().forEach(System.out::println);
        final ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer opel = new Manufacturer();
        opel.setName("Opel");
        opel.setCountry("Germany");
        Manufacturer renault = new Manufacturer();
        renault.setName("Renault");
        renault.setCountry("France");
        manufacturerService.create(renault);
        manufacturerService.create(opel);
        manufacturerService.getAll().forEach(System.out::println);
        driverService.get(133L);
    }
}
