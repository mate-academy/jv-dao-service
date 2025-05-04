package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final DriverService driverService;
    private static final ManufacturerService manufacturerService;
    private static final String FIRST_MANUFACTURER_NAME = "Company";
    private static final String SECOND_MANUFACTURER_NAME = "Second Company";
    private static final String FIRST_MANUFACTURER_COUNTRY = "Ukraine";
    private static final String SECOND_MANUFACTURER_COUNTRY = "Also Ukraine";
    private static final String NEW_MANUFACTURER_COUNTRY = "Exactly Ukraine";
    private static final String FIRST_DRIVER_NAME = "Bob";
    private static final String SECOND_DRIVER_NAME = "Alice";
    private static final String FIRST_DRIVER_LICENSE_NUMBER = "1234";
    private static final String SECOND_DRIVER_LICENSE_NUMBER = "5678";
    private static final String NEW_DRIVER_LICENSE_NUMBER = "8765";

    static {
        driverService = (DriverService) injector.getInstance(DriverService.class);
        manufacturerService = (ManufacturerService) injector.getInstance(ManufacturerService.class);
    }

    public static void main(String[] args) {
        Manufacturer manufacturer = new Manufacturer(FIRST_MANUFACTURER_NAME,
                FIRST_MANUFACTURER_COUNTRY);
        Manufacturer secondManufacturer = new Manufacturer(SECOND_MANUFACTURER_NAME,
                SECOND_MANUFACTURER_COUNTRY);
        manufacturer = manufacturerService.create(manufacturer);
        secondManufacturer = manufacturerService.create(secondManufacturer);
        System.out.println("Table manufacturers before update and delete:");
        manufacturerService.getAll().forEach(System.out::println);
        manufacturerService.delete(manufacturer.getId());
        secondManufacturer.setCountry(NEW_MANUFACTURER_COUNTRY);
        manufacturerService.update(secondManufacturer);
        System.out.println("SecondManufacturer after update: "
                + manufacturerService.get(secondManufacturer.getId()));

        Driver driver = new Driver(FIRST_DRIVER_NAME, FIRST_DRIVER_LICENSE_NUMBER);
        Driver secondDriver = new Driver(SECOND_DRIVER_NAME, SECOND_DRIVER_LICENSE_NUMBER);
        driver = driverService.create(driver);
        secondDriver = driverService.create(secondDriver);
        System.out.println("Table drivers before update and delete:");
        driverService.getAll().forEach(System.out::println);
        driverService.delete(driver.getId());
        secondDriver.setLicenseNumber(NEW_DRIVER_LICENSE_NUMBER);
        driverService.update(secondDriver);
        System.out.println("Alice after update: "
                + driverService.get(secondDriver.getId()));
    }
}
