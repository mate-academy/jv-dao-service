package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");
    private static ManufacturerService manufacturerService
            = (ManufacturerService) injector.getInstance(ManufacturerService.class);
    private static DriverService driverService
            = (DriverService) injector.getInstance(DriverService.class);

    public static void main(String[] args) {
        Manufacturer manufacturerToyota = new Manufacturer("Toyota", "Japan");
        Manufacturer manufacturerLexus = new Manufacturer(1L, "Lexus", "Japan");
        manufacturerService.create(manufacturerToyota);
        System.out.println(manufacturerService.get(1L));
        manufacturerService.update(manufacturerLexus);
        manufacturerService.delete(1L);
        System.out.println(manufacturerService.getAll());
        Driver driverPetro = new Driver("Petro", "545454");
        Driver driverDmytro = new Driver(1L, "Dmytro", "545454");
        driverService.create(driverPetro);
        System.out.println(driverService.get(1L));
        driverService.update(driverDmytro);
        driverService.delete(1L);
        System.out.println(driverService.getAll());
    }
}
