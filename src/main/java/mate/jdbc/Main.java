package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver("Joe", "109812");
        driverService.create(driver);
        System.out.println(driverService.get(2L));
        driver.setName("Joseph");
        driver.setLicenseNumber("0898721");
        driverService.update(driver);
        Driver deleteDriver = new Driver("DeleteMe", "-1");
        driverService.create(deleteDriver);
        driverService.delete(deleteDriver.getId());
        List<Driver> allDrivers = driverService.getAll();

        for (Driver d: allDrivers) {
            System.out.println(d.toString());
        }
    }
}
