package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufactureService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        Manufacturer bmw = new Manufacturer("BMW", "Germany");
        manufactureService.create(bmw);
        Manufacturer honda = new Manufacturer("Honda", "Japan");
        manufactureService.create(honda);
        Manufacturer ford = new Manufacturer("Ford", "USA");
        manufactureService.create(ford);
        Manufacturer porsche = new Manufacturer("Porsche", "Germany");
        manufactureService.create(porsche);
        System.out.println(manufactureService.getAll());
        System.out.println(manufactureService.get(ford.getId()));
        ford.setName("Mazda");
        ford.setCountry("Japan");
        System.out.println(manufactureService.update(ford));
        System.out.println(manufactureService.delete(bmw.getId()));
        System.out.println("-----------------------------------------------------");
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        Driver bob = new Driver("Bob", "497652");
        driverService.create(bob);
        Driver alice = new Driver("Alice", "845296");
        driverService.create(alice);
        Driver john = new Driver("John", "376028");
        driverService.create(john);
        Driver anna = new Driver("Anna", "589215");
        driverService.create(anna);
        System.out.println(driverService.getAll());
        System.out.println(driverService.get(anna.getId()));
        john.setName("James");
        john.setLicenseNumber("487139");
        System.out.println(driverService.update(john));
        System.out.println(driverService.delete(alice.getId()));
    }
}
