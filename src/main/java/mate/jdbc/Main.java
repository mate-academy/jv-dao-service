package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        System.out.println("Testing ManufacturerService: ");
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setCountry("Germany");
        manufacturer.setName("Mazda");
        manufacturer = manufacturerService.create(manufacturer);

        System.out.println(manufacturerService.get(manufacturer.getId()));

        manufacturer.setCountry("France");
        manufacturer.setName("Reno");
        System.out.println(manufacturerService.update(manufacturer));

        manufacturerService.getAll().forEach(System.out::println);
        manufacturerService.delete(manufacturer.getId());
        manufacturerService.getAll().forEach(System.out::println);

        System.out.println("\nTesting DriverService: ");
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver(null, "Bob", "234");

        driver = driverService.create(driver);

        System.out.println(driverService.get(driver.getId()));

        driver.setLicenseNumber("312");
        driver.setName("Bill");
        System.out.println(driverService.update(driver));

        driverService.getAll().forEach(System.out::println);
        manufacturerService.delete(driver.getId());
        manufacturerService.getAll().forEach(System.out::println);
    }
}
