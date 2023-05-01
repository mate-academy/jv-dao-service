package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver(null, "Bob", "A11");
        System.out.println(driverService.create(driver) + " - driver created.");
        System.out.println(driverService.get(driver.getId()) + " - method get Driver executed.");
        driverService.getAll().forEach(System.out::println);
        driver.setName("John");
        driver.setLicenseNumber("B22");
        System.out.println(driverService.update(driver) + " update executed.");
        System.out.println("Deleting is executed = " + driverService.delete(driver.getId()));

    }
}
