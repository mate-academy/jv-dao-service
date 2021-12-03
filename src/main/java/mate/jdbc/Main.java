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
        Driver firstDriver = new Driver("John", "123");
        driverService.create(firstDriver);
        Driver secondDriver = new Driver("Bob", "456");
        driverService.create(secondDriver);

        System.out.println(driverService.get(2L));
        System.out.println(driverService.getAll());
        firstDriver.setName("Robert");
        driverService.update(firstDriver);
        System.out.println(driverService.get(1L));
        System.out.println(driverService.getAll());
        driverService.delete(2L);
        System.out.println(driverService.getAll());

        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer volkswagen = new Manufacturer("Volkswagen", "Germany");
        manufacturerService.create(volkswagen);
        Manufacturer toyota = new Manufacturer("Toyota", "Japan");
        manufacturerService.create(toyota);

        System.out.println(manufacturerService.get(2L));
        System.out.println(manufacturerService.getAll());
        toyota.setName("toyota");
        manufacturerService.update(toyota);
        System.out.println(manufacturerService.get(2L));
        System.out.println(manufacturerService.getAll());
        manufacturerService.delete(2L);
        System.out.println(manufacturerService.getAll());
    }
}
