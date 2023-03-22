package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static DriverService driverService = (DriverService)
            injector.getInstance(DriverService.class);

    public static void main(String[] args) {
        // Create model
        Driver driver = new Driver();
        driver.setName("Bohdan");
        driver.setLicenseNumber("lic0285442_2456cer");
        System.out.println(driverService.create(driver));
        // Read data
        System.out.println(driverService.get(1L));
        System.out.println(driverService.getAll());
        // Update data
        driver.setName("Myhaylo");
        driverService.update(driver);
        System.out.println(driverService.getAll());
        // Delete data
        driverService.delete(1L);
        System.out.println(driverService.getAll());
    }
}
