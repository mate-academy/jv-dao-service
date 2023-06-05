package mate.jdbc;

import java.util.List;
import java.util.Optional;
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
        manufacturerService.create(manufacturerBmw);

        Optional<Manufacturer> manufacturer = manufacturerService.get(7L);
        manufacturer.ifPresent(System.out::println);

        List<Manufacturer> allManufacturers = manufacturerService.getAll();
        allManufacturers.forEach(System.out::println);

        Manufacturer manufacturerZazUpdate = new Manufacturer(8L, "Lanos", "Ukraine");
        System.out.println(manufacturerService.update(manufacturerZazUpdate));

        System.out.println(manufacturerService.delete(11L));

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver driverVitaliy = new Driver("Vitaliy", "0122567");
        driverService.create(driverVitaliy);

        Optional<Driver> driver = driverService.get(2L);
        driver.ifPresent(System.out::println);

        List<Driver> allDrivers = driverService.getAll();
        allDrivers.forEach(System.out::println);

        Driver updateDriverBob = new Driver(1L, "Bob", "1234567");
        System.out.println(driverService.update(updateDriverBob));

        System.out.println(driverService.delete(2L));
    }
}
