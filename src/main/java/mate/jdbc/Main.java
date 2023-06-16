package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        final ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        final DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        Driver driver = new Driver();
        final Driver updateDriver = new Driver(1L, "Volodymyr", "1234");
        driver.setName("Bob");
        driver.setLicenseNumber("4321");
        final Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("GMC");
        manufacturer.setCountry("USA");
        final Manufacturer updateManufacturer = new Manufacturer(5L, "Ford", "USA");
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println(manufacturerService.get(12L));
        System.out.println(manufacturerService.create(manufacturer));
        System.out.println(manufacturerService.update(updateManufacturer));
        System.out.println(manufacturerService.delete(5L));
        driverService.getAll().forEach(System.out::println);
        System.out.println(driverService.get(1L));
        System.out.println(driverService.create(driver));
        System.out.println(driverService.update(updateDriver));
        System.out.println(driverService.delete(5L));
    }
}
