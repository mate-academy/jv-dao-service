package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final long BAD_DRIVER_ID = 0L;

    public static void main(String[] args) {
        final DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver firstDriver = new Driver();

        System.out.println("Create: " + "- ".repeat(10));
        firstDriver.setName("Bob");
        firstDriver.setLicenseNumber("911");
        firstDriver = driverService.create(firstDriver);
        System.out.println(firstDriver);

        System.out.println("Update: " + "- ".repeat(10));
        String oldLicenseNumber = firstDriver.getLicenseNumber();
        firstDriver.setLicenseNumber(oldLicenseNumber + "121");
        firstDriver = driverService.update(firstDriver);
        System.out.println(firstDriver);

        System.out.println("Get: " + "- ".repeat(10));
        Driver driver = driverService.get(firstDriver.getId());
        System.out.println(driver);

        System.out.println("Delete: " + "- ".repeat(10));
        System.out.println(driverService.delete(driver.getId()));

        System.out.println("GetAll: " + "- ".repeat(10));
        driverService.getAll().forEach(System.out::println);

        System.out.println("Get exception: " + "- ".repeat(10));
        driverService.get(BAD_DRIVER_ID);
    }
}
