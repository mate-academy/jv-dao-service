package mate.jdbc;

import java.util.stream.IntStream;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final String TEST_DRIVER_NAME = "DriverName";
    private static final String TEST_DRIVER_LICENSE = "LN2012102";
    private static final String TEST_MANUFACTURER_NAME = "ManufacturerName";
    private static final String TEST_MANUFACTURER_COUNTRY = "SomeCountry";
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        testDriverService();
        testManufacturerService();
    }

    private static void testDriverService() {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver(null, TEST_DRIVER_NAME, TEST_DRIVER_LICENSE);
        System.out.println("Driver created: " + driverService.create(driver));
        System.out.println("Same driver, but accessed through get: " + driverService.get(driver.getId()));
        driver.setLicenseNumber(driver.getLicenseNumber() + "_updated");
        driver.setName(driver.getName() + "_updated");
        System.out.println("Driver updated: " + driverService.update(driver));
        if (driverService.delete(driver.getId())) {
            System.out.println("Driver deleted");
        }
        IntStream.range(0, 10)
                .mapToObj(i -> new Driver(null, "Name#" + i, "LN#" + i))
                .forEach(driverService::create);
        driverService.getAll().forEach(System.out::println);
    }

    private static void testManufacturerService() {
        ManufacturerService manufacturerService = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer(null, TEST_MANUFACTURER_NAME, TEST_MANUFACTURER_COUNTRY);
        System.out.println("Manufacturer created: " + manufacturerService.create(manufacturer));
        System.out.println("Same manufacturer, but accessed through get: "
                + manufacturerService.get(manufacturer.getId()));
        manufacturer.setCountry(manufacturer.getCountry() + "_updated");
        manufacturer.setName(manufacturer.getName() + "_updated");
        System.out.println("Manufacturer updated: " + manufacturerService.update(manufacturer));
        if (manufacturerService.delete(manufacturer.getId())) {
            System.out.println("Manufacturer deleted");
        }
        IntStream.range(0, 10)
                .mapToObj(i -> new Manufacturer(null, "Name#" + i, "Country#" + i))
                .forEach(manufacturerService::create);
        manufacturerService.getAll().forEach(System.out::println);
    }
}
