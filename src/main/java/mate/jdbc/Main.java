package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        System.out.println("Magic STARTS...");

        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        manufacturerService.create(new Manufacturer(null, "Mercedes-Benz", "Germany"));
        manufacturerService.create(new Manufacturer(null, "Lexus", "Belgium"));
        driverService.create(new Driver(null, "Hassan", "AB-272727"));
        driverService.create(new Driver(null, "Mahmud", "AM-486948"));

        Manufacturer manufacturer = manufacturerService.get(1L);
        System.out.println("Get 1st manufacturer from DB: " + manufacturer);
        List<Manufacturer> manufacturers = manufacturerService.getAll();
        System.out.println("Get all manufacturers from DB: " + manufacturers);
        Driver driver = driverService.get(2L);
        System.out.println("Get 2nd driver from DB: " + driver);
        List<Driver> drivers = driverService.getAll();
        System.out.println("Get all drivers from DB: " + drivers);

        manufacturers.get(1).setCountry("Japan");
        manufacturerService.update(manufacturers.get(1));
        drivers.get(0).setName("Abdul");
        driverService.update(drivers.get(0));

        manufacturerService.delete(manufacturers.get(0).getId());
        manufacturers = manufacturerService.getAll();
        System.out.println("Get all manufacturers from DB after updating 2nd one "
                + "and deleting 1st one: " + manufacturers);
        driverService.delete(drivers.get(1).getId());
        drivers = driverService.getAll();
        System.out.println("Get all drivers from DB after updating 1st one "
                + "and deleting 2nd one: " + drivers);

        System.out.println("Magic is over for now. Stay tuned for new episodes ;)");
    }
}
