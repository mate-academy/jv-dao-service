package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        final ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        final DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);

        Manufacturer bmw = new Manufacturer("BMW", "Germany");
        Manufacturer toyota = new Manufacturer("Toyota", "Japan");
        Manufacturer renault = new Manufacturer("Renault", "France");

        bmw = manufacturerService.create(bmw);
        toyota = manufacturerService.create(toyota);
        renault = manufacturerService.create(renault);

        toyota.setName("Lexus");
        manufacturerService.update(toyota);
        manufacturerService.delete(bmw.getId());

        System.out.println("===Manufacturers section===");
        System.out.println(manufacturerService.get(renault.getId()));
        System.out.println("===All the manufacturers===");
        manufacturerService.getAll().forEach(System.out::println);

        Driver john = new Driver("John", "1234");
        Driver jack = new Driver("Jack", "2345");
        Driver michael = new Driver("Michael", "7891");

        john = driverService.create(john);
        jack = driverService.create(jack);
        michael = driverService.create(michael);

        john.setName("John Smith");
        driverService.update(john);
        driverService.delete(jack.getId());

        System.out.println("===Drivers section===");
        System.out.println(driverService.get(michael.getId()));
        System.out.println("===All the drivers===");
        driverService.getAll().forEach(System.out::println);
    }
}
