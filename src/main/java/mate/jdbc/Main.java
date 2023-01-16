package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Driver olga = new Driver();
        olga.setName("Olga");
        olga.setLicenseNumber("5678");
        olga.setId(10L);
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        driverService.create(olga);
        System.out.println("Get all drivers from drivers table"
                + driverService.getAll());
        System.out.println("Get driver with id = 5 from drivers table "
                + driverService.get(1L));
        System.out.println("Deleting driver with id = 5 from drivers table"
                + driverService.delete(5L));
        olga.setLicenseNumber("7788");
        driverService.update(olga);
        driverService.getAll().forEach(System.out::println);

        Manufacturer ford = new Manufacturer();
        ford.setName("Ford");
        ford.setCountry("China");
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        manufacturerService.create(ford);
        manufacturerService.delete(12L);
        ford.setCountry("German");
        manufacturerService.update(ford);
        System.out.println("Getting manufacturer with id = 16 "
                + manufacturerService.get(16L));
        manufacturerService.getAll().forEach(System.out::println);
    }
}
