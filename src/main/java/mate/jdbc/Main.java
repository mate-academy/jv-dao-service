package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);

        System.out.println(manufacturerService.create(Manufacturer.of("Peugeot", "France")));

        System.out.println(manufacturerService.get(8L));

        manufacturerService.getAll().forEach(System.out::println);

        System.out.println(manufacturerService.update(Manufacturer.of(8L, "Renault", "France")));

        System.out.println(manufacturerService.delete(7L));

        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);

        System.out.println(driverService.create(Driver.of("Sargis Hakobyan", "LKJ909678")));

        System.out.println(driverService.get(2L));

        driverService.getAll().forEach(System.out::println);

        System.out.println(driverService.update(Driver.of(3L, "Gurgen Gevorgyan", "XYU876543")));

        System.out.println(driverService.delete(2L));
    }
}
