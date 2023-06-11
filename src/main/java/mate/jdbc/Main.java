package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        Manufacturer manufacturerToyota = new Manufacturer("Toyota", "Japan");
        Manufacturer manufacturerFord = new Manufacturer("Ford", "United States");
        manufacturerService.create(manufacturerToyota);
        manufacturerService.create(manufacturerFord);
        System.out.println(manufacturerService.get(1L));
        manufacturerService.getAll().forEach(System.out::println);
        Manufacturer manufacturerFerrari = new Manufacturer(1L, "Ferrari", "Italy");
        System.out.println(manufacturerService.update(manufacturerFerrari));
        System.out.println(manufacturerService.delete(2L));

        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);
        Driver driverPetro = new Driver("Petro", "124245");
        Driver driverOleg = new Driver("Oleg", "145356");
        driverService.create(driverOleg);
        driverService.create(driverPetro);
        System.out.println(driverService.get(1L));
        driverService.getAll().forEach(System.out::println);
        Driver driverVitaliy = new Driver(2L, "Vitaliy", "455335");
        System.out.println(driverService.update(driverVitaliy));
        System.out.println(driverService.delete(2L));
    }
}
