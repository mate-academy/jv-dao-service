package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver[] drivers = {
                driverService.create(new Driver("Daniel", "KD123456")),
                driverService.create(new Driver("Andrew", "KD654321")),
                driverService.create(new Driver("Vlada", "BV123456")),
                driverService.create(new Driver("Giza", "GA654321"))
        };
        driverService.getAll().forEach(System.out::println);
        drivers[0].setName("Daniel Kuruch");
        driverService.update(drivers[0]);
        driverService.getAll().forEach(System.out::println);
        driverService.delete(drivers[0].getId());
        driverService.delete(drivers[1].getId());
        driverService.delete(drivers[2].getId());
        driverService.delete(drivers[3].getId());
    }
}
