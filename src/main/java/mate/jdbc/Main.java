package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driverFirst = new Driver("Sasha", "12345");
        Driver driverSecond = new Driver("Petro", "67890");
        Driver driverThird = new Driver("Vasia", "34567");

        driverFirst = driverService.create(driverFirst);
        driverSecond = driverService.create(driverSecond);
        driverThird = driverService.create(driverThird);

        System.out.println(driverService.get(3L));

        System.out.println(driverService.getAll());

        driverFirst.setLicenseNumber("54321");
        System.out.println(driverService.update(driverFirst));

        System.out.println(driverService.delete(2L));
    }
}
