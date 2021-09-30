package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService)injector
                    .getInstance(ManufacturerService.class);
        DriverService driverService = (DriverService)injector
                    .getInstance(DriverService.class);
        System.out.println(manufacturerService.getAll().toString());
        Driver poul = new Driver("Poul", "AA 1234");
        Driver bob = new Driver("Robert", "WW 9876");
        driverService.create(poul);
        driverService.create(bob);
        System.out.println(driverService.getAll());
    }
}
