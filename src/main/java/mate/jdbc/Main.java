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
        Manufacturer mercedes = new Manufacturer("Mercedes", "Germany");
        System.out.println(manufacturerService.get(5L));
        DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver("Ivan", "4365345");
        System.out.println(driverService.create(driver));
        System.out.println(driverService.get(2L));
        System.out.println(driverService.getAll());
        Driver driverVasyl = new Driver("Vasyl", "3542424");
        driverVasyl.setId(11L);
        System.out.println(driverService.update(driverVasyl));
        System.out.println(driverService.delete(15L));
    }
}
