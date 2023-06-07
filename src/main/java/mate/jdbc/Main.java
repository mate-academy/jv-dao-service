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
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        Manufacturer manufacturerBmw = new Manufacturer("BMW", "Germany");
        Manufacturer manufacturer = manufacturerService.create(manufacturerBmw);

        System.out.println(manufacturerService.get(manufacturerBmw.getId()));

        List<Manufacturer> allManufacturers = manufacturerService.getAll();
        allManufacturers.forEach(System.out::println);

        Manufacturer manufacturerZazUpdate = new Manufacturer(manufacturer.getId(),
                "Lanos", "Ukraine");
        System.out.println(manufacturerService.update(manufacturerZazUpdate));

        System.out.println(manufacturerService.delete(manufacturerBmw.getId()));

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driverVitaliy = new Driver("Vitaliy", "0122567");
        Driver driver = driverService.create(driverVitaliy);

        System.out.println(driverService.get(driverVitaliy.getId()));

        List<Driver> allDrivers = driverService.getAll();
        allDrivers.forEach(System.out::println);

        Driver updateDriverBob = new Driver(driver.getId(), "Bob", "1234567");
        System.out.println(driverService.update(updateDriverBob));

        System.out.println(driverService.delete(driverVitaliy.getId()));
    }
}
