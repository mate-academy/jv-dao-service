package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        // test your code here
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Manufacturer manufacturer = new Manufacturer(1L, "Alfa Romeo", "Italy");
        Manufacturer updateManufacturer = new Manufacturer(2L, "Fiat", "Italy");
        manufacturerService.create(manufacturer);
        System.out.println(driverService.get(1L));
        manufacturerService.update(updateManufacturer);
        manufacturerService.delete(manufacturer.getId());
        manufacturerService.getAll().forEach(System.out::println);
        Driver driver = new Driver(1L, "Nick Sample", "AZ 112 455");
        Driver updateDriver = new Driver(1L, "Bred Pitt", "AZ 345 878");
        driverService.create(driver);
        System.out.println(driverService.get(driver.getId()));
        driverService.update(updateDriver);
        driverService.delete(driver.getId());
        driverService.getAll().forEach(System.out::println);
    }
}
