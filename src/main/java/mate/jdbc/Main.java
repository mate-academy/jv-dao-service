package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        manufacturerService.create(new Manufacturer(15L, "Chevrolet", "USA"));
        manufacturerService.update(new Manufacturer(10L, "Toyota", "japan"));
        System.out.println(manufacturerService.get(5L));
        manufacturerService.delete(3L);
        System.out.println(manufacturerService.getAll());
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        driverService.create(new Driver(1L, "Bob", "AA3422KA"));
        driverService.create(new Driver(2L, "Sem", "AA3442KA"));
        driverService.create(new Driver(3L, "Ivan", "CA2323CI"));
        driverService.update(new Driver(2L, "Max", "CA4444CA"));
        System.out.println(driverService.get(1L));
        driverService.delete(2L);
        System.out.println(driverService.getAll());
    }
}
