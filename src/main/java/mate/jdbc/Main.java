package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService) injector.getInstance(
                ManufacturerService.class);
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        Manufacturer lamborghini = new Manufacturer("Lamborghini", "Italy");
        Manufacturer ferrari = new Manufacturer("Ferrari", "Italy");
        manufacturerService.create(lamborghini);
        manufacturerService.create(ferrari);
        Driver bob = new Driver("Bob", "232452");
        Driver alice = new Driver("Alice", "2986584");
        driverService.create(bob);
        driverService.create(alice);
        manufacturerService.getAll().forEach(System.out::println);
        driverService.getAll().forEach(System.out::println);

        Manufacturer scoda = new Manufacturer("Scoda", "Hungary");
        Manufacturer zaz = new Manufacturer("Zaz", "Ukraine");
        manufacturerService.create(scoda);
        manufacturerService.create(zaz);
        Driver vasya = new Driver("Vasya", "2423325");
        Driver kingJulian = new Driver("King Julian", "2314324");
        driverService.create(vasya);
        driverService.create(kingJulian);
        manufacturerService.getAll().forEach(System.out::println);
        driverService.getAll().forEach(System.out::println);
        scoda.setCountry("Japan");
        zaz.setCountry("USA");
        vasya.setName("Vasyl");
        kingJulian.setName("KiNG Julian");
        manufacturerService.update(scoda);
        manufacturerService.update(zaz);
        driverService.update(vasya);
        driverService.update(kingJulian);
        manufacturerService.getAll().forEach(System.out::println);
        driverService.getAll().forEach(System.out::println);

        Manufacturer ferrariFromDB = manufacturerService.get(ferrari.getId());
        Driver vasyaFromDB = driverService.get(vasya.getId());
        System.out.println(ferrariFromDB.equals(ferrari));
        System.out.println(vasyaFromDB.equals(vasya));

        manufacturerService.delete(scoda.getId());
        driverService.delete(alice.getId());
        manufacturerService.getAll().forEach(System.out::println);
        driverService.getAll().forEach(System.out::println);
    }
}
