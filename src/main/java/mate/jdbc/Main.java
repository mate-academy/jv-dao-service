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
        driver1.setName("Johnny Depp");
        driver1.setLicenseNumber("co678ol");
        driverService.create(driver1);

        Driver driver2 = new Driver();
        driver2.setName("Amber Heard");
        driver2.setLicenseNumber("bi648sh");
        driverService.create(driver2);

        System.out.println(driverService.getAll());

        driver2.setName("Amber Goat");
        driver2.setLicenseNumber("st45ill9445bi648sh");
        driverService.update(driver2);
        System.out.println(driverService.getAll());

        driverService.delete(driver2.getId());
        System.out.println(driverService.getAll());

        System.out.println(driverService.get(driver1.getId()));
        System.out.println(driverService.get(20L));
    }
}
