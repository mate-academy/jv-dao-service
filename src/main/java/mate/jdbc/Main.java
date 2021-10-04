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
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        Manufacturer opelManufacturer = new Manufacturer("Opel", "Germany");
        Manufacturer createdManufacturer = manufacturerService.create(opelManufacturer);
        Manufacturer manufacturerById = manufacturerService.get(createdManufacturer.getId());
        List<Manufacturer> allManufacturersList = manufacturerService.getAll();
        Manufacturer hyundaiManufacturer
                = new Manufacturer(2L, "Hyundai", "South Korea");
        Manufacturer updatedManufacturer = manufacturerService.update(hyundaiManufacturer);
        boolean isDeletedManufacturer = manufacturerService.delete(manufacturerById.getId());
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driverJohn
                = new Driver("John", "45345345");
        Driver createdDriver = driverService.create(driverJohn);
        Driver driverById = driverService.get(createdDriver.getId());
        List<Driver> allDriversList = driverService.getAll();
        Driver driverAlice
                = new Driver(2L, "Alice", "34343434");
        Driver updatedDriver = driverService.update(driverAlice);
        boolean isDeletedDriver = driverService.delete(driverById.getId());
    }
}
