package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;
import mate.jdbc.service.impl.DriverServiceImpl;
import mate.jdbc.service.impl.ManufacturerServiceImpl;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerServiceImpl manufacturerService =
                (ManufacturerServiceImpl) injector.getInstance(ManufacturerService.class);
        System.out.println(manufacturerService.getAll());
        DriverServiceImpl driverService =
                (DriverServiceImpl) injector.getInstance(DriverService.class);
        System.out.println(driverService.getAll());
    }
}
