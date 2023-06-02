package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.setName("Ivan");
        driver.setLicenseNumber("1234567");

        Driver updated = new Driver();
        updated.setId(5L);
        updated.setName("Roman");
        updated.setLicenseNumber("987654321");
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        //Driver create = driverService.create(driver);
        //System.out.println(create);
        //System.out.println(driverService.get(4L));
        //System.out.println(driverService.update(updated));
        System.out.println(driverService.delete(11L));
        driverService.getAll().forEach(System.out::println);
    }
}
