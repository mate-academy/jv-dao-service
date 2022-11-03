package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        System.out.println("----- Manufacturer service test -----");
        manufacturerServiceTest();

        System.out.println("\n----- Driver service test -----");
        driverServiceTest();
    }

    private static void manufacturerServiceTest() {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);

        Manufacturer teslaManufacturer = new Manufacturer("Tesla", "USA");
        Manufacturer hondaManufacturer = new Manufacturer("Honda Motor", "Japan");

        manufacturerService.create(teslaManufacturer);
        manufacturerService.create(hondaManufacturer);

        System.out.println("- Get Tesla manufacturer:");
        System.out.println(manufacturerService.get(teslaManufacturer.getId()));

        System.out.println("- Get Honda Motor manufacturer:");
        System.out.println(manufacturerService.get(teslaManufacturer.getId()));

        System.out.println("- Update Honda Motor manufacturer:");
        hondaManufacturer.setName("Honda");
        System.out.println(manufacturerService.update(hondaManufacturer));

        System.out.println("- Get all manufacturers:");
        manufacturerService.getAll().forEach(System.out::println);

        System.out.println("- Get all manufacturers after deleting Tesla:");
        manufacturerService.delete(teslaManufacturer.getId());
        manufacturerService.getAll().forEach(System.out::println);
    }

    private static void driverServiceTest() {
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);

        Driver bobDriver = new Driver("Bob", "1234567890");
        Driver nickDriver = new Driver("Nick", "9876543210");

        driverService.create(bobDriver);
        driverService.create(nickDriver);

        System.out.println("- Get Bob driver:");
        System.out.println(driverService.get(bobDriver.getId()));

        System.out.println("- Get Nick driver:");
        System.out.println(driverService.get(nickDriver.getId()));

        System.out.println("- Update Nick driver:");
        nickDriver.setLicenseNumber("8527419630");
        System.out.println(driverService.update(nickDriver));

        System.out.println("- Get all drivers:");
        driverService.getAll().forEach(System.out::println);

        System.out.println("- Get all drivers after deleting Bob:");
        driverService.delete(bobDriver.getId());
        driverService.getAll().forEach(System.out::println);
    }
}
