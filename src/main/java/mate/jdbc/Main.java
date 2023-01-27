package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {

    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driverToCreate = new Driver("Pavel", "84029");
        Driver createdDriver = driverService.create(driverToCreate);
        List<Driver> driverList = driverService.getAll();
        Driver receivedDriver = driverService.get(2L);
        Driver driverToUpdate = new Driver(4L, "Julia", "94769");
        Driver updatedDriver = driverService.update(driverToUpdate);
        boolean deletedDriver = driverService.delete(1L);
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturerToCreate = new Manufacturer("Oleg", "Ukraine");
        Manufacturer createdManufacturer = manufacturerService.create(manufacturerToCreate);
        List<Manufacturer> manufacturerList = manufacturerService.getAll();
        Manufacturer receivedManufacturer = manufacturerService.get(2L);
        Manufacturer manufacturerToUpdate = new Manufacturer(5L, "Mark", "Poland");
        Manufacturer updatedManufacturer = manufacturerService.update(manufacturerToUpdate);
        boolean deletedManufacturer = manufacturerService.delete(1L);
    }
}
