package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Manufacturer manufacturer = new Manufacturer("Daewoo Lanos", "South Korea");
        ManufacturerService manufacturerService = (
                ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer savedManufacturer = manufacturerService.create(manufacturer);
        System.out.println(savedManufacturer);
        savedManufacturer.setCountry("North Korea");
        manufacturerService.update(savedManufacturer);
        System.out.println(manufacturerService.get(savedManufacturer.getId()));
        System.out.println(manufacturerService.delete(savedManufacturer.getId()));
        manufacturerService.getAll().forEach(System.out::println);
        DriverService driverService = (
                DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver("Andrey Sidorkin", "FRD-034567");
        Driver savedDriver = driverService.create(driver);
        System.out.println(savedDriver);
        savedDriver.setLicenseNumber("ARG-56489");
        driverService.update(savedDriver);
        System.out.println(driverService.get(savedDriver.getId()));
        System.out.println(driverService.delete(savedDriver.getId()));
        driverService.getAll().forEach(System.out::println);
    }
}
