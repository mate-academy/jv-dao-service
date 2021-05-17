package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    public static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Volkswagen");
        manufacturer.setCountry("Germany");

        Driver driver = new Driver();
        driver.setName("Petro");
        driver.setLicenseNumber("MN9909L");

        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);

        manufacturerService.create(manufacturer);
        driverService.create(driver);

        manufacturerService.getAll().forEach(System.out::println);
        driverService.getAll().forEach(System.out::println);

        driver.setName("John");
        driver.setLicenseNumber("1112TY");
        manufacturer.setName("ZAZ");
        manufacturer.setCountry("Ukraine");
        manufacturerService.update(manufacturer);
        driverService.update(driver);
        manufacturerService.getAll().forEach(System.out::println);
        driverService.getAll().forEach(System.out::println);

        manufacturerService.delete(manufacturer.getId());
        driverService.delete(driver.getId());
        manufacturerService.getAll().forEach(System.out::println);
        driverService.getAll().forEach(System.out::println);
    }
}
