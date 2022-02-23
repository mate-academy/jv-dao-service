package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        manufacturerService.create(new Manufacturer("Lambo", "Italy"));
        driverService.create(new Driver("Me", "3228"));
        manufacturerService.update(new Manufacturer(5L, "ZAZ", "Ukraine"));
        driverService.update(new Driver(1L, "notMe", "32281"));
        System.out.println(manufacturerService.get(4L));
        System.out.println(driverService.get(2L));
        manufacturerService.getAll().forEach(System.out::println);
        driverService.getAll().forEach(System.out::println);
    }
}
