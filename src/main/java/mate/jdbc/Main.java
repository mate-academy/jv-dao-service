package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    public static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver driver1 = new Driver("driver1", "12345");
        Driver driver2 = new Driver("driver2", "54321");
        Driver driver3 = new Driver("driver3", "56789");
        driverService.create(driver1);
        driverService.create(driver2);
        driverService.create(driver3);
        driver1 = driverService.get(1L);
        driver1.setLicenseNumber("98765");
        driverService.update(driver1);
        driverService.delete(1L);
        driverService.getAll().forEach(System.out::println);

        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer1 = new Manufacturer("manufacturer1", "country1");
        Manufacturer manufacturer2 = new Manufacturer("manufacturer2", "country2");
        Manufacturer manufacturer3 = new Manufacturer("manufacturer3", "country3");
        manufacturerService.create(manufacturer1);
        manufacturerService.create(manufacturer2);
        manufacturerService.create(manufacturer3);
        manufacturer1 = manufacturerService.get(1L);
        manufacturer1.setCountry("country99");
        manufacturerService.update(manufacturer1);
        manufacturerService.delete(1L);
        manufacturerService.getAll().forEach(System.out::println);
    }
}
