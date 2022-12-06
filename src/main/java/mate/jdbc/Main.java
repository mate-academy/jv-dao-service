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

        manufacturerService.create(new Manufacturer("Audi", "Germany"));
        manufacturerService.get(1L);
        List<Manufacturer> manufacturers = manufacturerService.getAll();
        for (Manufacturer manufacturer : manufacturers) {
            System.out.println(manufacturer);
        }

        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        Driver driver = new Driver();
        Driver andrewDriver = driverService.create(new Driver("Andrew", "457926"));
        andrewDriver.setLicenseNumber("845985");
        driverService.update(andrewDriver);
        driverService.delete(1L);
        List<Driver> driverList = driverService.getAll();
        for (Driver d : driverList) {
            System.out.println(d);
        }
    }
}
