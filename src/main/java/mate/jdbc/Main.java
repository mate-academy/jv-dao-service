package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);
        Driver driver = new Driver();
        driver.setName("Vasyl");
        driver.setLicenseNumber("123J4IF434F73VG34");
        driverService.create(driver);
        System.out.println(driverService.get(1L));
        driver.setLicenseNumber("12323hh");
        System.out.println(driverService.update(driver));
        driverService.delete(1L);
        driverService.getAll().forEach(System.out::println);

        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("BMW");
        manufacturer.setCountry("Germany");
        manufacturerService.create(manufacturer);
        System.out.println(manufacturerService.get(1L));
        manufacturer.setName("bmw");
        System.out.println(manufacturerService.get(1L));
        manufacturerService.getAll().forEach(System.out::println);
    }
}
