package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer audi = new Manufacturer();
        audi.setName("Audi A4");
        audi.setCountry("Germany");
        manufacturerService.create(audi);

        Manufacturer honda = new Manufacturer();
        honda.setName("Honda Civic");
        honda.setCountry("Japan");
        manufacturerService.create(honda);

        System.out.println(manufacturerService.get(audi.getId()));
        audi.setName("Audi S5");
        manufacturerService.update(audi);
        manufacturerService.getAll().forEach(System.out::println);
        manufacturerService.delete(honda.getId());
        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver john = new Driver();
        john.setName("John");
        john.setLicenseNumber("AF1325355");
        driverService.create(john);

        Driver bob = new Driver();
        bob.setName("Bob");
        bob.setLicenseNumber("JD6645665");
        driverService.create(bob);

        System.out.println(driverService.get(bob.getId()));
        bob.setLicenseNumber("KL312354");
        driverService.update(bob);
        driverService.getAll().forEach(System.out::println);
        driverService.delete(john.getId());
        driverService.getAll().forEach(System.out::println);
    }
}
