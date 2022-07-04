package mate.jdbc;

import java.util.Random;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);

        Driver driver = new Driver();
        for (int i = 0; i < 10; i++) {
            driver.setName("Bob" + i);
            driver.setLicenseNumber(String.valueOf(new Random().nextInt(1000)));
            driverService.create(driver);
        }
        System.out.println(driverService.get(4L));
        System.out.println(driverService.update(
                new Driver(5L, "Harry", "249238")));
        System.out.println(driverService.delete(6L));
        driverService.getAll().forEach(System.out::println);

        Manufacturer manufacturer = new Manufacturer();
        for (int i = 0; i < 10; i++) {
            manufacturer.setName("Bob" + i);
            manufacturer.setCountry("Country" + i);
            manufacturerService.create(manufacturer);
        }
        System.out.println(manufacturerService.get(4L));
        System.out.println(manufacturerService.update(
                new Manufacturer(5L, "Harry", "249238")));
        System.out.println(manufacturerService.delete(6L));
        manufacturerService.getAll().forEach(System.out::println);
    }
}
