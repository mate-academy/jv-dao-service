package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driveService = (DriverService) injector.getInstance(DriverService.class);
        testDriverService(driveService);
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        testManufacturerService(manufacturerService);
    }

    private static void printAllDrivers(DriverService driveService) {
        System.out.println("All drivers:");
        driveService.getAll().forEach(System.out::println);
    }

    private static void testDriverService(DriverService driveService) {
        printAllDrivers(driveService);
        Driver petro = new Driver("Migel", "68324");
        driveService.create(petro);
        printAllDrivers(driveService);
        Driver driverById = driveService.get(4L);
        System.out.println("Driver with id 4 :" + driverById);
        driverById.setLicenseNumber("123456");
        driveService.update(driverById);
        printAllDrivers(driveService);
        driveService.delete(3L);
        printAllDrivers(driveService);
    }

    private static void printAllManufacturers(ManufacturerService manufacturerService) {
        System.out.println("All manufacturers: ");
        manufacturerService.getAll().forEach(System.out::println);
    }

    private static void testManufacturerService(ManufacturerService manufacturerService) {
        printAllManufacturers(manufacturerService);
        Manufacturer fiat = new Manufacturer("Fiat", "Italy");
        manufacturerService.create(fiat);
        printAllManufacturers(manufacturerService);
        Manufacturer manufacturerById = manufacturerService.get(1L);
        System.out.println("Manufacturer by id 1: " + manufacturerById);
        manufacturerById.setName("Alfa Romeo");
        manufacturerService.update(manufacturerById);
        printAllManufacturers(manufacturerService);
        manufacturerService.delete(2L);
        printAllManufacturers(manufacturerService);
    }
}
