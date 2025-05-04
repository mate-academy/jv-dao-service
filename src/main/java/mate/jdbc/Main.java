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
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver firstDriver = new Driver(null, "Bob", "135970");
        driverService.create(firstDriver);
        Driver secondDriver = new Driver(null, "Alex", "246080");
        driverService.create(secondDriver);
        Driver thirdDriver = new Driver(null, "Bogdan", "123789");
        driverService.create(thirdDriver);
        thirdDriver.setName("Alice");
        thirdDriver.setLicenseNumber("0102789");
        driverService.update(thirdDriver);
        List<Driver> driverList = driverService.getAll();
        driverList.forEach(System.out::println);
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer firstManufacturer = new Manufacturer(null, "Tesla", "USA");
        manufacturerService.create(firstManufacturer);
        Manufacturer secondManufacturer = new Manufacturer(null, "Renault", "FRANCE");
        manufacturerService.create(secondManufacturer);
        Manufacturer thirdManufacturer = new Manufacturer(null, "Hyundai", "KOREA");
        manufacturerService.create(thirdManufacturer);
        firstManufacturer.setName("Daewoo");
        firstManufacturer.setCountry("Ukraine");
        manufacturerService.update(firstManufacturer);
        List<Manufacturer> manufacturerList = manufacturerService.getAll();
        manufacturerList.forEach(System.out::println);

    }
}
