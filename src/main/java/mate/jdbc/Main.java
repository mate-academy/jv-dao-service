package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Manufacturer chevrolet = new Manufacturer("Chevrolet", "USA");
        Manufacturer mercedes = new Manufacturer("Mercedes", "Germany");

        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);

        manufacturerService.create(chevrolet);
        manufacturerService.create(mercedes);

        System.out.println(manufacturerService.get(1L));

        manufacturerService.getAll().forEach(System.out::println);

        chevrolet.setCountry("America");
        manufacturerService.update(chevrolet);

        manufacturerService.delete(1L);

        Driver bob = new Driver("Bob", "1");
        Driver john = new Driver("John", "2");

        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);

        driverService.create(bob);
        driverService.create(john);

        System.out.println(driverService.get(1L));

        driverService.getAll().forEach(System.out::println);

        bob.setLicenseNumber("3");
        driverService.update(bob);

        driverService.delete(1L);
    }
}
