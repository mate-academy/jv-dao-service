package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);

        Manufacturer createdManufacturer = new Manufacturer();
        createdManufacturer.setName("Hyundai Motor");
        createdManufacturer.setCountry("South Korea");
        System.out.println("Inserted manufacturer to db: "
                + manufacturerService.create(createdManufacturer));
        System.out.println("Manufacturers in db after inserting: ");
        manufacturerService.getAll().forEach(System.out::println);

        Long manufacturerId = 1L;
        System.out.println("Manufacturer by id=" + manufacturerId
                + ":" + manufacturerService.get(manufacturerId));

        Manufacturer updatedManufacturer = new Manufacturer();
        updatedManufacturer.setId(manufacturerId);
        updatedManufacturer.setName("Stellantis");
        updatedManufacturer.setCountry("Netherlands");
        System.out.println("Updated manufacturer from db: "
                + manufacturerService.update(updatedManufacturer));
        System.out.println("Manufacturers in db after updating: ");
        manufacturerService.getAll().forEach(System.out::println);

        System.out.println("Status of deleting manufacturer by id=" + manufacturerId
                + ":" + manufacturerService.delete(manufacturerId));
        System.out.println("Manufacturers in db after deleting: ");
        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        Driver createdDriver = new Driver();
        createdDriver.setName("Mark Suzko");
        createdDriver.setLicenseNumber("99 302 593");
        System.out.println("Inserted driver to db: " + driverService.create(createdDriver));
        System.out.println("Drivers in db after inserting: ");
        driverService.getAll().forEach(System.out::println);

        Long driverId = 1L;
        System.out.println("Driver by id=" + driverId + ":" + driverService.get(driverId));

        Driver updatedDriver = new Driver();
        updatedDriver.setId(driverId);
        updatedDriver.setName("Petr Novohatsky");
        updatedDriver.setLicenseNumber("33 545 215");
        System.out.println("Updated driver from db: " + driverService.update(updatedDriver));
        System.out.println("Drivers in db after updating: ");
        driverService.getAll().forEach(System.out::println);

        System.out.println("Status of deleting driver by id="
                + driverId + ":" + driverService.delete(driverId));
        System.out.println("Drivers in db after deleting: ");
        driverService.getAll().forEach(System.out::println);
    }
}
