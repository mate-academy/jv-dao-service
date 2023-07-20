package mate.jdbc;

import java.util.Optional;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;
import mate.jdbc.service.impl.DriverServiceImpl;
import mate.jdbc.service.impl.ManufacturerServiceImpl;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerServiceImpl) injector.getInstance(ManufacturerService.class);

        DriverService driverService =
                (DriverServiceImpl) injector.getInstance(DriverService.class);

        Manufacturer germanyCarManufacturer = manufacturerService.createDefaultManufacturer();
        Driver ukrDriver = driverService.createDefaultDriver();

        Manufacturer createdManufacturer = manufacturerService.create(germanyCarManufacturer);
        System.out.println("Created Manufacturer: "
                + createdManufacturer.getName() + "-" + createdManufacturer.getCountry());

        Driver createdDriver = driverService.create(ukrDriver);
        System.out.println("Created Driver: "
                + createdDriver.getName()
                + " ,driver_licence: " + createdDriver.getLicenseNumber());

        Optional<Manufacturer> manufacturer =
                manufacturerService.get(createdManufacturer.getId());
        manufacturer.ifPresent(System.out::println);

        Optional<Driver> driver = driverService.get(createdDriver.getId());
        driver.ifPresent(System.out::println);

        System.out.println("List of manufacturers:");
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println("List of drivers:");
        driverService.getAll().forEach(System.out::println);

        germanyCarManufacturer.setName("BMW");
        Manufacturer updateManufacturer = manufacturerService.update(germanyCarManufacturer);
        System.out.println("Updated Manufacturer: " + updateManufacturer.getName()
                + "-" + updateManufacturer.getCountry());

        ukrDriver.setName("Yevhen Konovalets");
        ukrDriver.setLicenseNumber("1891");
        Driver updatedDriver = driverService.update(ukrDriver);
        System.out.println("Updated Driver: " + updatedDriver.getName()
                + " ,driver_licence: " + updatedDriver.getLicenseNumber());

        boolean deletedManufacturer = manufacturerService.delete(createdManufacturer.getId());
        System.out.println("Deleted Manufacturer: " + deletedManufacturer);

        boolean deletedDriver = driverService.delete(createdDriver.getId());
        System.out.println("Deleted driver: " + deletedDriver);

    }
}
