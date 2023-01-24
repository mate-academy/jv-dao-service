package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driverOne = new Driver(null, "One", "1234");
        Driver driverTwo = new Driver(null, "Two", "qwerty");
        Driver driverThree = new Driver(null, "Three", "asd56");
        System.out.println(driverService.create(driverOne));
        System.out.println(driverService.create(driverTwo));
        System.out.println(driverService.create(driverThree));
        driverService.getAll().forEach(System.out::println);
        driverOne.setLicenseNumber("zxc999");
        System.out.println(driverService.update(driverOne));
        System.out.println(driverService.get(driverOne.getId()));
        System.out.println(driverService.delete(driverTwo.getId()));
        driverService.getAll().forEach(System.out::println);
    }
}
