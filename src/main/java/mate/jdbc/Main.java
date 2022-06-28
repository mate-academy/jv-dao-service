package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.setName("Matt");
        driver.setLicenseNumber("Matt#7878");

        DriverService dao = (DriverService) injector.getInstance(DriverService.class);
        System.out.println("Create a driver");
        System.out.println(dao.create(driver));

        System.out.println("\nAll drivers");
        dao.getAll().forEach(System.out::println);

        System.out.println("\nUpdate a driver");
        driver.setName("Steve");
        System.out.println(dao.update(driver));

        System.out.println("\nDriver by ID");
        System.out.println(dao.get(driver.getId()));

        System.out.println("\nDelete a driver");
        System.out.println(dao.delete(driver.getId()));
    }
}
