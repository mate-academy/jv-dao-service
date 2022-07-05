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

        Manufacturer bmw = new Manufacturer("BMW", "Germany");
        Manufacturer mustang = new Manufacturer("Mustang", "USA");
        Manufacturer audi = new Manufacturer("Audi", "Germany");

        manufacturerService.create(bmw);
        manufacturerService.create(mustang);
        manufacturerService.create(audi);
        manufacturerService.getAll().forEach(System.out::println);

        mustang.setCountry("Great Britain");
        manufacturerService.update(mustang);
        System.out.println(manufacturerService.get(mustang.getId()));

        manufacturerService.delete(mustang.getId());
        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);

        Driver dima = new Driver("Dima", "12345");
        Driver bob = new Driver("Bob", "67890");
        Driver alice = new Driver("Alice", "15973");

        driverService.create(dima);
        driverService.create(bob);
        driverService.create(alice);
        driverService.getAll().forEach(System.out::println);

        dima.setLicenseNumber("00000");
        driverService.update(dima);
        System.out.println(driverService.get(dima.getId()));

        driverService.delete(bob.getId());
        driverService.getAll().forEach(System.out::println);
    }
}
