package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver("William", "307");
        driver = driverService.create(driver);
        System.out.println("Added driver William: " + driverService.get(driver.getId()));
        driver.setLicenseNumber("308");
        driver = driverService.update(driver);
        System.out.println("Updated William license: " + driverService.get(driver.getId()));
        Driver driver1 = new Driver("Daniel", "309");
        driver1 = driverService.create(driver1);
        System.out.println("Two drivers from DB: " + driverService.getAll());
        System.out.println("Successful Daniel deleting from DB: "
                + driverService.delete(driver1.getId()));
        System.out.println("Drivers without Daniel: " + driverService.getAll());
    }
}
