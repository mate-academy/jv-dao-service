package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.DriverServiceImpl;

import java.util.Optional;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver arsen = new Driver("Arsen", "2281337");
        driverService.create(arsen);

        Driver sergey = new Driver("Sergey", "4347332");
        driverService.create(sergey);

        Driver andrew = new Driver("Andrew", "7777777");
        driverService.create(andrew);

        Driver muhamed = new Driver("Muhamed", "0101010");
        driverService.create(muhamed);

        Optional<Driver> fourthRow = Optional.ofNullable(driverService.get(4L));
        System.out.println(fourthRow);

        System.out.println();

        driverService.getAll().forEach(System.out::println);

        System.out.println();

        Driver muhamed_ii = new Driver("Muhamed II", "1010101");
        driverService.create(muhamed_ii);
        System.out.println("Muhamed II before update:");
        System.out.println(muhamed_ii.getId());
        System.out.println(muhamed_ii.getName());
        System.out.println(muhamed_ii.getLicenseNumber());
        muhamed_ii = driverService.update(muhamed);
        System.out.println("Muhamed II after update:");
        System.out.println(muhamed_ii.getId());
        System.out.println(muhamed_ii.getName());
        System.out.println(muhamed_ii.getLicenseNumber());

        System.out.println();

        System.out.println(driverService.delete(muhamed_ii.getId()));

    }
}
