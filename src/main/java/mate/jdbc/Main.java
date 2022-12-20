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
        driverService.create(new Driver(1L,"Aldo", "1234"));
        driverService.create(new Driver(2L,"Aaron", "5678"));
        driverService.create(new Driver(3L,"Aries", "3456"));
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        manufacturerService.create(new Manufacturer(1L,"Audi", "Germany"));
        manufacturerService.create(new Manufacturer(2L,"Volkswagen", "Germany"));
        manufacturerService.create(new Manufacturer(3L,"BMW", "Germany"));

        driverService.delete(1L);
        manufacturerService.delete(2L);

        driverService.getAll().forEach(System.out::println);
        manufacturerService.getAll().forEach(System.out::println);
    }
}
