package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);

        manufacturerService.get(15L);
        manufacturerService.create(new Manufacturer("Lada", "Ukraine"));
        manufacturerService.getAll();
        Manufacturer manufacturerToUpdate = new Manufacturer("Porsche", "USA");
        manufacturerToUpdate.setId(13L);
        manufacturerService.update(manufacturerToUpdate);
        manufacturerService.delete(16L);

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        driverService.create(new Driver("driver1", "789"));
        driverService.get(2L);
        driverService.getAll();
        Driver driverToUpdate = new Driver("driver2", "098");
        driverToUpdate.setId(2L);
        driverService.update(driverToUpdate);
        driverService.delete(3L);
    }
}
