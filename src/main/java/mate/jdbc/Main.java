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
        Driver aliseDriver = new Driver(1L, "Alice", "11111178");
        Driver tomDriver = new Driver(1L, "Tom", "00000078");
        Driver annaDriver = new Driver(1L, "Anna", "20202020");
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        driverService.create(aliseDriver);
        driverService.create(tomDriver);
        driverService.create(annaDriver);
        List<Driver> allDrivers = driverService.getAll();//print all drivers
        allDrivers
                .forEach(System.out::println);
        System.out.println(System.lineSeparator());//update & delete driver
        driverService.update(new Driver(aliseDriver.getId(), "Maria", "7777777"));
        driverService.delete(tomDriver.getId());
        driverService.getAll().stream().forEach(System.out::println);
        //create manufacturer
        Manufacturer nissanManufacturer = new Manufacturer(1L, "Nissan", "Japan");
        Manufacturer teslaManufacturer = new Manufacturer(1L, "Tesla", "USA");
        Manufacturer toyotaManufacturer = new Manufacturer(1L, "Toyota", "Japan");
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        manufacturerService.create(nissanManufacturer);
        manufacturerService.create(teslaManufacturer);
        manufacturerService.create(toyotaManufacturer);
        System.out.println(System.lineSeparator());// get all
        List<Manufacturer> allManufacturers = manufacturerService.getAll();
        allManufacturers.stream()
                .forEach(System.out::println);
        //delete & update
        manufacturerService.delete(toyotaManufacturer.getId());
        manufacturerService.update(new Manufacturer(nissanManufacturer.getId(),
                "Infiniti", "Japan"));
        System.out.println(System.lineSeparator());//print all
        manufacturerService.getAll().forEach(System.out::println);
    }
}

