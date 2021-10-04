package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer("manufacturerTest", "Ukraine");
        System.out.println(manufacturerService.create(manufacturer));
        System.out.println(driverService.create(new Driver("driver1",
                "637cjbck")));
        System.out.println(driverService.create(new Driver("Popov", "gdhfj3467")));
        System.out.println(driverService.delete(2L));
        System.out.println(driverService.get(4L));
        System.out.println(driverService.update(new Driver(4L,
                "Popov-change", "jhjtr75h")));
        driverService.getAll()
                .forEach(System.out::println);
        System.out.println(manufacturerService.create(manufacturer));
        System.out.println(manufacturerService.update(new Manufacturer(9L,
                "manufacturerUpdate", "Ukraine")));
        System.out.println(manufacturerService.get(9L));
        System.out.println(manufacturerService.delete(1L));
        manufacturerService.getAll()
                .forEach(System.out::println);
    }
}
