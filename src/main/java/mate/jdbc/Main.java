package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);

        Manufacturer audi = new Manufacturer("Audi","German");
        Manufacturer hyundai = new Manufacturer("Hyundai","South Korea");
        Manufacturer kia = new Manufacturer("Kia","South Korea");

        manufacturerService.create(audi);
        manufacturerService.create(hyundai);
        manufacturerService.create(kia);

        System.out.println(manufacturerService.get(3L));

        Manufacturer kia2 = new Manufacturer(4L,"Kia","South Korea");
        manufacturerService.update(kia2);

        manufacturerService.delete(5L);

        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);

        Driver bob = new Driver("Bob","AA0956ET");
        Driver alice = new Driver("Alice","KA5530AI");
        Driver john = new Driver("John","AC4406KI");
        driverService.create(bob);
        driverService.create(alice);
        driverService.create(john);

        System.out.println(driverService.get(3L));

        Driver alice2 = new Driver(5L,"Alice","KA5530AI");
        driverService.update(alice2);
        driverService.delete(6L);

        driverService.getAll().forEach(System.out::println);
    }
}
