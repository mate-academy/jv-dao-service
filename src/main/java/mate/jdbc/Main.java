package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        driverService.create(new Driver(1l,"Aldo", "1234"));
        driverService.create(new Driver(2l,"Aaron", "5678"));
        driverService.create(new Driver(3l,"Aries", "3456"));
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        manufacturerService.create(new Manufacturer(1l,"Audi", "Germany"));
        manufacturerService.create(new Manufacturer(2l,"Volkswagen", "Germany"));
        manufacturerService.create(new Manufacturer(3l,"BMW", "Germany"));

        driverService.delete(1L);
        manufacturerService.delete(2L);

        driverService.getAll().forEach(System.out::println);
        manufacturerService.getAll().forEach(System.out::println);
    }
}
