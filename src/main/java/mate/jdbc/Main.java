package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.services.DriverService;
import mate.jdbc.services.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        Manufacturer opelManufacturer = new Manufacturer("MAN", "Germany");
        Manufacturer createdManufacturer = manufacturerService.create(opelManufacturer);
        Manufacturer manufacturerById = manufacturerService.get(createdManufacturer.getId());
        List<Manufacturer> allManufacturersList = manufacturerService.getAll();
        Manufacturer hyundaiManufacturer
                = new Manufacturer("Ford", "USA");
        hyundaiManufacturer.setId(7L);
        Manufacturer updatedManufacturer = manufacturerService.update(hyundaiManufacturer);
        boolean isDeletedManufacturer = manufacturerService.delete(manufacturerById.getId());
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driverJohn
                = new Driver("John", "45345345");
        Driver createdDriver = driverService.create(driverJohn);
        Driver driverById = driverService.get(createdDriver.getId());
        List<Driver> allDriversList = driverService.getAll();
        Driver driverAlice
                = new Driver("Vlad", "BC57212");
        driverAlice.setId(2L);
        Driver updatedDriver = driverService.update(driverAlice);
        boolean isDeletedDriver = driverService.delete(driverById.getId());
    }
}
