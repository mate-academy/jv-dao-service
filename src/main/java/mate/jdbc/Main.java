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
        Manufacturer manufacturer = new Manufacturer("Audi", "Germany");
        System.out.println(manufacturerService.create(manufacturer));
        System.out.println(manufacturerService.get(manufacturer.getId()));
        manufacturer.setName("Mercedes");
        System.out.println(manufacturerService.update(manufacturer));
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println(manufacturerService.delete(manufacturer.getId()));

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver("Bob", "12345");
        System.out.println(driverService.create(driver));
        System.out.println(driverService.get(driver.getId()));
        driver.setLicenseNumber("56789");
        System.out.println(driverService.update(driver));
        driverService.getAll().forEach(System.out::println);
        System.out.println(driverService.delete(driver.getId()));
    }
}
