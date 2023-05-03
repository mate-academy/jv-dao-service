package mate.jdbc;

import java.util.ArrayList;
import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        manufacturerList().forEach(manufacturerService::create);
        manufacturerService.update(new Manufacturer(1L,"Ford", "USA"));
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println(manufacturerService.delete(1L));
        System.out.println(manufacturerService.get(2L));

        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        driverList().forEach(driverService::create);
        driverService.update(new Driver(1L,"Kate", "B10"));
        driverService.getAll().forEach(System.out::println);
        System.out.println(driverService.delete(1L));
        System.out.println(driverService.get(5L));
    }

    private static List<Driver> driverList() {
        List<Driver> drivers = new ArrayList<>();
        drivers.add(new Driver("Maxim", "A1"));
        drivers.add(new Driver("Jon", "A2"));
        drivers.add(new Driver("Bob", "A3"));
        drivers.add(new Driver("Karl", "A4"));
        drivers.add(new Driver("Mark", "B1"));
        drivers.add(new Driver("Bill", "B2"));
        drivers.add(new Driver("Eva", "B3"));
        return drivers;
    }

    private static List<Manufacturer> manufacturerList() {
        List<Manufacturer> manufacturers = new ArrayList<>();
        manufacturers.add(new Manufacturer("Fo", "USA"));
        manufacturers.add(new Manufacturer("Chevrolet", "USA"));
        manufacturers.add(new Manufacturer("Porsche", "Germany"));
        manufacturers.add(new Manufacturer("BMW", "Germany"));
        manufacturers.add(new Manufacturer("Subaru", "Japan"));
        manufacturers.add(new Manufacturer("Toyota", "Japan"));
        return manufacturers;
    }
}
