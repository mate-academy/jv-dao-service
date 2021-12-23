package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver();
        driver.setName("Nic");
        driver.setLicenseNumber("252525");
        System.out.println(driverService.create(driver));
        System.out.println(driverService.get(2L));
        System.out.println(driverService.update(new Driver(3L, "Alex", "255227")));
        driverService.getAll().forEach(System.out::println);
        System.out.println(driverService.delete(3L));

        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Renault");
        manufacturer.setCountry("France");
        System.out.println(manufacturerService.create(manufacturer));
        System.out.println(manufacturerService.get(1L));
        System.out.println(manufacturerService.update(new Manufacturer(1L, "Toyota", "Japan")));
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println(manufacturerService.delete(4L));
    }
}
