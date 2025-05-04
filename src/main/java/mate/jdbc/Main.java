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
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        List<Manufacturer> manufacturerList = List.of(
                new Manufacturer("AUDI", "Germany"),
                new Manufacturer("Volkswagen", "Germany"),
                new Manufacturer("Toyota", "Japan")
        );
        manufacturerList.forEach(manufacturerService::create);
        Manufacturer testManufacturer = manufacturerService.get(2L);
        testManufacturer.setName("BMV");
        manufacturerService.update(testManufacturer);
        manufacturerService.delete(testManufacturer.getId());
        System.out.println(manufacturerService.getAll());
        List<Driver> driverList = List.of(
                new Driver("driver0001", "KNJ589778"),
                new Driver("driver0002", "KMS564665"),
                new Driver("driver0003", "SFF899865")
        );
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        driverList.forEach(driverService::create);
        Driver findDriver = driverService.get(2L);
        findDriver.setLicenseNumber("ABC000000");
        driverService.update(findDriver);
        driverService.delete(findDriver.getId());
        System.out.println(driverService.getAll());
    }
}
