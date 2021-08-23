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
        createManufacturers(manufacturerService);

        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        createDrivers(driverService);

        // test another methods of service classes

        // delete
        System.out.println(manufacturerService.delete(15L));
        System.out.println(driverService.delete(3L));

        // get & update
        Driver driver = driverService.get(5L);
        System.out.println(driver);
        if (driver != null) {
            driver.setLicenseNumber("DIP7777");
            System.out.println(driverService.update(driver));
        }

        // get All
        System.out.println("=======================");
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println("=======================");
        driverService.getAll().forEach(System.out::println);
    }

    private static void createManufacturers(ManufacturerService manufacturerService) {
        Manufacturer manufacturerAudi = new Manufacturer();
        manufacturerAudi.setName("Audi");
        manufacturerAudi.setCountry("Germany");
        manufacturerService.create(manufacturerAudi);

        Manufacturer manufacturerPorsche = new Manufacturer();
        manufacturerPorsche.setName("Porsche");
        manufacturerPorsche.setCountry("Germany");
        manufacturerService.create(manufacturerPorsche);

        Manufacturer manufacturerToyota = new Manufacturer();
        manufacturerToyota.setName("Toyota");
        manufacturerToyota.setCountry("Japan");
        manufacturerService.create(manufacturerToyota);

        Manufacturer manufacturerFord = new Manufacturer();
        manufacturerFord.setName("Ford");
        manufacturerFord.setCountry("USA");
        Manufacturer savedManufacturer = manufacturerService.create(manufacturerFord);
        System.out.println(savedManufacturer);
        System.out.println(manufacturerService.delete(savedManufacturer.getId()));
    }

    private static void createDrivers(DriverService driverService) {
        Driver driverJohn = new Driver();
        driverJohn.setName("John Mackenzie");
        driverJohn.setLicenseNumber("LN12345");
        driverService.create(driverJohn);

        Driver driverPitt = new Driver();
        driverPitt.setName("Pitt Brown");
        driverPitt.setLicenseNumber("DK23456");
        driverService.create(driverPitt);

        Driver driverAlice = new Driver();
        driverAlice.setName("Alice Ivanova");
        driverAlice.setLicenseNumber("AL54673");
        Driver savedDriver = driverService.create(driverAlice);
        System.out.println(savedDriver);
        System.out.println(driverService.delete(savedDriver.getId()));
    }
}
