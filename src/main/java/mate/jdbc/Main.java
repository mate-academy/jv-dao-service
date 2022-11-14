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
        Driver bob = new Driver(1L, "Bob", "123qwe456rty");
        Driver alice = new Driver(2L, "Alice", "789uio123asd");
        driverService.create(bob);
        driverService.create(alice);
        System.out.println(driverService.get(bob.getId()));
        alice.setLicenseNumber("123asd789uio");
        System.out.println(driverService.get(alice.getId()));
        System.out.println("Driver before update " + driverService.get(alice.getId()));
        driverService.update(alice);
        System.out.println("Driver after update " + driverService.get(alice.getId()));
        System.out.println("Drivers before delete...");
        driverService.getAll().forEach(System.out::println);
        driverService.delete(alice.getId());
        System.out.println("Drivers after delete...");
        driverService.getAll().forEach(System.out::println);
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer audiManufacturer = new Manufacturer("Audi", "Germany");
        Manufacturer ferrariManufacturer = new Manufacturer("ferrari", "Italy");
        manufacturerService.create(audiManufacturer);
        manufacturerService.create(ferrariManufacturer);
        System.out.println(manufacturerService.get(audiManufacturer.getId()));
        ferrariManufacturer.setName("Ferrari");
        manufacturerService.update(ferrariManufacturer);
        System.out.println(manufacturerService.getAll());
        manufacturerService.delete(audiManufacturer.getId());
        System.out.println(manufacturerService.getAll());
    }
}
