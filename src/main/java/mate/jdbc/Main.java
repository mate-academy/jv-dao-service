package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Manufacturer manufacturer = new Manufacturer("Vito", "USA");
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        manufacturerService.create(manufacturer);
        manufacturerService.get(manufacturer.getId());
        System.out.println(manufacturerService.getAll());
        manufacturerService.update(manufacturer);
        manufacturerService.delete(manufacturer.getId());

        Driver drive = new Driver("Vito", "12350");
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        driverService.create(drive);
        driverService.get(drive.getId());
        System.out.println(driverService.getAll());
        driverService.update(drive);
        driverService.delete(manufacturer.getId());

    }
}
