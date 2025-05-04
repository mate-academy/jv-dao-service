package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {

    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static int driverId = 0;

    public static void main(String[] args) {
        final ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        final DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);

        manufacturerService.getAll()
                .forEach(System.out::println);

        Driver first = driverService.create(getDefaultDriver());
        Driver secont = driverService.create(getDefaultDriver());
        Driver third = driverService.create(getDefaultDriver());
        driverService.getAll()
                .forEach(System.out::println);
        driverService.update(new Driver(third.getId(), "defoult3", "333"));
        driverService.update(new Driver(secont.getId(), "defoult2", "2222"));
        driverService.delete(secont.getId());
    }

    private static Driver getDefaultDriver() {
        Driver driver = new Driver();
        driver.setName("driver^" + driverId);
        driver.setLicenseNumber("000" + driverId++);
        return driver;
    }
}
