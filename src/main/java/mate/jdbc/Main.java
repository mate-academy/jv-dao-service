package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer("Zelensky's inc.", "Ukraine");
        Manufacturer createdManufacturer = manufacturerService.create(manufacturer);
        System.out.println("createdManufacturer = "
                + createdManufacturer);
        System.out.println("gotManufacturer = "
                + manufacturerService.get(createdManufacturer.getId()));
        manufacturerService.getAll().forEach(System.out::println);
        createdManufacturer.setName("Dmitro's inc.");
        createdManufacturer.setCountry("Belarus");
        System.out.println("updatedManufacturer = "
                + manufacturerService.update(createdManufacturer));
        System.out.println("Manufacturer deletion completed = "
                + manufacturerService.delete(createdManufacturer.getId()));
        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver("Zelensky", "46RIKNOTL");
        Driver createdDriver = driverService.create(driver);
        System.out.println("createdDriver = "
                + createdDriver);
        System.out.println("gotDriver = "
                + driverService.get(createdDriver.getId()));
        driverService.getAll().forEach(System.out::println);
        createdDriver.setName("Dmitro");
        createdDriver.setLicenseNumber("33RIKUTEK");
        System.out.println("updatedDriver = "
                + driverService.update(createdDriver));
        System.out.println("Driver deletion completed = "
                + driverService.delete(createdDriver.getId()));
        driverService.getAll().forEach(System.out::println);
    }
}
