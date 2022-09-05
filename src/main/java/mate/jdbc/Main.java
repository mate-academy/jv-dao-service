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
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Dachia");
        manufacturer.setCountry("Romania");
        Manufacturer manufacturerFromDb = manufacturerService.create(manufacturer);
        System.out.println(manufacturer);
        System.out.println("--------------------");

        System.out.println("Get manufacturer");
        Manufacturer optionalManufacturer =
                manufacturerService.get(manufacturerFromDb.getId());
        System.out.println(optionalManufacturer);
        System.out.println("--------------------");

        System.out.println("GetAll manufacturer");
        List<Manufacturer> allManufacturer = manufacturerService.getAll();
        allManufacturer.stream().forEach(System.out::println);
        System.out.println("--------------------");

        System.out.println("Update manufacturer");
        Manufacturer updateManufacturer = new Manufacturer();
        updateManufacturer.setId(manufacturerFromDb.getId());
        updateManufacturer.setName("Kia");
        updateManufacturer.setCountry("Korea");
        System.out.println(manufacturerService.update(updateManufacturer));
        System.out.println("--------------------");

        System.out.println("Delete manufacturer");
        System.out.println(manufacturerService.delete(manufacturerFromDb.getId()));
        System.out.println("--------------------");

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        Driver driver = new Driver();
        driver.setName("Sergey");
        driver.setLicenseNumber("987445");
        Driver driverFromDb = driverService.create(driver);
        System.out.println(driver);
        System.out.println("--------------------");

        System.out.println("Get Driver");
        Driver optionalDriver = driverService.get(driverFromDb.getId());
        System.out.println(optionalDriver);
        System.out.println("--------------------");

        System.out.println("GetAll drivers");
        List<Driver> allDrivers = driverService.getAll();
        allDrivers.stream().forEach(System.out::println);
        System.out.println("--------------------");

        System.out.println("Update Driver");
        Driver updateDriver = new Driver();
        updateDriver.setId(driverFromDb.getId());
        updateDriver.setName("Slava");
        updateDriver.setLicenseNumber("99999");
        System.out.println(driverService.update(updateDriver));
        System.out.println("--------------------");

        System.out.println("Delete driver");
        System.out.println(driverService.delete(driverFromDb.getId()));
        System.out.println("--------------------");
    }
}
