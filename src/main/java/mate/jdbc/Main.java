package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);
        Driver firstDriver = new Driver(null, "Dima", "11111");
        Driver secondDriver = new Driver(null, "Ivan", "22222");
        driverService.create(firstDriver);
        driverService.create(secondDriver);
        firstDriver.setName("Denis");
        driverService.update(firstDriver);
        System.out.println(driverService.get(secondDriver.getId()));
        driverService.delete(secondDriver.getId());
        driverService.getAll().forEach(System.out::println);
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer firstManufacturer = new Manufacturer(null, "Volkswagen", "Germany");
        Manufacturer secondManufacturer = new Manufacturer(null, "Kia", "South Korea");
        manufacturerService.create(firstManufacturer);
        manufacturerService.create(secondManufacturer);
        secondManufacturer.setName("KIA");
        manufacturerService.update(secondManufacturer);
        System.out.println(manufacturerService.get(firstManufacturer.getId()));
        manufacturerService.delete(firstManufacturer.getId());
        manufacturerService.getAll().forEach(System.out::println);
    }
}
