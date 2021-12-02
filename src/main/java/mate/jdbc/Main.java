package mate.jdbc;

import java.util.Random;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final int RANDOM_RANGE = 9999;

    public static void main(String[] args) {
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        driverService.create(new Driver("Maria",
                String.valueOf(new Random().nextInt(RANDOM_RANGE))));
        driverService.create(new Driver("Alice",
                String.valueOf(new Random().nextInt(RANDOM_RANGE))));
        Driver updateDriver = new Driver("J.Bond", "007");
        updateDriver.setId(4L);
        System.out.println(driverService.get(4L));
        driverService.update(updateDriver);
        System.out.println(driverService.get(8L));
        driverService.delete(5L);
        driverService.getAll().forEach(System.out::println);
        System.out.println();
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        manufacturerService.create(new Manufacturer("BMW","Germany"));
        manufacturerService.create(new Manufacturer("Audi","Germany"));
        Manufacturer updateManufacturer = new Manufacturer("Tesla","USA");
        updateManufacturer.setId(2L);
        System.out.println(manufacturerService.get(4L));
        manufacturerService.update(updateManufacturer);
        System.out.println(manufacturerService.get(5L));
        manufacturerService.delete(1L);
        manufacturerService.getAll().forEach(System.out::println);
    }
}
