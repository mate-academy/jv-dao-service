package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        // test your code here
        Manufacturer manufacturerToyota = new Manufacturer(null, "toyota", "japan");
        Manufacturer manufacturerKia = new Manufacturer(null, "kia", "korea");
        // initialize field values using setters or constructor
        manufacturerService.create(manufacturerToyota);
        manufacturerService.create(manufacturerKia);
        System.out.println(manufacturerService.getAll());

        manufacturerService.delete(2L);
        manufacturerToyota.setCountry("ukraine");
        manufacturerService.update(manufacturerToyota);

        manufacturerService.update(new Manufacturer(null, "mercedes", "germany"));
        System.out.println(manufacturerService.get(2L));
        System.out.println(manufacturerService.get(3L));

        DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);
        Driver driverMickael = new Driver(null, "Mickael", "fdfd-0343");
        Driver driverCalvin = new Driver(null, "Calvin", "fybn-0163");
        driverService.create(driverMickael);
        driverService.create(driverCalvin);
        System.out.println(driverService.getAll());
        driverService.delete(2L);
        driverMickael.setLicenseNumber("popo-0163");
        driverService.update(driverMickael);
        System.out.println(driverService.get(2L));
    }
}
