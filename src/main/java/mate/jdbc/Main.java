package mate.jdbc;

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
        Manufacturer rollsRoyceManufacturer = new Manufacturer("Rolls - Royce", "UK");
        Manufacturer fordManufacturer = new Manufacturer("Ford", "USA");

        manufacturerService.create(rollsRoyceManufacturer);
        manufacturerService.create(fordManufacturer);
        System.out.println(manufacturerService.getAll());
        System.out.println(manufacturerService.get(rollsRoyceManufacturer.getId()));

        rollsRoyceManufacturer.setCountry("China");
        System.out.println(manufacturerService.update(rollsRoyceManufacturer));
        System.out.println(manufacturerService.delete(rollsRoyceManufacturer.getId()));

        Driver bobDriver = new Driver("Bob", "1234");
        Driver aliceDriver = new Driver("Alice", "5678");

        driverService.create(bobDriver);
        driverService.create(aliceDriver);
        System.out.println(driverService.getAll());
        System.out.println(driverService.get(bobDriver.getId()));

        bobDriver.setLicenseNumber("4321");
        System.out.println(driverService.update(bobDriver));
        System.out.println(driverService.delete(bobDriver.getId()));
    }
}
