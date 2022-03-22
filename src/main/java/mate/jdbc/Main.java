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
        Driver driver1 = driverService.create(new Driver("driver1", "12345"));
        Driver driver2 = driverService.create(new Driver("driver2", "54321"));
        Driver driver3 = driverService.create(new Driver("driver3", "56789"));
        driver1 = driverService.get(driver1.getId());
        driver1.setLicenseNumber("98765");
        driverService.update(driver1);
        System.out.println("Deleted: = " + driverService.delete(driver1.getId()));
        driverService.getAll().forEach(System.out::println);

        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer1 = manufacturerService.create(
                new Manufacturer("manufacturer1", "country1"));
        Manufacturer manufacturer2 = manufacturerService.create(
                new Manufacturer("manufacturer2", "country2"));
        Manufacturer manufacturer3 = manufacturerService.create(
                new Manufacturer("manufacturer3", "country3"));
        manufacturer1 = manufacturerService.get(manufacturer1.getId());
        manufacturer1.setCountry("country99");
        manufacturerService.update(manufacturer1);
        System.out.println("Deleted: = " + manufacturerService.delete(manufacturer1.getId()));
        manufacturerService.getAll().forEach(System.out::println);
    }
}
