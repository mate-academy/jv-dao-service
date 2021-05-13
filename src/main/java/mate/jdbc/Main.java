package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.interfaces.DriverService;
import mate.jdbc.service.interfaces.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer =
                new Manufacturer("New Manufacturer", "New Country");

        Manufacturer createdManufacturer = manufacturerService.create(manufacturer);
        createdManufacturer.setName("Updated Manufacturer");
        Manufacturer updatedManufacturer = manufacturerService.update(createdManufacturer);
        manufacturerService.delete(updatedManufacturer.getId());
        createdManufacturer = manufacturerService.create(manufacturer);
        System.out.println(manufacturerService.get(createdManufacturer.getId()));

        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver("New Driver", "New license_num");

        Driver createdDriver = driverService.create(driver);
        createdDriver.setName("Updated Driver");
        Driver updatedDriver = driverService.update(driver);
        driverService.delete(updatedDriver.getId());
        createdDriver = driverService.create(driver);
        System.out.println(driverService.get(createdDriver.getId()));

        manufacturerService.getAll().forEach(System.out::println);
        driverService.getAll().forEach(System.out::println);
    }
}
