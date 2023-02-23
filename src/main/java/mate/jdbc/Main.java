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
        Manufacturer manufacturer = new Manufacturer(null, "toyota", "japan");
        Manufacturer manufacturer2 = new Manufacturer(null, "kia", "korea");
        // initialize field values using setters or constructor
        manufacturerService.create(manufacturer);
        manufacturerService.create(manufacturer2);
        System.out.println(manufacturerService.getAll());

        manufacturerService.delete(2L);
        manufacturer.setCountry("ukraine");
        manufacturerService.update(manufacturer);

        manufacturerService.update(new Manufacturer(null, "mercedes", "germany"));
        System.out.println(manufacturerService.get(2L));
        System.out.println(manufacturerService.get(3L));

        DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver(null, "Mickael", "fdfd-0343");
        Driver driver2 = new Driver(null, "Calvin", "fybn-0163");
        driverService.create(driver);
        driverService.create(driver2);
        System.out.println(driverService.getAll());
        driverService.delete(2L);
        driver.setLicenseNumber("popo-0163");
        driverService.update(driver);
        System.out.println(driverService.get(2L));
    }
}
