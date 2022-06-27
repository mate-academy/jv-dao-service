package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);

        Driver driverOne = new Driver();
        driverOne.setName("Super man");
        driverOne.setLicenseNumber("sm1008us");
        driverService.create(driverOne);

        Driver driverSecond = new Driver();
        driverSecond.setName("John Bambino");
        driverSecond.setLicenseNumber("jb1916it");
        driverService.create(driverSecond);

        System.out.println(driverService.getAll());

        driverSecond.setName("Silvester");
        driverSecond.setLicenseNumber("s1234ss");
        driverService.update(driverSecond);
        System.out.println(driverService.getAll());

        driverService.delete(driverSecond.getId());
        System.out.println(driverService.getAll());

        System.out.println(driverService.get(driverOne.getId()));
    }
}
