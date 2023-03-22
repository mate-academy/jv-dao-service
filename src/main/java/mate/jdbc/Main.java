package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");
    static final DriverService driverService
            = (DriverService) injector.getInstance(DriverService.class);
    static final ManufacturerService manufacturerService
            = (ManufacturerService) injector.getInstance(ManufacturerService.class);

    public static void main(String[] args) {
        Driver bob = new Driver();
        bob.setName("Bob");
        bob.setLicenseNumber("BOB11111");
        Driver alice = new Driver();
        alice.setName("Alice");
        alice.setLicenseNumber("ALICE22");

        driverService.create(bob);
        driverService.create(alice);
        System.out.println(driverService.getAll());
        alice.setLicenseNumber("ALICE33");
        driverService.update(alice);
        System.out.println(driverService.getAll());
        driverService.delete(bob.getId());
        System.out.println(driverService.getAll());

        Manufacturer manufacturerFromGermany = new Manufacturer();
        manufacturerFromGermany.setName("name_1");
        manufacturerFromGermany.setCountry("Germany");
        manufacturerService.create(manufacturerFromGermany);
        Manufacturer manufacturerFromUkraine = new Manufacturer();
        manufacturerFromUkraine.setName("name_2");
        manufacturerFromUkraine.setCountry("Ukraine");
        manufacturerService.create(manufacturerFromUkraine);
        Manufacturer manufacturerFromItaly = new Manufacturer();
        manufacturerFromItaly.setName("name_3");
        manufacturerFromItaly.setCountry("Italy");
        manufacturerService.create(manufacturerFromItaly);
        // PRINT ALL
        System.out.println(manufacturerService.getAll());
        // PRINT ONE MANUFACTURER
        System.out.println(manufacturerService.get(manufacturerFromGermany.getId()));
        // UPDATE
        manufacturerFromGermany.setCountry("updateCountry");
        manufacturerService.update(manufacturerFromGermany);
        // DELETE
        manufacturerService.delete(manufacturerFromItaly.getId());
        System.out.println(manufacturerService.getAll());
    }
}
