package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver();
        driverService.getAll().forEach(System.out::println);
        driver.setName("Petro Poroshenko");
        driver.setLicenseNumber("7777777");
        driverService.create(driver);
        Driver driver1 = driverService.get(1L);
        System.out.println(driver1);
        driverService.getAll().forEach(System.out::println);
        driver.setName("Petro Poroshenko Chocolate King");
        driverService.update(driver);
        driverService.getAll().forEach(System.out::println);
        driverService.delete(1L);
        driverService.getAll().forEach(System.out::println);
    }
}
