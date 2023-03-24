package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final ManufacturerService manufacturerService =
            (ManufacturerService) injector.getInstance(ManufacturerService.class);
    private static final DriverService driverService =
            (DriverService) injector.getInstance(DriverService.class);

    public static void main(String[] args) {
        System.out.println("MANUFACTURER TESTS");
        manufacturerTests();
        System.out.println("DRIVER TESTS");
        driverTests();
        clearAll();
    }

    private static void manufacturerTests() {
        // Create
        System.out.println("Creating manufacturers...");
        Manufacturer toyotaManufacturer = new Manufacturer("Toyota", "Japan");
        manufacturerService.create(toyotaManufacturer);
        Manufacturer volkswagenManufacturer = new Manufacturer("Volkswagen", "Germany");
        manufacturerService.create(volkswagenManufacturer);
        Manufacturer daimlerManufacturer = new Manufacturer("Diamler", "Germany");
        manufacturerService.create(daimlerManufacturer);
        Manufacturer fordMotorManufacturer = new Manufacturer("Ford Motor", "Untied States");
        manufacturerService.create(fordMotorManufacturer);
        manufacturerService.getAll().stream().forEach(System.out::println);
        // Delete
        System.out.println("Deleting manufacturers...");
        manufacturerService.delete(toyotaManufacturer.getId());
        manufacturerService.delete(volkswagenManufacturer.getId());
        manufacturerService.getAll().stream().forEach(System.out::println);
        // Update
        System.out.println("Updating manufacturers...");
        daimlerManufacturer.setName("Daimler");
        fordMotorManufacturer.setCountry("United States");
        manufacturerService.update(daimlerManufacturer);
        manufacturerService.update(fordMotorManufacturer);
        manufacturerService.getAll().stream().forEach(System.out::println);
    }

    private static void driverTests() {
        // Create
        System.out.println("Creating drivers...");
        Driver driverOne = new Driver("Ivan", "35655");
        driverService.create(driverOne);
        Driver driverTwo = new Driver("Nikolai", "35656");
        driverService.create(driverTwo);
        Driver driverThree = new Driver("Taras", "35657");
        driverService.create(driverThree);
        driverService.getAll().stream().forEach(System.out::println);
        // Delete
        System.out.println("Deleting drivers...");
        driverService.delete(driverOne.getId());
        driverService.getAll().stream().forEach(System.out::println);
        // Update
        driverTwo.setName("Mykola");
        driverService.update(driverTwo);
        System.out.println("Updating drivers...");
        driverService.getAll().stream().forEach(System.out::println);
    }

    private static void clearAll() {
        // Clear after tests
        System.out.println("Clearing...");
        manufacturerService.getAll().stream().forEach(m -> manufacturerService.delete(m.getId()));
        driverService.getAll().stream().forEach(d -> driverService.delete(d.getId()));
    }
}
