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
        System.out.println(manufacturerService.delete(15L));
        System.out.println(driverService.delete(3L));
        Driver driver = driverService.get(4L);
        System.out.println(driver);
        if (driver != null) {
            driver.setLicenseNumber("777");
            System.out.println(driverService.update(driver));
        }
        System.out.println(System.lineSeparator());
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println(System.lineSeparator());
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
        driverJohn.setName("Ton");
        driverJohn.setLicenseNumber("1111");
        driverService.create(driverJohn);

        Driver driverPitt = new Driver();
        driverPitt.setName("Pieter");
        driverPitt.setLicenseNumber("222");
        driverService.create(driverPitt);

        Driver driverAlice = new Driver();
        driverAlice.setName("Matt");
        driverAlice.setLicenseNumber("333");
        Driver savedDriver = driverService.create(driverAlice);
        System.out.println(savedDriver);
        System.out.println(driverService.delete(savedDriver.getId()));
    }
}
