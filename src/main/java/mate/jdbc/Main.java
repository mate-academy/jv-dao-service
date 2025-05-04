package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate");

    public static void main(String[] args) {
        // manufacturerDB tests
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Cadillac");
        manufacturer.setCountry("USA");
        manufacturerService.create(manufacturer);
        System.out.println(manufacturerService.get(manufacturer.getId()));
        manufacturerService.getAll().forEach(System.out::println);
        manufacturer.setId(10L);
        manufacturer.setName("Tavriya");
        manufacturer.setCountry("Ukraine");
        manufacturerService.update(manufacturer);
        manufacturerService.delete(8L);
        manufacturerService.getAll().forEach(System.out::println);
        //drivers db tests
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver();
        driver.setName("Ivan");
        driver.setLicenseNumber("canDrive123");
        driverService.create(driver);
        System.out.println(driverService.get(manufacturer.getId()));
        driverService.getAll().forEach(System.out::println);
        driver.setId(1L);
        driver.setName("Petro");
        driver.setLicenseNumber("canDriveTrack456");
        driverService.update(driver);
        driverService.delete(2L);
        driverService.getAll().forEach(System.out::println);
    }
}
