package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        System.out.println("---------- MANUFACTURER ----------");
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);

        Manufacturer newManufacturer = new Manufacturer();
        newManufacturer.setName("Audi");
        newManufacturer.setCountry("Germany");
        Manufacturer createdManufacturer = manufacturerService.create(newManufacturer);
        System.out.println(".create() manufacturer: " + createdManufacturer
                + System.lineSeparator());

        Long createdManufacturerId = createdManufacturer.getId();
        Manufacturer gotManufacturerFromDb = manufacturerService.get(createdManufacturerId);
        System.out.println(".get() by id: " + gotManufacturerFromDb + System.lineSeparator());

        System.out.println(".getAll() from DB:");
        manufacturerService.getAll().forEach(System.out::println);

        Manufacturer updateManufacturer = new Manufacturer();
        updateManufacturer.setName("Ford");
        updateManufacturer.setCountry("USA");
        updateManufacturer.setId(createdManufacturerId);
        System.out.println(System.lineSeparator() + ".update(): with " + updateManufacturer);
        System.out.println("Old manufacturer: " + gotManufacturerFromDb);
        Manufacturer updatedManufacturer = manufacturerService.update(updateManufacturer);
        System.out.println("Updated manufacturer: " + updatedManufacturer + System.lineSeparator());

        boolean isDeletedManufactorer = manufacturerService.delete(createdManufacturerId);
        System.out.println(".delete(): for " + updatedManufacturer
                + " is " + isDeletedManufactorer + System.lineSeparator());

        System.out.println(".getAll() after .delete() operation: ");
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println(System.lineSeparator());

        System.out.println("---------- DRIVER ----------");
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        Driver newDriver = new Driver();
        newDriver.setName("Howard Hamlin");
        newDriver.setLicenseNumber("331155690");
        Driver createdDriver = driverService.create(newDriver);
        System.out.println(".create() driver: " + createdDriver + System.lineSeparator());

        Long createdDriverId = createdDriver.getId();
        Driver gotDriverFromDb = driverService.get(createdDriverId);
        System.out.println(".get() by id: " + gotDriverFromDb + System.lineSeparator());

        System.out.println(".getAll() from DB:");
        driverService.getAll().forEach(System.out::println);

        Driver updateDriver = new Driver();
        updateDriver.setName("Saul Goodman");
        updateDriver.setLicenseNumber("331155699");
        updateDriver.setId(createdDriverId);
        System.out.println(System.lineSeparator() + ".update(): with " + updateDriver);
        System.out.println("Old driver: " + gotDriverFromDb);
        Driver updatedDriver = driverService.update(updateDriver);
        System.out.println("Updated driver: " + updatedDriver + System.lineSeparator());

        boolean isDeletedDriver = driverService.delete(createdDriverId);
        System.out.println(".delete(): for " + updatedDriver
                + " is " + isDeletedDriver + System.lineSeparator());

        System.out.println(".getAll() after .delete() operation: ");
        driverService.getAll().forEach(System.out::println);
        System.out.println(System.lineSeparator());
    }
}
