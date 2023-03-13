package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer toyota = new Manufacturer("TOYOTA", "Japan");
        Manufacturer bmw = new Manufacturer("BMW", "Germany");
        Manufacturer fiat = new Manufacturer("FIAT", "Italy");
        Manufacturer ford = new Manufacturer("Ford", "USA");
        Manufacturer zaz = new Manufacturer("ZAZ", "Ukraine");
        manufacturerService.create(toyota);
        manufacturerService.create(bmw);
        manufacturerService.create(fiat);
        manufacturerService.create(ford);
        manufacturerService.create(zaz);
        System.out.println("Manufacturers from DB after creating: "
                + manufacturerService.getAll());
        System.out.println("Manufacturer Audi from DB: "
                + manufacturerService.get(toyota.getId()));
        bmw.setId(bmw.getId());
        manufacturerService.update(fiat);
        System.out.println("Manufacturers from DB after updating: "
                + manufacturerService.getAll());
        manufacturerService.delete(ford.getId());
        System.out.println("Manufacturers from DB after deleting: "
                + manufacturerService.getAll());

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver john = new Driver("John", "license1");
        Driver bob = new Driver("Bob", "license2");
        Driver mark = new Driver("Mark", "license3");
        Driver alex = new Driver("Alex", "license4");
        driverService.create(john);
        driverService.create(bob);
        driverService.create(mark);
        driverService.create(alex);
        System.out.println("Drivers from DB after creating: " + driverService.getAll());
        System.out.println("Driver Bob from DB: " + driverService.get(bob.getId()));
        mark.setId(alex.getId());
        driverService.update(bob);
        System.out.println("Drivers from DB after updating: " + driverService.getAll());
        driverService.delete(john.getId());
        System.out.println("Drivers from DB after deleting: " + driverService.getAll());
    }
}
