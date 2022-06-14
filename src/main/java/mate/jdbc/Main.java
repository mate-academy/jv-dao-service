package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Nissan");
        manufacturer.setCountry("Japan");
        manufacturerService.create(manufacturer);

        manufacturer.setName("Jeep");
        manufacturer.setCountry("USA");
        manufacturerService.create(manufacturer);

        manufacturerService.getAll().forEach(System.out::println);

        manufacturer.setCountry("Japanese");
        Manufacturer updateNissan = manufacturerService.update(manufacturer);
        System.out.println(updateNissan);

        manufacturerService.delete(manufacturer.getId());
        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);

        Driver driver = new Driver();
        driver.setName("Bob");
        driver.setLicenseNumber("493345778");
        driverService.create(driver);

        driver.setName("Alice");
        driver.setLicenseNumber("576458689");
        driverService.create(driver);

        driverService.getAll().forEach(System.out::println);

        driver.setLicenseNumber("1111111");
        Driver updateBob = driverService.update(driver);
        System.out.println(updateBob);

        driverService.delete(driver.getId());
        driverService.getAll().forEach(System.out::println);
    }
}
