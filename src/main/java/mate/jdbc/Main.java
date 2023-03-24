package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final ManufacturerService manufacturerService =
            (ManufacturerService) injector.getInstance(ManufacturerService.class);
    private static final DriverService driverService =
            (DriverService) injector.getInstance(DriverService.class);

    public static void main(String[] args) {
        Driver bob = new Driver("Bob","19283735");
        Driver john = new Driver("John", "17342964");
        Driver alice = new Driver("Alice", "18452074");
        driverService.create(bob);
        driverService.create(john);
        driverService.create(alice);
        List<Driver> allDrivers = driverService.getAll();
        allDrivers.forEach(System.out::println);
        System.out.println(driverService.get(alice.getId()));
        john.setName("Bill");
        john.setLicenseNumber("18345285");
        driverService.update(john);
        driverService.delete(bob.getId());

        Manufacturer reno = new Manufacturer("Reno","France");
        Manufacturer toyota = new Manufacturer("Toyota","Japan");
        manufacturerService.create(reno);
        manufacturerService.create(toyota);
        List<Manufacturer> allManufacturers = manufacturerService.getAll();
        allManufacturers.forEach(System.out::println);
        System.out.println(manufacturerService.get(toyota.getId()));
        reno.setName("Mazda");
        reno.setCountry("China");
        manufacturerService.update(reno);
        manufacturerService.delete(toyota.getId());
    }
}
