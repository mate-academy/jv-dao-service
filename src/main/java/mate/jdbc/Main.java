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
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        driverService.create(new Driver("Cheburashka", "040AC"));
        driverService.create(new Driver("Gena", "040AC"));
        driverService.create(new Driver("Shapoklyak", "040AC"));
        List<Driver> drivers = driverService.getAll();
        driverService.get(3L);
        Driver genaUpdated = new Driver("Gena", "030AC");
        genaUpdated.setId(2L);
        driverService.update(genaUpdated);
        genaUpdated.setLicenseNumber("023AC");
        driverService.update(genaUpdated);
        System.out.println(driverService.get(2L));
        driverService.create(new Driver("Unnamed", "Unknown"));
        System.out.println(driverService.delete(4L));
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        manufacturerService.create(new Manufacturer("Cheburashka", "USSR"));
        manufacturerService.create(new Manufacturer("Gena", "USSR"));
        manufacturerService.create(new Manufacturer("Shapoklyak", "USSR"));
        List<Manufacturer> manufacturers = manufacturerService.getAll();
        driverService.get(3L);
        Manufacturer genaNew = new Manufacturer("Gena", "Russia");
        genaNew.setId(2L);
        manufacturerService.update(genaNew);
        genaNew.setCountry("USSR");
        manufacturerService.update(genaNew);
        System.out.println(manufacturerService.get(3L));
        manufacturerService.create(new Manufacturer("Unnamed", "Unknown"));
        System.out.println(manufacturerService.delete(4L));
    }
}
