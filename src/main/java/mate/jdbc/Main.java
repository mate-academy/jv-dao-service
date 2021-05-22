package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Driver bohdan = new Driver("Bohdan", "Chupika228");
        Driver bob = new Driver("Bob", "Alice123");
        DriverService manager = (DriverService) injector.getInstance(DriverService.class);
        manager.create(bohdan);
        manager.create(bob);
        System.out.println("List of all drivers ->");
        manager.getAll().forEach(System.out::println);
        bohdan.setName("Bodya");
        bohdan.setLicenseNumber("Boroda4");
        manager.update(bohdan);
        System.out.println("Find Bohdan " + manager.get(bohdan.getId()));
        System.out.println("Fire Bohdan: " + manager.delete(bohdan.getId()));
        System.out.println(System.lineSeparator() + "Info in table drivers ->");
        manager.getAll().forEach(System.out::println);
        manager.getAll().forEach(d -> manager.delete(d.getId()));
        System.out.println(System.lineSeparator());

        Manufacturer bmw = new Manufacturer("BMW", "Germany");
        Manufacturer ford = new Manufacturer("Ford", "USA");
        ManufacturerService factory = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        factory.create(bmw);
        factory.create(ford);
        System.out.println("List of all cars ->");
        factory.getAll().forEach(System.out::println);
        bmw.setCountry("Ukraine");
        bmw.setName("Mercedes");
        factory.update(bmw);
        System.out.println("Find bmw that now mercedes: " + factory.get(bmw.getId()));
        System.out.println("It`s a crap! We must destroy it! " + factory.delete(bmw.getId()));
        System.out.println(System.lineSeparator() + "Info in table manufacturers ->");
        factory.getAll().forEach(System.out::println);
        factory.getAll().forEach(c -> factory.delete(c.getId()));
    }
}
