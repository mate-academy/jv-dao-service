package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Manufacturer currentManufacturer = new Manufacturer();
        currentManufacturer.setName("BMW Group");
        currentManufacturer.setCountry("Germany");

        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);

        System.out.println("Create manufacturer");
        Manufacturer savedManufacturer = manufacturerService.create(currentManufacturer);
        System.out.println(savedManufacturer);

        System.out.println("Get manufacturer");
        Manufacturer requiredManufacturer = manufacturerService
                .get(savedManufacturer.getId());
        System.out.println(requiredManufacturer);

        System.out.println("Get all manufacturers");
        List<Manufacturer> manufacturers = manufacturerService.getAll();
        for (Manufacturer manufacturer : manufacturers) {
            System.out.println(manufacturer);
        }

        System.out.println("Update manufacturer");
        currentManufacturer.setCountry("USA");
        currentManufacturer = manufacturerService.update(currentManufacturer);
        System.out.println(currentManufacturer);

        System.out.println("Delete manufacturer");
        manufacturerService.delete(currentManufacturer.getId());
        manufacturers = manufacturerService.getAll();
        for (Manufacturer manufacturer : manufacturers) {
            System.out.println(manufacturer);
        }

        Driver currentDriver = new Driver();
        currentDriver.setName("John");
        currentDriver.setLicenseNumber("123456");

        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);

        System.out.println("Create driver");
        Driver savedDriver = driverService.create(currentDriver);
        System.out.println(savedDriver);

        System.out.println("Get driver");
        Driver requiredDriver = driverService
                .get(savedDriver.getId());
        System.out.println(requiredDriver);

        System.out.println("Get all drivers");
        List<Driver> drivers = driverService.getAll();
        for (Driver driver : drivers) {
            System.out.println(driver);
        }

        System.out.println("Update driver");
        currentDriver.setLicenseNumber("654321");
        currentDriver = driverService.update(currentDriver);
        System.out.println(currentDriver);

        System.out.println("Delete driver");
        driverService.delete(currentDriver.getId());
        drivers = driverService.getAll();
        for (Driver driver : drivers) {
            System.out.println(driver);
        }
    }
}
