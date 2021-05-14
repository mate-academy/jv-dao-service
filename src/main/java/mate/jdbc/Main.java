package mate.jdbc;

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
        Manufacturer tesla = new Manufacturer("Tesla", "United States");
        Manufacturer samsung = new Manufacturer("Samsung", "England");
        manufacturerService.create(tesla);
        manufacturerService.create(samsung);
        System.out.println("Initial manufacturers DB: ");
        manufacturerService.getAll().forEach(System.out::println);
        samsung.setCountry("Switzerland");
        manufacturerService.update(samsung);
        System.out.println("Manufacturers DB after updating: ");
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println("Manufacturer by index 1: ");
        System.out.println(manufacturerService.get(1L));
        manufacturerService.delete(1L);
        System.out.println("Manufacturers DB after deleting: ");
        manufacturerService.getAll().forEach(System.out::println);
        DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);
        Driver bob = new Driver("Bob", "AD09093209");
        Driver alice = new Driver("Alice", "LI88372912");
        driverService.create(bob);
        driverService.create(alice);
        System.out.println("Initial drivers DB: ");
        driverService.getAll().forEach(System.out::println);
        alice.setLicenseNumber("PO872719972");
        driverService.update(alice);
        System.out.println("Drivers DB after updating: ");
        driverService.getAll().forEach(System.out::println);
        System.out.println("Driver by index 1: ");
        System.out.println(driverService.get(1L));
        driverService.delete(1L);
        System.out.println("Drivers DB after deleting: ");
        driverService.getAll().forEach(System.out::println);
    }
}
