package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        // test your code here
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);

        Manufacturer manufacturer = new Manufacturer(35L,"Scania","Sweden");
        manufacturerService.getAll().forEach(System.out::println);

        Driver driver = new Driver(3L,"Nigel Mansell", "00000003");
        driverService.getAll().forEach(System.out::println);
    }
}
