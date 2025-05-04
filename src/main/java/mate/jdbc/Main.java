package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.driver.DriverService;
import mate.jdbc.service.manufacturer.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final DriverService driverService
            = (DriverService) injector.getInstance(DriverService.class);
    public static final ManufacturerService manufacturerService
            = (ManufacturerService) injector.getInstance(ManufacturerService.class);

    public static void main(String[] args) {
        System.out.println(manufacturerService.getAll());
        System.out.println(manufacturerService.get(1L));
        manufacturerService.create(new Manufacturer(null, "Lina", "Ukraine"));
        manufacturerService.update(new Manufacturer(10L, "Lina", "Ukraine"));
        manufacturerService.delete(1L);

        driverService.create(new Driver(null, "Oleksii", "12345"));
        System.out.println(driverService.get(1L));
        System.out.println(driverService.getAll());
        driverService.update(new Driver(1L, "Oleksii", "123456"));
        driverService.delete(1L);
    }
}
