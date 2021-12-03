package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        List<Driver> drivers = List.of(new Driver("Alexander", "QW1234"),
                new Driver("Sam", "AG007"),
                new Driver("Nick", "PRO6R1"));
        for (Driver driver : drivers) {
            driverService.create(driver);
        }
        ManufacturerService manufacturerService = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        List<Manufacturer> manufacturers = List.of(new Manufacturer("Hyundai", "Korea"),
                new Manufacturer("Porsche", "Germany"));
        for (Manufacturer manufacturer : manufacturers) {
            manufacturerService.create(manufacturer);
        }
        System.out.println(driverService.getAll());
        System.out.println(manufacturerService.getAll());
        System.out.println(driverService.get(1L));
        System.out.println(manufacturerService.get(2L));
        Driver alice = driverService.get(1L);
        alice.setName("Alice");
        driverService.update(alice);
        Manufacturer ukraine = manufacturerService.get(2L);
        ukraine.setCountry("Ukraine");
        manufacturerService.update(ukraine);
        System.out.println(driverService.get(1L));
        System.out.println(manufacturerService.get(2L));
        driverService.delete(3L);
        manufacturerService.delete(1L);
        System.out.println(driverService.getAll());
        System.out.println(manufacturerService.getAll());
    }
}
