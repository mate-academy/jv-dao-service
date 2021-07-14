package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final ManufacturerService manufacturerService = (ManufacturerService) injector
            .getInstance(ManufacturerService.class);
    private static final DriverService driverService = (DriverService) injector
            .getInstance(DriverService.class);

    public static void main(String[] args) {
        System.out.println(manufacturerService.getAll());
        System.out.println(manufacturerService.getAll());
        manufacturerService.delete(2L);
        Manufacturer manufactirer1 = new Manufacturer("Microsoft", "USA");
        manufactirer1.setId(3L);
        manufacturerService.update(manufactirer1);
        System.out.println(manufacturerService.getAll());

    }
}
