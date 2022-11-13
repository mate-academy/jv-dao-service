package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        System.out.println("All manufacturers:");
        manufacturerService.getAll().stream().forEach(System.out::println);
        Manufacturer newManufacturer = manufacturerService
                .create(new Manufacturer(0L, "Bentley", "England"));
        System.out.println("New manufacturer: " + System.lineSeparator()
                + manufacturerService.get(newManufacturer.getId()));
        Manufacturer updatedManufacturer = manufacturerService
                .update(new Manufacturer(5L, "BMW", "Estonia"));
        System.out.println("Updated manufacturer: " + System.lineSeparator()
                + manufacturerService.get(updatedManufacturer.getId()));
        System.out.println("Deletion: " + manufacturerService.delete(5L));

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        System.out.println("All drivers:");
        driverService.getAll().stream().forEach(System.out::println);
        Driver newDriver = driverService
                .create(new Driver(3L, "Krasnov Mark", "987654"));
        System.out.println("New driver: " + System.lineSeparator()
                + driverService.get(newDriver.getId()));
        Driver updatedDriver = driverService
                .update(new Driver(3L, "Krasnov Alex", "987654"));
        System.out.println("Updated driver: " + System.lineSeparator()
                + driverService.get(updatedDriver.getId()));
        System.out.println("Deletion: " + driverService.delete(3L));
    }
}
