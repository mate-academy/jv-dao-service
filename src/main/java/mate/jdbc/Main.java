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
        Manufacturer manManufacturer = new Manufacturer("MEN", "Germany");
        Manufacturer createdManufacturer = manufacturerService.create(manManufacturer);
        Manufacturer manufacturerById = manufacturerService.get(createdManufacturer.getId());
        List<Manufacturer> allManufacturersList = manufacturerService.getAll();
        manManufacturer
                = new Manufacturer("Ford", "USA");
        manManufacturer.setId(createdManufacturer.getId());
        Manufacturer updatedManufacturer = manufacturerService.update(manManufacturer);
        boolean isDeletedManufacturer = manufacturerService.delete(manufacturerById.getId());
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driverVlad
                = new Driver("Vled", "45345345");
        Driver createdDriver = driverService.create(driverVlad);
        Driver driverById = driverService.get(createdDriver.getId());
        List<Driver> allDriversList = driverService.getAll();
        driverVlad
                = new Driver("Vlad", "BC57212");
        driverVlad.setId(createdDriver.getId());
        Driver updatedDriver = driverService.update(driverById);
        boolean isDeletedDriver = driverService.delete(driverById.getId());
    }
}
