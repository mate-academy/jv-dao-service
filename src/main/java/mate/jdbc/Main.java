package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        final ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        Driver driverBob = new Driver("Bob", "1234");
        Driver driverAlice = new Driver("Alice", "1234");
        driverService.create(driverBob);
        driverBob.setName("Billy");
        driverService.update(driverBob);
        driverService.delete(driverBob.getId());
        System.out.println(driverService.getAll());
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("hyundai");
        manufacturer.setCountry("Korea");
        manufacturerService.create(manufacturer);
        manufacturer.setCountry("Germany");
        manufacturerService.update(manufacturer);
        manufacturerService.delete(manufacturer.getId());
        System.out.println(manufacturerService.getAll());
    }
}
