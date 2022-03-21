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
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer bmwManufacturer = manufacturerService
                .create(new Manufacturer(null, "BMW", "Germany"));
        System.out.println(bmwManufacturer);
        Manufacturer mercedesManufacturer = manufacturerService
                .create(new Manufacturer(null, "Mercedes", "Germany"));
        System.out.println(mercedesManufacturer);
        Manufacturer fordManufacturer = manufacturerService
                .create(new Manufacturer(null, "FORD", "USA"));
        System.out.println(fordManufacturer);
        manufacturerService.delete(mercedesManufacturer.getId());
        fordManufacturer.setCountry("Japan");
        fordManufacturer.setName("Toyota");
        manufacturerService.update(fordManufacturer);
        System.out.println(manufacturerService.get(fordManufacturer.getId()));
        List<Manufacturer> allManufacturer = manufacturerService.getAll();
        allManufacturer.forEach(System.out::println);
        DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);
        Driver driver0001 = driverService.create(new Driver(null, "Igor", "0001"));
        System.out.println(driver0001);
        Driver driver0002 = driverService.create(new Driver(null, "Alex", "0002"));
        System.out.println(driver0002);
        Driver driver = driverService.get(driver0001.getId());
        System.out.println(driver);
        System.out.println(driverService.delete(driver0001.getId()));
        driver0002.setName("Roman");
        System.out.println(driverService.update(driver0002));
        driverService.getAll().forEach(System.out::println);

    }
}
