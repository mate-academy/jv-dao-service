package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Driver driverBob = new Driver(null, "Bob", "1234");
        Driver driverALice = new Driver(1L, "ALice", "5678");
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        //driverService.create(driverBob);
        driverService.get(1L);
        driverService.update(driverALice);
        driverService.getAll();
        driverService.delete(1L);
        Manufacturer manufacturerFiat = new Manufacturer(null, "Fiat", "Italy");
        Manufacturer manufacturerBmw = new Manufacturer(2L, "BMW", "Germany");
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        manufacturerService.create(manufacturerFiat);
        manufacturerService.get(2L);
        manufacturerService.update(manufacturerBmw);
        manufacturerService.getAll();
        manufacturerService.delete(2L);
    }
}
