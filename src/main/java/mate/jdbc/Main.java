package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector INJECTOR = Injector.getInstance("mate");

    public static void main(String[] args) {
        DriverService driverService
                = (DriverService) INJECTOR.getInstance(DriverService.class);
        Driver driver = new Driver();
        driver.setName("John");
        driver.setLicenseNumber("12345");
        driver = driverService.create(driver);
        System.out.println(driver);

        driver.setName("Ben");
        driver.setLicenseNumber("67789");
        Driver updatedDriver = driverService.update(driver);
        System.out.println(updatedDriver);

        final long test_id = updatedDriver.getId();

        Driver retrievedDriver = driverService.get(test_id);
        System.out.println(retrievedDriver);

        System.out.println(driverService.delete(test_id));

        List<Driver> drivers = driverService.getAll();
        drivers.forEach(System.out::println);
    }
}
