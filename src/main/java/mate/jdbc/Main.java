package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.sevice.DriverService;
import mate.jdbc.sevice.ManufacturerService;

public class Main {
    public static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Driver driver = new Driver("Jack", "AA12345");
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        driverService.delete(3L);
        driverService.create(driver);
        driverService.getAll().stream()
                .forEach(System.out::println);
        Manufacturer manufacturer = new Manufacturer("WV", "Germany");
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        manufacturerService.create(manufacturer);
        manufacturerService.delete(2L);
        manufacturerService.getAll().stream()
                .forEach(System.out::println);
    }
}
