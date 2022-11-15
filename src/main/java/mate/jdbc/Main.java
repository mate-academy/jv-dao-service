package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver("Jack", "111");
        driverService.create(driver);
        System.out.println(driverService.get(driver.getId()));
        driverService.getAll().stream().forEach(System.out::println);
        driver.setLicenseNumber("222");
        driverService.update(driver);
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer("Ferrari", "Germany");
        manufacturerService.create(manufacturer);
        System.out.println(manufacturerService.get(manufacturer.getId()));
        manufacturerService.getAll().stream().forEach(System.out::println);
        manufacturer.setCountry("Italy");
        manufacturerService.update(manufacturer);
        driverService.delete((long) 1);
        manufacturerService.delete((long) 1);
    }
}
