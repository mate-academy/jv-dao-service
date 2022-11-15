package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        System.out.println("ManufacturerService work:");
        testManufacturerServiceWork();
        System.out.println("--------------------");
        System.out.println("DriverService work:");
        testDriverServiceWork();
    }

    private static void testManufacturerServiceWork() {
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        Manufacturer manufacturerDaewoo = new Manufacturer("Daewoo", "South Korea");
        Manufacturer manufacturerNissan = new Manufacturer("Nissan", "Japan");
        Manufacturer createdManufacturerDaewoo = manufacturerService.create(manufacturerDaewoo);
        Manufacturer createdManufacturerNissan = manufacturerService.create(manufacturerNissan);
        System.out.println("Created manufacturers:");
        System.out.println(createdManufacturerDaewoo);
        System.out.println(createdManufacturerNissan);
        System.out.println("Get Daewoo manufacturer:");
        System.out.println(manufacturerService.get(createdManufacturerDaewoo.getId()));
        System.out.println("Get all manufacturers:");
        manufacturerService.getAll().forEach(System.out::println);
        Manufacturer newManufacturerFord = new Manufacturer(createdManufacturerNissan.getId(),
                "Ford", "USA");
        System.out.println("Updated manufacturer:");
        System.out.println(manufacturerService.update(newManufacturerFord));
        if (manufacturerService.delete(createdManufacturerDaewoo.getId())) {
            System.out.println("Daewoo manufacturer was deleted");
        }
    }

    private static void testDriverServiceWork() {
        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);
        Driver driverJohn = new Driver("John", "12345678");
        Driver driverBob = new Driver("Bob", "87654321");
        Driver createdDriverJohn = driverService.create(driverJohn);
        Driver createdDriverBob = driverService.create(driverBob);
        System.out.println("Created drivers:");
        System.out.println(createdDriverJohn);
        System.out.println(createdDriverBob);
        System.out.println("Get driver John:");
        System.out.println(driverService.get(createdDriverJohn.getId()));
        System.out.println("Get all drivers:");
        driverService.getAll().forEach(System.out::println);
        Driver newDriverDen = new Driver(createdDriverBob.getId(), "Den", "15935728");
        System.out.println("Updated driver:");
        System.out.println(driverService.update(newDriverDen));
        if (driverService.delete(createdDriverJohn.getId())) {
            System.out.println("Driver John was deleted");
        }
    }
}
