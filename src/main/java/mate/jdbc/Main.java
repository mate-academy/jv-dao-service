package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        manufacturerService.getAll().forEach(System.out::println);

        Driver driver1 = new Driver();
        driver1.setId(2L);
        driver1.setName("Alice");
        driver1.setLicenseNumber("22222");

        Driver driver2 = new Driver();
        driver2.setName("John");
        driver2.setLicenseNumber("33333");

        Driver driver3 = new Driver();
        driver3.setId(4L);
        driver3.setName("Jack");
        driver3.setLicenseNumber("44444");

        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);

        driverService.create(driver1);
        driverService.create(driver2);
        driverService.create(driver3);

        System.out.println(driverService.delete(driver3.getId()));

        Driver driver4 = new Driver();
        driver4.setId(driver1.getId());
        driver4.setName("Alex");
        driver4.setLicenseNumber("55555");
        driverService.update(driver4);

        driverService.getAll().forEach(System.out::println);
    }
}
