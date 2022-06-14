package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {

    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static int id_Driver = 0;

    public static void main(String[] args) {
        final ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        final DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);

        manufacturerService.getAll()
                .forEach(System.out::println);

        driverService.create(getDefaultDriver());
        driverService.create(getDefaultDriver());
        driverService.create(getDefaultDriver());

        driverService.getAll()
                .forEach(System.out::println);

        driverService.update(new Driver(3L, "defoult3", "333"));
        driverService.update(new Driver(2L, "defoult2", "2222"));

        driverService.delete(2L);
    }

    private static Driver getDefaultDriver() {
        Driver driver = new Driver();
        driver.setName("driver^" + id_Driver);
        driver.setLicenseNumber("000" + id_Driver++);
        return driver;
    }
}
