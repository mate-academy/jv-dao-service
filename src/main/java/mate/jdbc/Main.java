package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);

        Manufacturer bmw = new Manufacturer();
        bmw.setName("BMW");
        bmw.setCountry("Germany");
        manufacturerService.create(bmw);
        Manufacturer mustang = new Manufacturer();
        mustang.setName("Mustang");
        mustang.setCountry("USA");
        manufacturerService.create(mustang);
        Manufacturer audi = new Manufacturer();
        audi.setName("Audi");
        audi.setCountry("Germany");
        manufacturerService.create(audi);
        manufacturerService.getAll().forEach(System.out::println);

        mustang.setCountry("Great Britain");
        manufacturerService.update(mustang);
        System.out.println(manufacturerService.get(mustang.getId()));

        manufacturerService.delete(mustang.getId());
        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);

        Driver dima = new Driver();
        dima.setName("Dima");
        dima.setLicenseNumber("12345");
        driverService.create(dima);
        Driver bob = new Driver();
        bob.setName("Bob");
        bob.setLicenseNumber("67890");
        driverService.create(bob);
        Driver alice = new Driver();
        alice.setName("Alice");
        alice.setLicenseNumber("15973");
        driverService.create(alice);
        driverService.getAll().forEach(System.out::println);

        dima.setLicenseNumber("00000");
        driverService.update(dima);
        System.out.println(driverService.get(dima.getId()));

        driverService.delete(bob.getId());
        driverService.getAll().forEach(System.out::println);
    }
}
