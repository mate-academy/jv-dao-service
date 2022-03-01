package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    public static void main(String[] args) {
        Injector injector = Injector.getInstance("mate.jdbc");

        final ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer toyota = new Manufacturer(null, "Toyota", "Japan");
        Manufacturer bentley = new Manufacturer(null, "Bentley", "United Kingdom");
        toyota = manufacturerService.create(toyota);
        bentley = manufacturerService.create(bentley);
        System.out.println(manufacturerService.get(2L));
        bentley.setCountry("UK");
        manufacturerService.update(bentley);
        manufacturerService.getAll().forEach(System.out::println);

        System.out.println();

        final DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver bohdan = new Driver(null, "Bohdan", "AA 1234 AA");
        Driver vadym = new Driver(null, "Vadym", "AA 1337 PL");
        bohdan = driverService.create(bohdan);
        vadym = driverService.create(vadym);
        System.out.println(driverService.get(2L));
        vadym.setLicenseNumber("THE BEST CODE");
        driverService.update(vadym);
        driverService.getAll().forEach(System.out::println);
    }
}
