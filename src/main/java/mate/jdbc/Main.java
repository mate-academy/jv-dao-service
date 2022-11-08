package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.services.GenericService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        GenericService<Driver> driverService =
                (GenericService<Driver>) injector.getInstance(GenericService.class);

        Driver driver = new Driver();
        driver.setName("Bob");
        driver.setLicenseNumber("12345");

        Driver driverInDb = driverService.create(driver);
        System.out.println("Add driver to db and get id " + driverInDb.getId());

        driverInDb.setName("Alex");
        System.out.println("Rename Bob in db to  " + driverService.update(driverInDb).getName());

        System.out.println("Remove those driver from db: "
                + driverService.delete(driverInDb.getId()));

        System.out.println("Now in db: ");
        driverService.getALl().forEach(System.out::println);
    }
}
