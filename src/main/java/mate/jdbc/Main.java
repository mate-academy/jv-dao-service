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
        Manufacturer manufacturer = new Manufacturer("BMW", "DE");
        System.out.println(manufacturerService.create(manufacturer));
        System.out.println(manufacturerService.get(manufacturer.getId()));
        System.out.println(manufacturerService.update(manufacturer));
        System.out.println(manufacturerService.delete(manufacturer.getId()));
        manufacturerService.getAll().forEach(System.out::println);
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver alisa = new Driver("Alisa", "E23413224");
        System.out.println(driverService.create(alisa));
        System.out.println(driverService.get(alisa.getId()));
        System.out.println(driverService.update(alisa));
        System.out.println(driverService.delete(alisa.getId()));
        driverService.getAll().forEach(System.out::println);
    }
}
