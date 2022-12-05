package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector myInject = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        // test your code here
        final DriverService driverService = (DriverService)
                myInject.getInstance(DriverService.class);
        final ManufacturerService manufacturerService = (ManufacturerService)
                myInject.getInstance(ManufacturerService.class);

        manufacturerService.create(new Manufacturer("Opel", "Germany"));
        manufacturerService.create(new Manufacturer("Renault", "France"));
        List<Manufacturer> manufacturers = manufacturerService.getAll();
        manufacturers.forEach(System.out::println);
        manufacturerService.delete(1L);
        manufacturerService.update(new Manufacturer("Nissan", "Japan"));
        System.out.println(manufacturerService.get(1L));
        System.out.println(manufacturerService.get(2L));

        driverService.create(new Driver("Vasil", "2317245"));
        driverService.create(new Driver("Kolya", "6243121"));
        List<Driver> drivers = driverService.getAll();
        drivers.forEach(System.out::println);
        driverService.delete(2L);
        driverService.update(new Driver("Victor", "54654454"));
        System.out.println(driverService.get(1L));
        System.out.println(driverService.get(2L));
    }
}
