package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    public static void main(String[] args) {
        Injector injector = Injector.getInstance("mate.jdbc");
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);

        Manufacturer manufacturer = new Manufacturer(1L, "BMW", "Germany");
        Driver driver = new Driver(1L,"Denys","EC-456789");

        manufacturerService.create(manufacturer);
        System.out.println("service.getAll() = " + manufacturerService.getAll());

        driverService.create(driver);
        System.out.println("driverService.getAll() = " + driverService.getAll());
    }
}
