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
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer fiat = new Manufacturer("fiat", "Italy");
        Manufacturer honda = new Manufacturer("honda", "Japan");
        Manufacturer ford = new Manufacturer("ford", "USA");
        manufacturerService.create(fiat);
        manufacturerService.create(honda);
        manufacturerService.create(ford);
        manufacturerService.delete(honda.getId());
        honda.setCountry("Korea");
        honda.setName("hyundai");
        System.out.println(manufacturerService.update(honda));
        System.out.println(manufacturerService.get(fiat.getId()));
        List<Manufacturer> allManufacturers = manufacturerService.getAll();
        for (Manufacturer manufacturer : allManufacturers) {
            System.out.println(manufacturer);
        }
        DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);
        Driver goga = new Driver("Goga", "001");
        Driver magoga = new Driver("Magoga", "002");
        Driver petya = new Driver("Petya", "003");
        Driver vasya = new Driver("Vasya", "004");
        driverService.create(goga);
        driverService.create(magoga);
        driverService.create(petya);
        driverService.create(vasya);
        driverService.delete(vasya.getId());
        petya.setName("Bond");
        petya.setLicenseNumber("007");
        System.out.println(driverService.update(petya));
        List<Driver> allDrivers = driverService.getAll();
        for (Driver driver : allDrivers) {
            System.out.println(driver);
        }
    }
}

