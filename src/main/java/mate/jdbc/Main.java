package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        List<Driver> driverList = List.of(
                new Driver("Den", "19875"),
                new Driver("Karl", "20060"),
                new Driver("Kate", "00100"),
                new Driver("Romeo", "66617"));
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        driverList.stream()
                .map(driverService::create)
                .forEach(System.out::println);
        System.out.println(driverService.getAll());
        List<Driver> allDriversFromDB = driverService.getAll();
        System.out.println(allDriversFromDB);
    }
}
