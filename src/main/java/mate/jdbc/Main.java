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

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Monica");
        manufacturer.setCountry("Mexico");
        Manufacturer manufacturerMonica = manufacturerService.create(manufacturer);
        System.out.println(manufacturerMonica);

        long manufacturerId = 11L;
        System.out.println(manufacturerService.get(manufacturerId));

        List<Manufacturer> allManufacturers = manufacturerService.getAll();
        allManufacturers.forEach(System.out::println);

        Manufacturer updateManufacturer = new Manufacturer(7L, "Chandler", "Britain");
        manufacturerService.update(updateManufacturer);

        System.out.println(manufacturerService.delete(9L));

        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);

        Driver driver = new Driver();
        driver.setName("Alex");
        driver.setLicenseNumber("44831");
        Driver driverAlex = driverService.create(driver);
        System.out.println(driverAlex);

        long driverId = 2L;
        System.out.println(driverService.get(driverId));

        List<Driver> allDivers = driverService.getAll();
        allDivers.forEach(System.out::println);

        Driver updateDriver = new Driver(1L, "Monica", "22234");
        driverService.update(updateDriver);

        System.out.println(driverService.delete(2L));
    }
}
