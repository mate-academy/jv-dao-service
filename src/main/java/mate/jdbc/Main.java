package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver billDriver = new Driver("Bob", "114789");
        System.out.println("*********Create Driver***********");
        driverService.create(billDriver);
        driverService.getAll().forEach(System.out::println);
        System.out.println("*********Delete Driver***********");
        driverService.delete(13L);
        driverService.getAll().forEach(System.out::println);
        Driver driver = driverService.get(12L);
        driver.setName("John");
        System.out.println("*********Update Driver***********");
        driverService.update(driver);
        driverService.getAll().forEach(System.out::println);
    }
}
