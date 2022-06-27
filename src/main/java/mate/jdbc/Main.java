package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);

        Driver driver1 = new Driver();
        driver1.setName("Super man");
        driver1.setLicenseNumber("sm1008us");
        driverService.create(driver1);

        Driver driver2 = new Driver();
        driver2.setName("John Bambino");
        driver2.setLicenseNumber("jb1916it");
        driverService.create(driver2);

        System.out.println(driverService.getAll());

        driver2.setName("Silvester");
        driver2.setLicenseNumber("s1234ss");
        driverService.update(driver2);
        System.out.println(driverService.getAll());

        driverService.delete(driver2.getId());
        System.out.println(driverService.getAll());

        System.out.println(driverService.get(driver1.getId()));
    }
}
