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
        driver.setName("Bob");
        driver.setLicenseNumber("12345");
        driverService.create(driver);
        System.out.println(driverService.get(1L));

        driver.setName("Bil");
        driver.setLicenseNumber("12346");
        driverService.create(driver);

        driver.setId(2L);
        driver.setName("Alice");
        driver.setLicenseNumber("12347");
        driverService.create(driver);
        System.out.println(driverService.update(driver));

        driverService.getAll().forEach(System.out::println);

        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer();

        manufacturer.setName("Opel");
        manufacturer.setCountry("Germany");
        manufacturerService.create(manufacturer);
        System.out.println(manufacturerService.get(1L));

        manufacturer.setName("Reno");
        manufacturer.setCountry("France");
        manufacturerService.create(manufacturer);

        manufacturer.setName("Mazda");
        manufacturer.setCountry("Japan");
        manufacturerService.create(manufacturer);
        System.out.println(manufacturerService.delete(2L));

        manufacturer.setId(1L);
        manufacturer.setName("Nisan");
        manufacturer.setCountry("Japan");
        manufacturerService.create(manufacturer);
        System.out.println(manufacturerService.update(manufacturer));

        manufacturerService.getAll().forEach(System.out::println);
    }
}
