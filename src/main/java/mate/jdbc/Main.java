package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Manufacturer manufacturer = new Manufacturer();
        /*manufacturer.setName("Honda");
        manufacturer.setCountry("Japan");
        manufacturerService.create(manufacturer);
        manufacturer.setName("Ford");
        manufacturer.setCountry("USA");
        manufacturerService.create(manufacturer);
        System.out.println(manufacturerService.get(8L));
        manufacturer.setId(8L);
        manufacturer.setName("Dodge");
        manufacturer.setCountry("USA");
        manufacturerService.update(manufacturer);*/
        manufacturerService.delete(8L);

        Driver driver = new Driver();
        /*driver.setName("Andrii");
        driver.setLicenseNumber("1234");
        driverService.create(driver);
        driver.setName("Oleg");
        driver.setLicenseNumber("5678");
        driverService.create(driver);
        System.out.println(driverService.get(2L));
        driver.setId(2L);
        driver.setName("Stepan");
        driver.setLicenseNumber("9999");
        driverService.update(driver);*/
        driverService.delete(2L);

        manufacturerService.getAll().forEach(System.out::println);
        driverService.getAll().forEach(System.out::println);
    }
}
