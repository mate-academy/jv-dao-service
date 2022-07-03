package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private final static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        //driverService.create() method check
        driverService.create(new Driver(1L, "Ranjit", "12345"));
        driverService.create(new Driver(2L, "Semen", "23456"));
        driverService.create(new Driver(3L, "Michael", "34567"));

        //driverService.update() method check
        driverService.update(new Driver(1L, "Umesh", "54321"));

        //driverService.delete() method check
        driverService.delete(2L);

        //driverService.get() method check
        System.out.println(driverService.get(2L));
        System.out.println(driverService.get(3L));

        //driverService.getAll() method check
        driverService.getAll().forEach(System.out::println);

        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);

        //manufacturerService.create() method check
        manufacturerService.create(new Manufacturer(1L, "Lincoln", "USA"));
        manufacturerService.create(new Manufacturer(2L, "Ford", "USA"));
        manufacturerService.create(new Manufacturer(3L, "Audi", "Germany"));

        //manufacturerService.update() method check
        manufacturerService.update(new Manufacturer(2L, "Porsche", "Germany"));

        //manufacturerService.delete() method check
        manufacturerService.delete(2L);

        //manufacturerService.get() method check
        System.out.println(manufacturerService.get(2L));
        System.out.println(manufacturerService.get(3L));

        //manufacturerService.getAll() method check
        manufacturerService.getAll().forEach(System.out::println);
    }
}
