package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);

        manufacturerService.getAll().forEach(System.out::println);

        Manufacturer createdManufacturer =
                manufacturerService.create(new Manufacturer("Ferrari", "Italy"));
        System.out.println("Created manufacturer: " + createdManufacturer);

        Manufacturer receivedManufacturer = manufacturerService.get(6L);
        System.out.println("Received manufacturer: " + receivedManufacturer);

        Manufacturer manufacturerForUpdate = manufacturerService.get(6L);
        manufacturerForUpdate.setName("Honda");
        manufacturerForUpdate.setCountry("Japan");
        Manufacturer updatedManufacturer = manufacturerService.update(manufacturerForUpdate);
        System.out.println("Updated manufacturer: " + updatedManufacturer);

        boolean isDeletedManufacturer = manufacturerService.delete(6L);
        System.out.println("Manufacturer is deleted: " + isDeletedManufacturer);

        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);

        driverService.getAll().forEach(System.out::println);

        Driver createdDriver = driverService.create(new Driver("John", "1212"));
        System.out.println("Created driver: " + createdDriver);

        Driver receivedDriver = driverService.get(2L);
        System.out.println("Received driver: " + receivedDriver);

        Driver driverForUpdate = driverService.get(2L);
        driverForUpdate.setName("Lenny");
        driverForUpdate.setLicenseNumber("2490");
        Driver updatedDriver = driverService.update(driverForUpdate);
        System.out.println("Updated driver: " + updatedDriver);

        boolean isDeletedDriver = driverService.delete(2L);
        System.out.println("Driver is deleted: " + isDeletedDriver);

        driverService.getAll().forEach(System.out::println);
    }
}
