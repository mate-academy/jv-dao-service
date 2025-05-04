package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        List<Driver> driverList =
                List.of(new Driver("Abhey", "1243"),
                        new Driver("Amar", "7865"),
                        new Driver("Ganesh", "4345"));
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        for (Driver driver : driverList) {
            driverService.create(driver);
        }
        System.out.println(driverService.get(1L));
        System.out.println(driverService.getAll());
        System.out.println(driverService
                .update(new Driver(2L, "New driver", "7777")));
        System.out.println(driverService.delete(2L));
    }
}
