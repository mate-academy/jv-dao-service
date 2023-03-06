package mate.jdbc;

import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;
import mate.jdbc.util.Injector;

public class Main {
    private static final Injector injector =
            Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Driver mike = new Driver("Mike Mouse", "00000000");
        Manufacturer reno = new Manufacturer("Renault", "France");

        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);

        manufacturerService.create(reno);
        driverService.create(mike);

        manufacturerService.delete(1L);
        driverService.delete(1L);

        System.out.println(manufacturerService.get(2L));
        System.out.println(driverService.get(2L));

        System.out.println(manufacturerService.delete(3L));
        System.out.println(driverService.delete(3L));

        System.out.println(manufacturerService.getAll());
        System.out.println(driverService.getAll());
    }
}
