package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        manufacturerService.create(new Manufacturer("wrong name", "some country"));
        manufacturerService.create(new Manufacturer("Volkswagen", "German"));
        manufacturerService.create(new Manufacturer("Renault", "France"));
        manufacturerService.create(new Manufacturer("Nissan", "Japan"));
        manufacturerService.create(new Manufacturer("Toyota", "Japan"));
        System.out.println(manufacturerService.delete(3L));
        System.out.println(manufacturerService.get(5L));
        manufacturerService.update(new Manufacturer(1L, "Mitsubishi", "Japan"));
        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);
        driverService.create(new Driver("Ivan", "ln123"));
        driverService.create(new Driver("Petr", "ln234"));
        driverService.create(new Driver("Vasyl", "ln345"));
        driverService.create(new Driver("wrong name", "wrong license"));
        System.out.println(driverService.get(3L));
        driverService.update(new Driver(4L,"Danil","ln789"));
        driverService.delete(1L);
        driverService.getAll().forEach(System.out::println);
    }
}
