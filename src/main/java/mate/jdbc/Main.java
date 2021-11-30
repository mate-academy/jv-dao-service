package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        Driver driver = new Driver("Pavlo", "SS 333");
        Manufacturer manufacturer =
                new Manufacturer("Opel", "Ukraine");
        System.out.println("Created method: ");
        Driver createdDriver = driverService.create(driver);
        Manufacturer createdManufacturer =
                manufacturerService.create(manufacturer);
        System.out.println(createdDriver);
        System.out.println(createdManufacturer);
        System.out.println("Get all method: ");
        List<Driver> driverList = driverService.getAll();
        driverList.forEach(System.out::println);
        List<Manufacturer> manufacturerList = manufacturerService.getAll();
        manufacturerList.forEach(System.out::println);
        System.out.println("Get method: ");
        System.out.println(driverService.get(createdDriver.getId()));
        System.out.println(manufacturerService.get(createdManufacturer.getId()));
        System.out.println("Update method: ");
        Driver driverForUpdate = new Driver("Slavik", "TT 555");
        driverForUpdate.setId(2L);
        createdDriver = driverService.update(driverForUpdate);
        System.out.println(createdDriver);
        Manufacturer manufacturerForUpdate =
                new Manufacturer("Kia", "Russia");
        manufacturerForUpdate.setId(10L);
        createdManufacturer = manufacturerService.update(manufacturerForUpdate);
        System.out.println(createdManufacturer);
        System.out.println("Delete method: ");
        System.out.println(driverService.delete(createdDriver.getId()));
        System.out.println(manufacturerService
                .delete(createdManufacturer.getId()));
    }
}
