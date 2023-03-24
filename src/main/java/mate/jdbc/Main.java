package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final ManufacturerService manufacturerService =
            (ManufacturerService) injector.getInstance(ManufacturerService.class);
    private static final DriverService driverService =
            (DriverService) injector.getInstance(DriverService.class);

    public static void main(String[] args) {
        List<Manufacturer> manufacturerList =
                List.of(new Manufacturer("ZHIGUNI", "USSR"),
                        new Manufacturer("TOYOTA", "Japane"),
                        new Manufacturer("MERCEDES", "Germany"));
        for (Manufacturer manufacturer : manufacturerList) {
            System.out.println(manufacturerService.create(manufacturer));
        }
        System.out.println(manufacturerService.get(1L));
        System.out.println(manufacturerService.getAll());
        Manufacturer manufacturer = new Manufacturer(1L, "LINKOLN", "USA");
        System.out.println(manufacturerService.update(manufacturer));
        System.out.println(manufacturerService.delete(1L));
        System.out.println(manufacturerService.getAll());

        List<Driver> drivers =
                List.of(new Driver("Andrew", "1"),
                        new Driver("Sasha", "123"),
                        new Driver("Lyosha", "1234"));
        for (Driver driver : drivers) {
            System.out.println(driverService.create(driver));
        }
        System.out.println(driverService.get(1L));
        System.out.println(driverService.getAll());
        Driver driver = new Driver(1L, "Oksana", "5535");
        System.out.println(driverService.update(driver));
        System.out.println(driverService.delete(1L));
        System.out.println(driverService.getAll());
    }
}
