package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        Driver driver = new Driver();
        driver.setName("Lili");
        driver.setLicenseNumber("mn2345");
        driverService.create(driver);
        driverService.update(new Driver(6L, "Liliya", "nn8900"));
        driverService.delete(5L);
        driverService.getAll().forEach(System.out::println);
        System.out.println(driverService.get(3L));
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        manufacturerService.getAll().forEach(System.out::println);
    }
}
