package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        System.out.println(driverService.get(1L));
        driverService.getAll().forEach(System.out::println);
        manufacturerService.getAll().forEach(System.out::println);
    }
}
