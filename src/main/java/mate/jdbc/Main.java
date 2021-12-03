package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        driverService.create(new Driver("Maria", "02_12_21_AI"));
        driverService.create(new Driver("Alice", "06_12_21_KA"));
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
