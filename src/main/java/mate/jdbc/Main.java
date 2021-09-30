package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.sevice.DriverService;
import mate.jdbc.sevice.ManufacturerService;

public class Main {
    public static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Driver driver = new Driver("John", "12345");
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        driverService.delete(3L);
        driverService.getAll().stream()
                .forEach(System.out::println);
        Manufacturer manufacturer = new Manufacturer("Audi", "Germany");
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        manufacturerService.delete(2L);
        manufacturerService.getAll().stream()
                .forEach(System.out::println);

    }
}
