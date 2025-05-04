package mate.jdbc;

import java.util.stream.Stream;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        Driver driver = new Driver("Jane", "qwerty007");
        driverService.create(driver);
        Stream.of(driverService.getAll()).forEach(System.out::println);
        driver.setName("Mike");
        driver.setLicenseNumber("qwerty003");
        driverService.update(driver);
        System.out.println(driverService.get(driver.getId()));
        driverService.delete(driver.getId());

        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer("Volvo", "Germany");
        manufacturerService.create(manufacturer);
        Stream.of(manufacturerService.getAll()).forEach(System.out::println);
        manufacturer.setName("Lexus");
        manufacturer.setCountry("Japan");
        manufacturerService.update(manufacturer);
        System.out.println(manufacturerService.get(manufacturer.getId()));
        manufacturerService.delete(manufacturer.getId());
        System.out.println(manufacturerService.get(manufacturer.getId()));
    }
}
