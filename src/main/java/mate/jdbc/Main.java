package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        Driver bob = new Driver("Bob","123456");
        Driver alice = new Driver("Alice", "654321");
        Manufacturer porsche = new Manufacturer("Porsche", "Italy");
        driverService.create(bob);
        driverService.create(alice);
        manufacturerService.create(porsche);
        System.out.println(driverService.get(1L));
        System.out.println(manufacturerService.get(18L));
        bob.setName("BOB");
        driverService.update(bob);
        porsche.setCountry("ITALY");
        manufacturerService.update(porsche);
        driverService.delete(1L);
        manufacturerService.delete(18L);
        manufacturerService.getAll().forEach(System.out::println);
        driverService.getAll().forEach(System.out::println);
    }
}
