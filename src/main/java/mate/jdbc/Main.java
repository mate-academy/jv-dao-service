package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");
    private static final Manufacturer CREATE_METHOD_MANUFACTURER
            = new Manufacturer("Opel", "Germany");
    private static final Manufacturer UPDATE_METHOD_MANUFACTURER
            = new Manufacturer(2L, "Hyundai", "South Korea");
    private static final Driver CREATE_METHOD_DRIVER
            = new Driver("John", "45345345");
    private static final Driver UPDATE_METHOD_DRIVER
            = new Driver(2L, "Alice", "34343434");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        Manufacturer createdManufacturer = manufacturerService.create(CREATE_METHOD_MANUFACTURER);
        Manufacturer manufacturerById = manufacturerService.get(createdManufacturer.getId());
        List<Manufacturer> allManufacturersList = manufacturerService.getAll();
        Manufacturer updatedManufacturer = manufacturerService.update(UPDATE_METHOD_MANUFACTURER);
        boolean isDeletedManufacturer = manufacturerService.delete(manufacturerById.getId());
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver createdDriver = driverService.create(CREATE_METHOD_DRIVER);
        Driver driverById = driverService.get(createdDriver.getId());
        List<Driver> allDriversList = driverService.getAll();
        Driver updatedDriver = driverService.update(UPDATE_METHOD_DRIVER);
        boolean isDeletedDriver = driverService.delete(driverById.getId());
    }
}
