package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");
    private static final ManufacturerService manufacturerService =
            (ManufacturerService) injector
                    .getInstance(ManufacturerService.class);
    private static final DriverService driverService =
            (DriverService) injector
                    .getInstance(DriverService.class);

    public static void main(String[] args) {
        Manufacturer audi = manufacturerService
                .create(new Manufacturer("Audi", "Germany"));
        manufacturerService.getAll().forEach(System.out::println);
        audi.setName("BMW");
        System.out.println(manufacturerService.update(audi));
        Driver bob = driverService.create(new Driver("Bob", "12345678"));
        driverService.getAll().forEach(System.out::println);
        bob.setName("John");
        System.out.println(driverService.update(bob));
        driverService.delete(bob.getId());
        manufacturerService.delete(audi.getId());
    }
}
