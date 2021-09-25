package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        // test your code here

        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);
        Driver driverBob = new Driver("Bob", "123456");
        System.out.println(driverService.create(driverBob));
        System.out.println(driverService.get(1L));
        List<Driver> driverList = driverService.getAll();
        for (Driver driver:
                driverList) {
            System.out.println(driver);
        }
        Driver driverSteve = new Driver("Steve", "987654");
        driverSteve.setId(1L);
        driverService.update(driverSteve);
        driverService.delete(3L);

        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        Manufacturer manufacturerFord = new Manufacturer("Ford", "USA");
        System.out.println(manufacturerService.create(manufacturerFord));
        System.out.println(manufacturerService.get(1L));
        List<Manufacturer> manufacturerList = manufacturerService.getAll();
        for (Manufacturer item : manufacturerList) {
            System.out.println(item);
        }
        Manufacturer manufacturerLincoln = new Manufacturer(3L,"Lincoln", "USA");
        System.out.println(manufacturerService.update(manufacturerLincoln));

        System.out.println(manufacturerService.delete(1L));

    }
}
