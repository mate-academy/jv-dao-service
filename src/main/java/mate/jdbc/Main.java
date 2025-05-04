package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static ManufacturerService manufacturerService;
    private static DriverService driverService;

    public static void main(String[] args) {
        implementServices();
        showAllManufacturers();
        System.out.println();
        showAllDrivers();
        System.out.println("- - - - - - - - - - - - - - - -");

        System.out.println("Manufacturer with id 2: " + manufacturerService.get(2L));
        System.out.println("Driver with id 2: " + driverService.get(2L));
        System.out.println("- - - - - - - - - - - - - - - -");

        createManufacturer("Honda", "Japan");
        createDriver("Guido", "983473");
        System.out.println("Some manufacturer and driver were added:" + System.lineSeparator());
        showAllManufacturers();
        System.out.println();
        showAllDrivers();
        System.out.println("- - - - - - - - - - - - - - - -");

        System.out.println("Is manufacturer with id 3 deleted: " + manufacturerService.delete(3L));
        System.out.println("Is driver with id 3 deleted: " + driverService.delete(3L));
        System.out.println("- - - - - - - - - - - - - - - -");

        System.out.println("Some manufacturer and driver were deleted:" + System.lineSeparator());
        showAllManufacturers();
        System.out.println();
        showAllDrivers();
        System.out.println("- - - - - - - - - - - - - - - -");

        System.out.println("Manufacturer with id 1 before changes: " + manufacturerService.get(1L));
        updateManufacturer(1L, "Ford", "USA");
        System.out.println("Driver with id 1 before changes: " + driverService.get(1L));
        updateDriver(1L, "Maria", "321545");
        System.out.println("- - - - - - - - - - - - - - - -");

        System.out.println("Some changes in manufacturers and drivers:" + System.lineSeparator());
        showAllManufacturers();
        System.out.println();
        showAllDrivers();
        System.out.println("- - - - - - - - - - - - - - - -");
    }

    private static void implementServices() {
        manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        driverService = (DriverService)
                injector.getInstance(DriverService.class);
    }

    private static void createManufacturer(String name, String country) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName(name);
        manufacturer.setCountry(country);
        manufacturerService.create(manufacturer);
    }

    private static void createDriver(String name, String licenseNumber) {
        Driver driver = new Driver();
        driver.setName(name);
        driver.setLicenseNumber(licenseNumber);
        driverService.create(driver);
    }

    private static void updateManufacturer(Long id, String name, String country) {
        Manufacturer manufacturer = new Manufacturer(id, name, country);
        manufacturerService.update(manufacturer);
        System.out.println("Manufacturer with id " + id
                + "after changes: " + manufacturerService.get(id));
    }

    private static void updateDriver(Long id, String name, String licenseNumber) {
        Driver driver = new Driver(id, name, licenseNumber);
        driverService.update(driver);
        System.out.println("Driver with id " + id
                + "after changes: " + driverService.get(id));
    }

    private static void showAllManufacturers() {
        List<Manufacturer> manufacturers = manufacturerService.getAll();
        manufacturers.forEach(System.out::println);
    }

    private static void showAllDrivers() {
        List<Driver> drivers = driverService.getAll();
        drivers.forEach(System.out::println);
    }
}
