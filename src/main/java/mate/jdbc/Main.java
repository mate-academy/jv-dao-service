package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        Driver driverJohn = new Driver(null, "John", "1234");
        Driver driverNick = new Driver(null, "Nick", "1243");
        Driver driverUpdate = new Driver(2L, "Update", "2134");
        Driver driver = driverService.create(driverJohn);
        Driver driver1 = driverService.create(driverNick);
        Driver receivedDriver = driverService.get(1L);
        Driver update1 = driverService.update(driverUpdate);
        boolean delete = driverService.delete(2L);
        Manufacturer carAudi = new Manufacturer(null, "Audi", "Germany");
        Manufacturer carMercedes = new Manufacturer(null, "Mercedes", "Germany");
        Manufacturer carUpdate = new Manufacturer(2L, "Toyota", "Japan");
        Manufacturer manufacturer = manufacturerService.create(carAudi);
        Manufacturer manufacturer1 = manufacturerService.create(carMercedes);
        Manufacturer receivedManufacturer = manufacturerService.get(2L);
        Manufacturer update = manufacturerService.update(carUpdate);
        manufacturerService.delete(2L);
    }
}
