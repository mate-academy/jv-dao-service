package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);

        Driver driver = new Driver(1L, "Bogdan", "1090");
        Driver updatedDriver = new Driver(1L, "Dasha", "1499");
        driverService.getAll();
        driverService.delete(2L);
        driverService.update(updatedDriver);
        System.out.println(driverService.getAll());
    }
}
