package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver alice = new Driver(4L,"Alice", "127");
        Driver den = new Driver("Den", "128");
        driverService.create(den);
        driverService.update(alice);
        driverService.delete(6L);
        driverService.getAll().forEach(System.out::println);
        System.out.println(driverService.get(3L));
        // test your code here
    }
}
