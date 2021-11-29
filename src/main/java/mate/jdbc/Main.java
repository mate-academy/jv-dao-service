package mate.jdbc;

import java.util.List;
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
        List<Driver> drivers = List.of(new Driver("Aaron", "fe2606"),
                new Driver("Tommy", "au4419"),
                new Driver("Bob", "tr9090"),
                new Driver("Shon", "no7822"));
        for (Driver driver : drivers) {
            driverService.create(driver);
        }
        System.out.println(driverService.get(40L));
        Driver driver = new Driver("Stewe", "fm3280");
        driverService.create(driver);
        driver.setLicenseNumber("tt8608");
        driverService.update(driver);
        driverService.getAll().forEach(System.out::println);
        driverService.delete(38L);
        driverService.delete(41L);

        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        List<Manufacturer> manufacturers = List.of(new Manufacturer("Mercedes", "Germany"),
                new Manufacturer("Renault", "France"),
                new Manufacturer("Honda", "Japan"),
                new Manufacturer("Daewoo", "Ukraine"));
        for (Manufacturer manufacturer : manufacturers) {
            manufacturerService.create(manufacturer);
        }
        System.out.println(manufacturerService.get(13L));
        Manufacturer manufacturer = new Manufacturer("Hyundai", "North Korea");
        manufacturerService.create(manufacturer);
        manufacturer.setCountry("South Korea");
        manufacturerService.update(manufacturer);
        manufacturerService.getAll().forEach(System.out::println);
        manufacturerService.delete(12L);
        manufacturerService.delete(15L);
    }
}
