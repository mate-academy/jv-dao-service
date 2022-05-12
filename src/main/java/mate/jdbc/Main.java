package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        // Driver part
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        Driver driver = new Driver();
        driver.setName("CreateDriver");
        driver.setLicenseNumber("CreateLN");

        Driver createdDriver = driverService.create(driver);

        Driver driverToUpdate = driverService.get(createdDriver.getId());

        driverToUpdate.setName("UpdatedName");
        Driver driverToDelete = driverService.update(driverToUpdate);

        driverService.delete(driverToDelete.getId());

        driverService.getAll().forEach(System.out::println);

        // Manufacturer part
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("FirstManufacturer");
        manufacturer.setCountry("Neverland");

        Manufacturer createdManufacturer = manufacturerService.create(manufacturer);

        createdManufacturer.setName("UpdatedManufacturer");
        Manufacturer updatedManufacturer = manufacturerService.update(createdManufacturer);
        System.out.println(updatedManufacturer);

        Manufacturer initialManufacturer = manufacturerService.get(createdManufacturer.getId());

        manufacturerService.delete(initialManufacturer.getId());

        manufacturerService.getAll().forEach(System.out::println);
    }
}
