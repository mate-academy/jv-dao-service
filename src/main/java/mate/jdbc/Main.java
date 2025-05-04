package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);

        List<Manufacturer> manufacturers = manufacturerService.getAll();
        for (Manufacturer manufacturer : manufacturers) {
            System.out.println(manufacturer);
        }

        Driver driver = new Driver();
        driver.setName("Anna");
        driver.setLicenseNumber("56483");
        driver.setId(3L);

        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);

        driverService.update(driver);
        driverService.delete(2L);
        List<Driver> driverList = driverService.getAll();
        for (Driver d : driverList) {
            System.out.println(d);
        }
    }
}
