package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver bobDriver = new Driver("Bob", "DL8362748");
        driverService.create(bobDriver);
        Long driverIdToFind = 3L;
        Driver founded = driverService.get(driverIdToFind);
        System.out.println(founded);
        List<Driver> drivers = driverService.getAll();
        drivers.forEach(System.out::println);
        founded.setLicenseNumber("DL1111111");
        driverService.update(founded);
        driverService.delete(driverIdToFind);
    }
}
