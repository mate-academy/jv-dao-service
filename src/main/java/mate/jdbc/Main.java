package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        Manufacturer mers = new Manufacturer("Mersedes", "Germany");
        manufacturerService.create(mers);
        manufacturerService.get(mers.getId());
        manufacturerService.getAll().forEach(System.out::println);
        manufacturerService.update(mers);
        manufacturerService.delete(mers.getId());

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver roman = new Driver("Roman", "1234");
        driverService.create(roman);
        driverService.get(roman.getId());
        driverService.getAll().forEach(System.out::println);
        driverService.update(roman);
        driverService.delete(roman.getId());
    }
}
