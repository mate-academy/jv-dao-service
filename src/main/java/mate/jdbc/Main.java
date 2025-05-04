package mate.jdbc;

import java.util.NoSuchElementException;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final int LICENSE_NO_LENGTH = 12;
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        System.out.println("******************************************************");
        System.out.println("*****************ManufacturerService******************");
        System.out.println("******************************************************");
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        manufacturerServiceTest(manufacturerService);
        System.out.println("******************************************************");
        System.out.println("********************DriverService*********************");
        System.out.println("******************************************************");
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        driverServiceTest(driverService);
    }

    private static void manufacturerServiceTest(ManufacturerService manufacturerService) {
        //* Create
        for (int i = 0; i < 10; i++) {
            manufacturerService.create(newManufacturer("ZAZ_" + i, "Ukr"));
        }
        //* Read all
        System.out.println("***********CREATE BLOCK RESULTS***********");
        manufacturerService.getAll().stream()
                .forEach(System.out::println);
        //* Delete
        manufacturerService.getAll().stream()
                .filter(m -> m.getId() % 2 != 0)
                .forEach(m -> manufacturerService.delete(m.getId()));
        System.out.println("***********DELETE BLOCK RESULTS***********");
        manufacturerService.getAll().stream()
                .forEach(System.out::println);
        //* Update
        manufacturerService.getAll().stream()
                .map(Main::updateManufacturer)
                .forEach(manufacturerService::update);
        System.out.println("***********UPDATE BLOCK RESULTS***********");
        manufacturerService.getAll().stream()
                .forEach(System.out::println);
        //* Get
        System.out.println("***********READ BLOCK***********");
        for (long id = 0; id < 10; id++) {
            try {
                Manufacturer manufacturer = manufacturerService.get(id);
                System.out.println(manufacturer);
            } catch (NoSuchElementException e) {
                System.out.println(("Manufacturer with Id = " + id + " not found"));
            }
        }
    }

    private static void driverServiceTest(DriverService driverService) {
        //* Create
        for (int i = 0; i < 10; i++) {
            driverService.create(newDriver("Driver_" + i, getLicenseNumber(i)));
        }
        //* Read all
        System.out.println("***********CREATE BLOCK RESULTS***********");
        driverService.getAll().stream()
                .forEach(System.out::println);
        //* Delete
        driverService.getAll().stream()
                .filter(d -> d.getId() % 2 != 0)
                .forEach(d -> driverService.delete(d.getId()));
        System.out.println("***********DELETE BLOCK RESULTS***********");
        driverService.getAll().stream()
                .forEach(System.out::println);
        //* Update
        driverService.getAll().stream()
                .map(Main::updateDriver)
                .forEach(driverService::update);
        System.out.println("***********UPDATE BLOCK RESULTS***********");
        driverService.getAll().stream()
                .forEach(System.out::println);
        //* Get
        System.out.println("***********READ BLOCK***********");
        for (long id = 0; id < 10; id++) {
            try {
                Driver driver = driverService.get(id);
                System.out.println(driver);
            } catch (NoSuchElementException e) {
                System.out.println(("Driver with Id = " + id + " not found"));
            }
        }
    }

    private static Manufacturer newManufacturer(String name, String country) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName(name);
        manufacturer.setCountry(country);
        return manufacturer;
    }

    private static Manufacturer updateManufacturer(Manufacturer manufacturer) {
        manufacturer.setName("ZAZ_" + manufacturer.getId());
        manufacturer.setCountry("Ukraine");
        return manufacturer;
    }

    private static Driver newDriver(String name, String licenseNumber) {
        Driver driver = new Driver();
        driver.setName(name);
        driver.setLicenseNumber(licenseNumber);
        return driver;
    }

    private static Driver updateDriver(Driver driver) {
        driver.setName("Driver_" + driver.getId());
        driver.setLicenseNumber(getLicenseNumber(driver.getId()));
        return driver;
    }

    private static String getLicenseNumber(long number) {
        String numStr = Long.valueOf(number).toString();
        return "0".repeat(LICENSE_NO_LENGTH - numStr.length()) + numStr;
    }
}
