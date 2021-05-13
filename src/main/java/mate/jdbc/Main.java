package mate.jdbc;

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
        System.out.println(driverService.get(driverBob.getId()));
        System.out.println(driverService.delete(driverPetr.getId()));
        driverBob.setName("Petr Petrovich");
        System.out.println(driverService.update(driverBob));
        System.out.println(driverService.getAll());

        Manufacturer manufacturerBmw = new Manufacturer("BMW", "Germany");
        Manufacturer manufacturerMercedes = new Manufacturer("Mercedes", "Germany");
        Manufacturer manufacturerBugatti = new Manufacturer("Bugatti", "France;");
        System.out.println(manufacturerService.create(manufacturerBmw));
        System.out.println(manufacturerService.create(manufacturerMercedes));
        System.out.println(manufacturerService.create(manufacturerBugatti));
        System.out.println(manufacturerService.get(manufacturerBmw.getId()));
        System.out.println(manufacturerService.delete(manufacturerMercedes.getId()));
        manufacturerBmw.setName("NewBMW");
        System.out.println(manufacturerService.update(manufacturerBmw));
        System.out.println(manufacturerService.getAll());

    }
}
