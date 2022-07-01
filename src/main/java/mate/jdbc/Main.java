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
        Manufacturer audi = new Manufacturer("Audi", "German");
        Manufacturer gelly = new Manufacturer("Gelly", "China");
        Manufacturer kia = new Manufacturer("Kia", "Korea");

        manufacturerService.create(audi);
        manufacturerService.create(gelly);
        manufacturerService.create(kia);

        System.out.println(manufacturerService.get(audi.getId()));

        Manufacturer kiaModel2 = new Manufacturer(68L,"Kia", "South Korea");
        manufacturerService.update(kiaModel2);

        manufacturerService.delete(gelly.getId());

        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);
        Driver bob = new Driver("Bob", "AX0001AX");
        Driver alice = new Driver("Alice", "AH5555AH");
        Driver tom = new Driver("Tom", "AA7777AA");
        driverService.create(bob);
        driverService.create(alice);
        driverService.create(tom);

        System.out.println(driverService.get(bob.getId()));

        Driver aliceSister = new Driver(5L, "Alice", "BB3333BB");
        driverService.update(aliceSister);
        driverService.delete(alice.getId());

        driverService.getAll().forEach(System.out::println);
    }
}
