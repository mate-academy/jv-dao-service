package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final ManufacturerService manufacturerService =
            (ManufacturerService) injector.getInstance(ManufacturerService.class);
    private static final DriverService driverService =
            (DriverService) injector.getInstance(DriverService.class);

    public static void main(String[] args) {
        //Driver driver = new Driver();
        //driver.setName("Aaaaaa");
        //driver.setLicenseNumber("001122");
        //createDriver(driver);
        //createDriverManually("NewDriver", "000000");
        //updateDriverById(3L, "Pupkin", "789456");
        //deleteDriverLineById(4L);
        //getDriverById(3L);
        readAllLines();
    }

    // CREATE CREATE CREATE CREATE CREATE CREATE CREATE CREATE CREATE CREATE CREATE
    // create manufacturer (add new line)
    private static void createDriver(Driver driver) {
        driverService.create(driver);
    }

    // create manufacturer manually
    private static void createDriverManually(String name, String licenseNumber) {
        Driver driver = new Driver();
        driver.setName(name);
        driver.setLicenseNumber(licenseNumber);
        driverService.create(driver);
    }

    // READ READ READ READ READ READ READ READ READ READ READ READ READ READ READ
    // display of all active positions
    private static void readAllLines() {
        driverService.getAll().forEach(System.out::println);
    }

    // display active position by its id
    private static void getDriverById(long id) {
        System.out.println(driverService.get(id));
    }

    // UPDATE UPDATE UPDATE UPDATE UPDATE UPDATE UPDATE UPDATE UPDATE UPDATE UPDATE
    // update by id
    private static void updateDriverById(Long id, String name, String licenseNumber) {
        Driver driver = driverService.get(id);
        driver.setName(name);
        driver.setLicenseNumber(licenseNumber);
        driverService.update(driver);
    }

    // DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE DELETE
    // delete manufacturer by id
    private static void deleteDriverLineById(Long id) {
        driverService.delete(id);
    }
}
