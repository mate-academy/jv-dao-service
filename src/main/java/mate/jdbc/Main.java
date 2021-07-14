package mate.jdbc;

import java.util.Optional;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

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

        Driver muhamedIii = new Driver("Muhamed II", "1010101");
        driverService.create(muhamedIii);
        System.out.println("Muhamed II before update:");
        System.out.println(muhamedIii.getId());
        System.out.println(muhamedIii.getName());
        System.out.println(muhamedIii.getLicenseNumber());
        muhamedIii = driverService.update(muhamed);
        System.out.println("Muhamed II after update:");
        System.out.println(muhamedIii.getId());
        System.out.println(muhamedIii.getName());
        System.out.println(muhamedIii.getLicenseNumber());
        System.out.println();

        System.out.println(driverService.delete(muhamedIii.getId()));
    }
}
