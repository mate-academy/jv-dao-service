package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.driver.DriverService;
import mate.jdbc.service.manufacturer.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Honda");
        manufacturer.setCountry("Japan");
        manufacturerService.create(manufacturer);
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println();
        manufacturer.setName("Subaru");
        manufacturerService.update(manufacturer);
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println();
        System.out.println(manufacturerService.get(manufacturer.getId()));
        System.out.println();
        manufacturerService.delete(manufacturer.getId());
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println();
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        driverService.getAll().forEach(System.out::println);
        System.out.println();
        Driver driver = new Driver();
        driver.setName("Petro Kulish");
        driver.setLicenseNumber("RR 8765");
        driverService.create(driver);
        driverService.getAll().forEach(System.out::println);
        System.out.println();
        driver.setLicenseNumber("AA 3333");
        driverService.update(driver);
        driverService.getAll().forEach(System.out::println);
        System.out.println();
        System.out.println(driverService.get(driver.getId()));
        System.out.println();
        driverService.delete(driver.getId());
        driverService.getAll().forEach(System.out::println);
    }
}
