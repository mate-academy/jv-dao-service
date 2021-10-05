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
        Manufacturer zaz = new Manufacturer("ZAZ", "Ukraine");
        Manufacturer kia = new Manufacturer("Kia","South Korea");
        manufacturerService.create(zaz);
        manufacturerService.create(kia);
        manufacturerService.delete(kia.getId());
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        Driver driver1 = new Driver("Bob", "123456");
        Driver driver2 = new Driver("john", "96585");
        driverService.create(driver1);
        driverService.create(driver2);
        System.out.println(driverService.get(driver1.getId()));
        System.out.println(driverService.get(driver2.getId()));
        System.out.println(driverService.getAll());
        driver1.setLicenseNumber("11111");
        driverService.update(driver1);
        System.out.println(driverService.delete(driver2.getId()));
        System.out.println(driverService.getAll());
    }
}
