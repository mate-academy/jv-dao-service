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
        Manufacturer manufacturerNissan = new Manufacturer(null, "Nissan", "Japan");
        Manufacturer manufacturerPorsche = new Manufacturer(null, "Porsche", "Germany");
        manufacturerService.create(manufacturerNissan);
        manufacturerService.create(manufacturerPorsche);
        System.out.println("Added two manufacturers");
        manufacturerService.getAll().forEach(System.out::println);
        manufacturerNissan.setCountry("Ukraine");
        manufacturerService.update(manufacturerNissan);
        System.out.println("Updated audi manufacturer");
        manufacturerService.getAll().forEach(System.out::println);
        manufacturerService.delete(manufacturerPorsche.getId());
        System.out.println("Deleted BMW manufacturer");
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println("Got audi manufacturer");
        System.out.println(manufacturerService.get(manufacturerNissan.getId()));

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver bobDriver = new Driver("Bob","1234567");
        Driver alisaDriver = new Driver("Alisa", "7654321");
        driverService.create(bobDriver);
        driverService.create(alisaDriver);
        driverService.getAll().forEach(System.out::println);
        System.out.println(driverService.get(bobDriver.getId()));
        Driver mikeDriver = new Driver();
        mikeDriver.setId(alisaDriver.getId());
        mikeDriver.setName("Mike");
        mikeDriver.setLicenseNumber("34567");
        driverService.update(mikeDriver);
        driverService.delete(bobDriver.getId());
        driverService.getAll().forEach(System.out::println);
    }
}

