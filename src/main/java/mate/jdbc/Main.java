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
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        System.out.println(manufacturerService.get(16L));
        manufacturerService.delete(16L);
        Driver savedDriverBob = driverService.create(new Driver("Bob", "AB12345"));
        System.out.println(driverService.get(savedDriverBob.getId()));
        Driver driverNastya = new Driver("Nastya", "AB09876");
        Driver savedDriverNastya =
                driverService.getByLicenseNumber(driverNastya.getLicenseNumber());
        savedDriverNastya.setLicenseNumber("BA09876");
        System.out.println(driverService.update(savedDriverNastya));
        driverService.delete(savedDriverNastya.getId());
        System.out.println(driverService.getAll());
        System.out.println(manufacturerService.getAll());
    }
}
