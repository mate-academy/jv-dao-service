package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static DriverService driverService;
    private static ManufacturerService manufacturerService;

    public static void main(String[] args) {
        driverService = (DriverService) injector.getInstance(DriverService.class);
        manufacturerService = (ManufacturerService) injector.getInstance(ManufacturerService.class);

        Driver driver = new Driver();
        driver.setName("Moris");
        driver.setLicenseNumber("9345");
        System.out.println(driverService.create(driver));
        System.out.println(driverService.get(1L));
        System.out.println(driverService.delete(2L));
        System.out.println(driverService.update(driver));
        driverService.getAll().forEach(System.out::println);

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Mercedes-Benz");
        manufacturer.setCountry("Germany");
        System.out.println(manufacturerService.create(manufacturer));
        System.out.println(manufacturerService.get(1L));
        System.out.println(manufacturerService.delete(2L));
        System.out.println(manufacturerService.update(manufacturer));
        manufacturerService.getAll().forEach(System.out::println);
    }
}
