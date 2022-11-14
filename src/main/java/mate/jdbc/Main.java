package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.services.DriverService;
import mate.jdbc.services.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Driver alex = new Driver("Valerchik", "VAlerchik228");
        Driver bob = new Driver("Bob", "Bob914");
        DriverService manegeDriver = (DriverService) injector.getInstance(DriverService.class);
        manegeDriver.create(alex);
        manegeDriver.create(bob);
        System.out.println("List of all drivers:");
        manegeDriver.getAll().forEach(System.out::println);

        Manufacturer corvette = new Manufacturer("Tesla", "USA");
        Manufacturer nissan = new Manufacturer("Nissan", "Japan");
        ManufacturerService factory = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        factory.create(corvette);
        factory.create(nissan);
        System.out.println("List of all cars:");
        factory.getAll().forEach(System.out::println);
        corvette.setCountry("Ukraine");
        corvette.setName("C8");
        factory.update(corvette);
        System.out.println("Find C8: " + factory.get(corvette.getId()));
        System.out.println("Delete C8: " + factory.delete(corvette.getId()));
        System.out.println(System.lineSeparator() + "Info in table manufacturers:");
        factory.getAll().forEach(System.out::println);
        factory.getAll().forEach(car -> factory.delete(car.getId()));

        alex.setName("Alexandr");
        alex.setLicenseNumber("Alexandr1984");
        manegeDriver.update(alex);
        System.out.println("Find Alex " + manegeDriver.get(alex.getId()));
        System.out.println("Delete Alex: " + manegeDriver.delete(alex.getId()));
        System.out.println(System.lineSeparator() + "Info in table drivers:");
        manegeDriver.getAll().forEach(System.out::println);
        manegeDriver.getAll().forEach(d -> manegeDriver.delete(d.getId()));
        System.out.println(System.lineSeparator());
    }
}
