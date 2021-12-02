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
        ManufacturerService manufacturerService =
                 (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer czechManufacturer =
                new Manufacturer("Skoda", "Czech");
        manufacturerService.create(czechManufacturer);
        System.out.println(manufacturerService.get(czechManufacturer.getId()));
        czechManufacturer.setName("Czech republic");
        System.out.println(manufacturerService.update(czechManufacturer));
        manufacturerService.delete(czechManufacturer.getId());
        List<Manufacturer> manufacturers = manufacturerService.getAll();
        manufacturers.forEach(System.out::println);

        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver ivanDriver = new Driver("Ivan", "DL248163264");
        driverService.create(ivanDriver);
        System.out.println(driverService.get(ivanDriver.getId()));
        ivanDriver.setLicenseNumber("DL1234567890");
        driverService.update(ivanDriver);
        driverService.delete(ivanDriver.getId());
        List<Driver> drivers = driverService.getAll();
        drivers.forEach(System.out::println);
    }
}
