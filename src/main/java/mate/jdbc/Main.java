package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);

        Manufacturer manufacturer = new Manufacturer("Zaz", "Ukraine");
        System.out.println(manufacturerService.create(manufacturer));

        Driver driver = new Driver("Joey", "КАІ 12345");
        System.out.println(driverService.create(driver));

        manufacturer.setName("Dacia");
        manufacturer.setCountry("Romania");
        manufacturer.setName("VAG");
        manufacturer.setCountry("Germany");
        manufacturer.setName("Seat");
        manufacturer.setCountry("Spain");

        driver.setName("Ross");
        driver.setLicenseNumber("ГЕН 23456");
        driver.setName("Chandler");
        driver.setLicenseNumber("ПАТ 34567");
        driver.setName("Monica");
        driver.setLicenseNumber("ТОВ 45678");

        System.out.println(manufacturerService.update(manufacturer));
        System.out.println(manufacturerService.get(1L));
        System.out.println(manufacturerService.delete(2L));
        System.out.println(manufacturerService.getAll());

        System.out.println(driverService.update(driver));
        System.out.println(driverService.get(1L));
        System.out.println(driverService.delete(2L));
        System.out.println(driverService.getAll());
    }
}
