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
        manufacturerService.create(new Manufacturer(5L, "Opel", "Italia"));
        manufacturerService.update(new Manufacturer(10L, "ZAZ", "Ukraine"));
        System.out.println(manufacturerService.get(11L));
        manufacturerService.delete(11L);
        System.out.println(manufacturerService.getAll());
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        driverService.create(new Driver(4L, "Fred", "1113"));
        driverService.update(new Driver(4L, "Max", "1114"));
        System.out.println(driverService.get(4L));
        driverService.delete(4L);
        System.out.println(driverService.getAll());
    }
}
