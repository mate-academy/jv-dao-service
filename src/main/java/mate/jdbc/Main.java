package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        Manufacturer car = new Manufacturer(null, "car", "Uganda");
        System.out.println(manufacturerService.create(car));
        car.setName("bike");
        System.out.println(manufacturerService.update(car));
        System.out.println(manufacturerService.getAll());
        System.out.println(manufacturerService.get(car.getId()));
        System.out.println(manufacturerService.delete(car.getId()));

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver igor = new Driver(null, "Igor", "123456");
        System.out.println(driverService.create(igor));
        igor.setName("notIgor");
        System.out.println(driverService.update(igor));
        System.out.println(driverService.getAll());
        System.out.println(driverService.get(igor.getId()));
        System.out.println(driverService.delete(igor.getId()));
    }
}
