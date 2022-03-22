package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.service.DriverService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driverVadim = new Driver("Vadim","AE4097");
        driverService.create(driverVadim);
        driverVadim.setLicenseNumber("AE4099");
        driverVadim.setName("Vadimovich");
        driverService.update(driverVadim);
        driverService.delete(driverVadim.getId());
        System.out.println("After " + driverService.getAll());

    }
}
