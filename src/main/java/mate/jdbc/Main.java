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
        Manufacturer manufacturer = new Manufacturer(0L, "Bentley", "England");
        Manufacturer newManufacturer = manufacturerService.create(manufacturer);
        System.out.println("New manufacturer: " + System.lineSeparator()
                + manufacturerService.get(newManufacturer.getId()));
        Manufacturer manufacturerToUpdate = new Manufacturer(5L, "BMW", "Estonia");
        Manufacturer updatedManufacturer = manufacturerService.update(manufacturerToUpdate);
        System.out.println("Updated manufacturer: " + System.lineSeparator()
                + manufacturerService.get(updatedManufacturer.getId()));
        System.out.println("Deletion: " + manufacturerService.delete(updatedManufacturer.getId()));

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        System.out.println("All drivers:");
        driverService.getAll().stream().forEach(System.out::println);
        Driver driver = new Driver(3L, "Krasnov Mark", "987654");
        Driver newDriver = driverService.create(driver);
        System.out.println("New driver: " + System.lineSeparator()
                + driverService.get(newDriver.getId()));
        Driver driverToUpdete = new Driver(3L, "Krasnov Alex", "987654");
        Driver updatedDriver = driverService.update(driverToUpdete);
        System.out.println("Updated driver: " + System.lineSeparator()
                + driverService.get(updatedDriver.getId()));
        System.out.println("Deletion: " + driverService.delete(driverToUpdete.getId()));
    }
}
