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
        Manufacturer manufacturer = new Manufacturer("Bentley", "England");
        Manufacturer newManufacturer = manufacturerService.create(manufacturer);
        System.out.println("New manufacturer: " + System.lineSeparator()
                + manufacturerService.get(newManufacturer.getId()));
        manufacturer.setCountry("Italy");
        Manufacturer updatedManufacturer = manufacturerService.update(manufacturer);
        System.out.println("Updated manufacturer: " + System.lineSeparator()
                + manufacturerService.get(updatedManufacturer.getId()));
        System.out.println("Deletion: " + manufacturerService.delete(updatedManufacturer.getId()));

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        System.out.println("All drivers:");
        driverService.getAll().stream().forEach(System.out::println);
        Driver driver = new Driver("Krasnov Mark", "987654");
        Driver newDriver = driverService.create(driver);
        System.out.println("New driver: " + System.lineSeparator()
                + driverService.get(newDriver.getId()));
        driver.setName("Krasnov Alex");
        Driver updatedDriver = driverService.update(driver);
        System.out.println("Updated driver: " + System.lineSeparator()
                + driverService.get(updatedDriver.getId()));
        System.out.println("Deletion: " + driverService.delete(updatedDriver.getId()));
    }
}
