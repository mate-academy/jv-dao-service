package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        Driver driver = new Driver(4L,"Yuriy", "sm002244");
        driverService.create(driver);
        driverService.delete(3L);
        driverService.update(new Driver(4L, "Yurko", "sm113355"));
        driverService.getAll().forEach(System.out::println);
        System.out.println(driverService.get(1L));
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        manufacturerService.getAll().forEach(System.out::println);
    }
}
