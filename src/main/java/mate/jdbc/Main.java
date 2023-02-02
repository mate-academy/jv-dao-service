package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector =
            Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Driver driverFirst = new Driver();
        Driver driverSecond = new Driver();
        driverFirst.setName("John");
        driverFirst.setLicenseNumber("ua12311");
        driverSecond.setName("Billy");
        driverSecond.setLicenseNumber("ua76135");
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver createDriverFirst = driverService.create(driverFirst);
        Driver createDriverSecond = driverService.create(driverSecond);
        Driver updateDriverFirst = driverService.update(createDriverFirst);
        Driver updateDriverSecond = driverService.update(createDriverSecond);
        driverService.delete(updateDriverSecond.getId());
        List<Driver> driverList = driverService.getAll();
        driverList.forEach(System.out::println);
    }
}
