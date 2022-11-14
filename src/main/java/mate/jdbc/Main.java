package mate.jdbc;

import java.util.List;
import java.util.stream.Collectors;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        info("Creating drivers result: ");
        List<Driver> driversToCreate = List.of(
                new Driver(null, "Bob", "1d1d1d1d1d1d1d1d"),
                new Driver(null, "John", "2d2d2d2d2d22d2d"));
        List<Driver> createdDrivers = driversToCreate.stream()
                .map(driverService::create)
                .collect(Collectors.toList());
        createdDrivers.forEach(System.out::println);

        info("Getting driver by id result: ");
        System.out.println(driverService.get(createdDrivers.get(0).getId()).toString());

        info("Drivers after update method: ");
        createdDrivers.get(1).setLicenseNumber("3d3d3d3d3d3d");
        driverService.update(createdDrivers.get(1));
        driverService.getAll().forEach(System.out::println);

        info("After deleting driver: ");
        driverService.delete(createdDrivers.get(0).getId());
        driverService.getAll().forEach(System.out::println);

        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        info("Creating manufacturers result: ");
        List<Manufacturer> manufacturersToCreate = List.of(
                new Manufacturer(null, "Audi", "Ukraine"),
                new Manufacturer(null, "Land Roveee", "Ukraine"));
        List<Manufacturer> createdManufacturers = manufacturersToCreate.stream()
                .map(manufacturerService::create)
                .collect(Collectors.toList());
        createdManufacturers.forEach(System.out::println);

        info("Getting manufacturer by id result: ");
        System.out.println(manufacturerService.get(createdManufacturers.get(0).getId()).toString());

        info("Manufacturers after update method: ");
        createdManufacturers.get(1).setName("Land Rover");
        manufacturerService.update(createdManufacturers.get(1));
        manufacturerService.getAll().forEach(System.out::println);

        info("After deleting manufacturer: ");
        manufacturerService.delete(createdManufacturers.get(0).getId());
        manufacturerService.getAll().forEach(System.out::println);

    }

    public static void info(String message) {
        System.out.println(System.lineSeparator() + message);
    }
}
