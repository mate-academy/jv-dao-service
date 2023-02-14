package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        Driver driverDmytro = new Driver("Dmytro", "1209354");
        driverService.create(driverDmytro);
        driverService.getAll().forEach(System.out::println);
        System.out.println(driverService.get(2L));
        Driver driverBob = new Driver(2L, "Bob", "7342932");
        driverService.update(driverBob);
        driverService.delete(1L);
        driverService.getAll().forEach(System.out::println);

        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturerFord = new Manufacturer("Ford", "USA");
        manufacturerService.create(manufacturerFord);
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println(manufacturerService.get(2L));
        Manufacturer manufacturerAudi = new Manufacturer(2L,"Audi", "Germany");
        manufacturerService.update(manufacturerAudi);
        manufacturerService.delete(1L);
        manufacturerService.getAll().forEach(System.out::println);
    }
}
