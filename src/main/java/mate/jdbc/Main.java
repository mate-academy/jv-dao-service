package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector =
            Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer0 =
                manufacturerService.create(new Manufacturer("Toyota", "Japan"));
        Manufacturer manufacturer1 =
                manufacturerService.create(new Manufacturer("Mitsubishi", "Japan"));
        Manufacturer manufacturer2 =
                manufacturerService.create(new Manufacturer("Ferrari", "Italy"));
        Manufacturer manufacturer3 =
                manufacturerService.create(new Manufacturer("Doge", "USA"));
        Manufacturer manufacturer = manufacturerService.get(2L);
        List<Manufacturer> allManufacturers = manufacturerService.getAll();
        boolean deleteManufacturer = manufacturerService.delete(30L);
        Manufacturer updateManufacturer = manufacturerService.update(manufacturer3);
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver driver0 = driverService.create(new Driver("William", "F5556F"));
        Driver driver1 = driverService.create(new Driver("Van", "G6669K"));
        Driver driver2 = driverService.create(new Driver("Brad", "G4444L"));
        Driver driver3 = driverService.create(new Driver("Ray", "G4321P"));
        Driver driver = driverService.get(2L);
        List<Driver> allDrivers = driverService.getAll();
        boolean deleteDriver = driverService.delete(1L);
        Driver updateDriver = driverService.update(driver1);
    }
}
