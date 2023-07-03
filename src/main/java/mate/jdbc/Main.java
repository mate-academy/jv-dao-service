package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.services.DriverService;
import mate.jdbc.services.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        // test your code here
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println("----------");
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Porshe");
        manufacturer.setCountry("Germany");
        System.out.println(manufacturerService.create(manufacturer));
        System.out.println("----------");
        manufacturerService.getAll().forEach(System.out::println);
        manufacturer.setName("BMW");
        System.out.println(manufacturerService.update(manufacturer));
        System.out.println("----------");
        manufacturerService.getAll().forEach(System.out::println);
        manufacturerService.delete(manufacturer.getId());
        System.out.println("----------");
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println("----------");

        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        driverService.getAll().forEach(System.out::println);
        System.out.println("----------");
        Driver driver = new Driver();
        driver.setName("John");
        driver.setLicenseNumber("15KlJM");
        System.out.println(driverService.create(driver));
        System.out.println("----------");
        driverService.getAll().forEach(System.out::println);
        System.out.println("----------");
        driver.setLicenseNumber("16FKL");
        driverService.update(driver);
        System.out.println("----------");
        driverService.getAll().forEach(System.out::println);
        System.out.println("----------");
        driverService.delete(driver.getId());
        System.out.println("----------");
        driverService.getAll().forEach(System.out::println);
    }
}
