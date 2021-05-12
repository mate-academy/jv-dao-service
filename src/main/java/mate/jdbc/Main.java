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
        Driver driverPetr = new Driver("Petr","12345");
        Driver driverBob = new Driver("Bob","23456");
        System.out.println(driverService.create(driverBob));
        System.out.println(driverService.create(driverPetr));
        System.out.println(driverService.get(1L));
        System.out.println(driverService.delete(2L));
        List<Driver> driverList = driverService.getAll();
        driverList.forEach(System.out::println);

        Manufacturer manufacturerBmw = new Manufacturer("BMW", "Germany");
        Manufacturer manufacturerMercedes = new Manufacturer("Mercedes", "Germany");
        System.out.println(manufacturerService.create(manufacturerBmw));
        System.out.println(manufacturerService.create(manufacturerMercedes));
        System.out.println(manufacturerService.get(1L));
        System.out.println(manufacturerService.delete(2L));
        List<Manufacturer> manufacturerList = manufacturerService.getAll();
        manufacturerList.forEach(System.out::println);

    }
}
