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
        Driver alex = new Driver("Alex", "1");
        Driver bob = new Driver("Bob", "2");
        Driver alice = new Driver("Alice", "3");
        alex = driverService.create(alex);
        bob = driverService.create(bob);
        alice = driverService.create(alice);
        driverService.getAll().forEach(System.out::println);
        System.out.println(driverService.get(alex.getId()));
        alex.setLicenseNumber("2");
        driverService.update(alex);
        driverService.getAll().forEach(System.out::println);
        driverService.delete(alice);
        driverService.getAll().forEach(System.out::println);
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        Manufacturer bmv = new Manufacturer("BMW", "Germany");
        Manufacturer mercedes = new Manufacturer("Mercedes", "Germany");
        Manufacturer tesla = new Manufacturer("Tesla", "USA");
        bmv = manufacturerService.create(bmv);
        mercedes = manufacturerService.create(mercedes);
        tesla = manufacturerService.create(tesla);
        manufacturerService.getAll().forEach(System.out::println);
        manufacturerService.delete(mercedes.getId());
        bmv.setName("Opel");
        manufacturerService.update(bmv);
        manufacturerService.get(tesla.getId());
    }
}
