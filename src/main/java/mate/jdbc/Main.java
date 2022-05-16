package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        // create drivers
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        driverService.create(new Driver(1L, "Alice", "11111178"));
        driverService.create(new Driver(1L, "Tom", "00000078"));
        driverService.create(new Driver(1L, "Anna", "20202020"));
        List<Driver> allDrivers = driverService.getAll();//print all drivers
        allDrivers
                .forEach(System.out::println);
        System.out.println(System.lineSeparator());//update & delete driver
        driverService.update(new Driver(1L, "Maria", "7777777"));
        driverService.delete(2L);
        driverService.getAll().stream().forEach(System.out::println);
        //create manufacturer
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        manufacturerService.create(new Manufacturer(1L, "Nissan", "Japan"));
        manufacturerService.create(new Manufacturer(1L, "Tesla", "USA"));
        manufacturerService.create(new Manufacturer(1L, "Toyota", "Japan"));
        System.out.println(System.lineSeparator());// get all
        List<Manufacturer> allManufacturers = manufacturerService.getAll();
        allManufacturers.stream()
                .forEach(System.out::println);
        //delete & update
        manufacturerService.delete(2L);
        manufacturerService.update(new Manufacturer(1L,
                "Infiniti", "Japan"));
        System.out.println(System.lineSeparator());//print all
        manufacturerService.getAll().forEach(System.out::println);
    }
}

