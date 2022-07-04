package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    public static void main(String[] args) {
        Injector injector = Injector.getInstance("mate.jdbc");
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver(null, "Karl", "1421421");
        System.out.println(driverService.create(driver));
        driverService.getAll()
                .stream()
                .forEach(System.out::println);
        System.out.println(driverService.get(2L));
        driverService.delete(5L);
        driverService.create(new Driver(null, "Melisa", "21121"));
        driverService.update(new Driver(6L, "Mel", "0000"));

    }
}
