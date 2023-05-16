package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);

        Manufacturer volkswagen = new Manufacturer(1L, "volkswagen group", "Germany");

        manufacturerService.create(volkswagen);
        manufacturerService.update(volkswagen);
        manufacturerService.delete(2L);
        System.out.println(manufacturerService.get(1L));
        System.out.println(manufacturerService.getAll());

        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);

        Driver bob = new Driver(1L, "Bob", "01225");

        driverService.create(bob);
        driverService.update(bob);
        driverService.delete(2L);
        System.out.println(driverService.get(1L));
        System.out.println(driverService.getAll());
    }
}
