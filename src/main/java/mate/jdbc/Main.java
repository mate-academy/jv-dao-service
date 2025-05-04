package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);

        Driver alice = new Driver("Alice","S43215678");
        Driver bob = new Driver("Bob","S12348765");
        Driver jon = new Driver("Jon","S45671287");
        driverService.create(alice);
        driverService.create(bob);
        driverService.create(jon);

        Driver bobnewLisence = new Driver(2L,"Bob","S99887766");
        driverService.update(bobnewLisence);

        System.out.println(driverService.get(3L));

        System.out.println(driverService.delete(4L));

        driverService.getAll().forEach(System.out::println);
    }
}
