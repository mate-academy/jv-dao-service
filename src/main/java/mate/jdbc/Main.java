package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        List<Manufacturer> allManufacturers = manufacturerService.getAll();
        for (Manufacturer manufacturer: allManufacturers) {
            System.out.println(manufacturer);
        }
        Driver oleg = driverService.create(new Driver("Oleg","1243"));
        Driver ann = driverService.create(new Driver("Ann","12563"));
        Driver kate = driverService.create(new Driver("Kate","54234"));
        Driver john = driverService.create(new Driver("John","4265789"));
        kate.setLicenseNumber("94567234");
        kate = driverService.update(kate);
        driverService.delete(john.getId());
        List<Driver> allDrivers = driverService.getAll();
        for (Driver driver : allDrivers) {
            System.out.println(driver);
        }
    }
}
