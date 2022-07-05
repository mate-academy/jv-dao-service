package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Manufacturer ferrari = new Manufacturer("Ferrari", "Italy");
        Manufacturer ford = new Manufacturer("Ford", "USA");
        Manufacturer toyota = new Manufacturer("Toyota", "Germany");
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        manufacturerService.create(ferrari);
        manufacturerService.create(toyota);
        manufacturerService.create(ford);
        System.out.println(manufacturerService.get(ferrari.getId()));
        toyota.setCountry("Japan");
        manufacturerService.update(toyota);
        System.out.println(manufacturerService.delete(ferrari.getId()));
        manufacturerService.getAll().forEach(System.out::println);

        Driver bob = new Driver("Bob", "B13654424");
        Driver alice = new Driver("Alice", "A0002144");
        Driver ted = new Driver("Ted", "G544061739250");
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        driverService.create(bob);
        driverService.create(alice);
        driverService.create(ted);
        System.out.println(driverService.get(bob.getId()));
        ted.setLicenseNumber("A4552135");
        driverService.update(ted);
        System.out.println(driverService.delete(alice.getId()));
        driverService.getAll().forEach(System.out::println);
    }
}
