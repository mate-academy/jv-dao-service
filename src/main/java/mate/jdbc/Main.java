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
        Manufacturer manufacturerFerrari = new Manufacturer(null,"Ferrari","Italy");
        Manufacturer manufacturerBmw = new Manufacturer(null,"BMW","Germany");
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        manufacturerService.create(manufacturerBmw);
        manufacturerService.create(manufacturerFerrari);
        List<Manufacturer> manufacturers = manufacturerService.getAll();
        Manufacturer manufacturer = manufacturerService.get(16L);
        System.out.println(manufacturer);
        manufacturerFerrari.setName("SuperFerrari");
        manufacturerService.update(manufacturerFerrari);
        manufacturerService.delete(manufacturer.getId());
        Driver driverFerrari = new Driver(null,"Bob","666");
        Driver driverBmw = new Driver(null,"Jack","777");
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        driverService.create(driverFerrari);
        driverService.create(driverBmw);
        List<Driver> drivers = driverService.getAll();
        Driver driver = driverService.get(2L);
        System.out.println(driver);
        driverFerrari.setName("SuperBob");
        driverService.update(driverFerrari);
        driverService.delete(driver.getId());
    }
}
