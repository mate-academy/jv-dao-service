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
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer;

        Manufacturer mitsubishi = new Manufacturer();
        mitsubishi.setName("Mitsubishi");
        mitsubishi.setCountry("Japan");
        manufacturer = manufacturerService.create(mitsubishi);
        System.out.println("Created first manufacturer: " + manufacturer);

        Manufacturer mersedes = new Manufacturer();
        mersedes.setName("Mersedes");
        mersedes.setCountry("German");
        manufacturer = manufacturerService.create(mersedes);
        System.out.println("Created second manufacturer: " + manufacturer);

        Manufacturer lamborghini = new Manufacturer();
        lamborghini.setName("Lamborghini");
        lamborghini.setCountry("Italy");
        manufacturer = manufacturerService.create(lamborghini);
        System.out.println("Created third manufacturer: " + manufacturer);

        manufacturer = manufacturerService.get(2L);
        System.out.println("Manufacturer got from DB: " + manufacturer);

        manufacturer.setName("Mercedes");
        manufacturer.setCountry("Germany");
        manufacturer = manufacturerService.update(manufacturer);
        System.out.println("Manufacturer after update: " + manufacturer);

        boolean isDeletedManufacturer = manufacturerService.delete(1L);
        System.out.println("Manufacturer deleted = " + isDeletedManufacturer);

        List<Manufacturer> manufacturers = manufacturerService.getAll();
        manufacturers.forEach(System.out::println);

        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        Driver driver;

        Driver roman = new Driver();
        roman.setName("Roman");
        roman.setLicenseNumber("ID223164");
        driver = driverService.create(roman);
        System.out.println("Created first driver: " + driver);

        Driver oleg = new Driver();
        oleg.setName("Oleg");
        oleg.setLicenseNumber("ID223165");
        driver = driverService.create(oleg);
        System.out.println("Created second driver: " + driver);

        Driver john = new Driver();
        john.setName("John");
        john.setLicenseNumber("ID223166");
        driver = driverService.create(john);
        System.out.println("Created third driver: " + driver);

        driver = driverService.get(1L);
        System.out.println("Driver got from DB: " + driver);

        driver.setName("Bob");
        driver.setLicenseNumber("ID223167");
        driver = driverService.update(driver);
        System.out.println("Driver after update: " + driver);

        boolean isDeletedDriver = driverService.delete(2L);
        System.out.println("Driver deleted = " + isDeletedDriver);

        List<Driver> drivers = driverService.getAll();
        drivers.forEach(System.out::println);
    }
}
