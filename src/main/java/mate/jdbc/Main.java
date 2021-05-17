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
        System.out.println(manufacturerService.get(5L));
        DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);

        Driver driver = new Driver("George", "4365345");
        System.out.println(driverService.create(driver));
        System.out.println(driverService.get(2L));
        System.out.println(driverService.getAll());

        Driver driverJohn = new Driver("John", "3542424");
        driverJohn.setId(11L);
        System.out.println(driverService.update(driverJohn));
        System.out.println(driverService.delete(15L));
    }
}
