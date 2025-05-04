package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver();
        driverService.getAll().forEach(System.out::println);
        driver.setName("Petro Poroshenko");
        driver.setLicenseNumber("7777777");
        driverService.create(driver);
        Driver driver1 = driverService.get(1L);
        System.out.println(driver1);
        driverService.getAll().forEach(System.out::println);
        driver.setName("Petro Poroshenko Chocolate King");
        driverService.update(driver);
        driverService.getAll().forEach(System.out::println);
        driverService.delete(1L);
        driverService.getAll().forEach(System.out::println);

        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Bohdan");
        manufacturer.setCountry("Ukraine");
        manufacturerService.create(manufacturer);
        Manufacturer manufacturer1 = manufacturerService.get(1L);
        System.out.println(manufacturer1);
        manufacturerService.getAll().forEach(System.out::println);
        manufacturer.setName("Tavria");
        manufacturerService.update(manufacturer);
        manufacturerService.getAll().forEach(System.out::println);
        manufacturerService.delete(1L);
    }
}
