package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    public static void main(String[] args) {
        Injector injector = Injector.getInstance("mate.jdbc");
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        Manufacturer bmw = new Manufacturer("BMW", "Germany");
        Manufacturer mercedes = new Manufacturer("Mercedes", "Germany");
        Manufacturer newBmw = manufacturerService.create(bmw);
        Manufacturer newMercedes = manufacturerService.create(mercedes);
        System.out.println(manufacturerService.delete(newMercedes.getId()));
        newBmw.setCountry("Ukraine");
        newBmw = manufacturerService.update(newBmw);
        Manufacturer dbManufacturer = manufacturerService.get(newBmw.getId());
        System.out.println(dbManufacturer);
        List<Manufacturer> manufacturerData = manufacturerService.getAll();
        System.out.println(manufacturerData.toString());
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        Driver bob = new Driver("Bob", "12345");
        Driver alice = new Driver("Alice", "67890");
        Driver newBob = driverService.create(bob);
        Driver newAlice = driverService.create(alice);
        System.out.println(manufacturerService.delete(newBob.getId()));
        newAlice.setLicenseNumber("1234567890");
        newAlice = driverService.update(newAlice);
        Driver dbDriver = driverService.get(newAlice.getId());
        System.out.println(dbDriver);
        List<Driver> driverData = driverService.getAll();
        System.out.println(driverData.toString());
    }
}
