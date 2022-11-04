package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

import java.util.List;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
/*
        //Driver test
        driverService.create(new Driver(11L, "Afanasij", "2150120"));
        driverService.get(3L);
        driverService.delete(5L);
        List<Driver> all = driverService.getAll();
        for (Driver driver: all) {
            System.out.println(driver);
        }
        driverService.update(new Driver(1L, "Anton", "0235987"));


 */
        //Manufacturer test
        manufacturerService.create(new Manufacturer("Tesla", "Germany"));
        manufacturerService.get(1L);
        manufacturerService.delete(5L);
        for (Manufacturer manufacturer : manufacturerService.getAll()) {
            System.out.println(manufacturer);
        }
        manufacturerService.update(new Manufacturer(1L, "Opel", "Germany"));

    }
}
