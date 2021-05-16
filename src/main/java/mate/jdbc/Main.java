package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.DriverServiceImpl;
import mate.jdbc.service.ManufacturerService;
import mate.jdbc.service.ManufacturerServiceImpl;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService =
                (DriverService) injector.getInstance(DriverServiceImpl.class);
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerServiceImpl.class);

        manufacturerService.getAll().forEach(System.out::println);
    }
}
