package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.services.Service;

public class Main {
    public static void main(String[] args) {
        Injector injector = Injector.getInstance("mate.jdbc");

        Service<Driver> driverService = (Service<Driver>) injector.getInstance(Service.class);

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
