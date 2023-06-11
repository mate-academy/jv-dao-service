package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        System.out.println("Manufacturer Service testing:");
        exampleOfUsageManufacturerService(manufacturerService);

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        System.out.println("\nDriver Service testing:");
        exampleOfUsageDriverService(driverService);
    }

    private static void exampleOfUsageManufacturerService(ManufacturerService manufacturerService) {
        System.out.println("Create:");
        Manufacturer opelManufacturer = new Manufacturer();
        opelManufacturer.setName("Opel");
        opelManufacturer.setCountry("Germany");
        Manufacturer fiatManufacturer = new Manufacturer();
        fiatManufacturer.setName("Fiat");
        fiatManufacturer.setCountry("France");
        System.out.println(manufacturerService.create(opelManufacturer));
        System.out.println(manufacturerService.create(fiatManufacturer));

        System.out.println("Read:");
        System.out.println(manufacturerService.get(fiatManufacturer.getId()));

        System.out.println("Update:");
        fiatManufacturer.setName("Citroen");
        System.out.println(manufacturerService.update(fiatManufacturer));

        System.out.println("Delete:");
        System.out.println(manufacturerService.delete(fiatManufacturer.getId()));

        System.out.println("Get all:");
        List<Manufacturer> manufacturers = manufacturerService.getAll();
        manufacturers.forEach(System.out::println);
    }

    private static void exampleOfUsageDriverService(DriverService driverService) {
        System.out.println("Create:");
        Driver bobDriver = new Driver();
        bobDriver.setName("Bob");
        bobDriver.setLicenseNumber("12345");
        Driver aliceDriver = new Driver();
        aliceDriver.setName("Alice");
        aliceDriver.setLicenseNumber("56789");
        System.out.println(driverService.create(bobDriver));
        System.out.println(driverService.create(aliceDriver));

        System.out.println("Read:");
        System.out.println(driverService.get(aliceDriver.getId()));

        System.out.println("Update:");
        aliceDriver.setLicenseNumber("09876");
        System.out.println(driverService.update(aliceDriver));

        System.out.println("Delete:");
        System.out.println(driverService.delete(aliceDriver.getId()));

        System.out.println("Get all:");
        List<Driver> drivers = driverService.getAll();
        drivers.forEach(System.out::println);
    }
}
