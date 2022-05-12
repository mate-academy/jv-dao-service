package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);
        Driver firstDriver = new Driver(null, "Yaya", "123123");
        Driver secondDriver = new Driver(null, "Neyaya", "321321");
        driverService.create(firstDriver);
        driverService.create(secondDriver);
        firstDriver.setName("Nene");
        driverService.update(firstDriver);
        System.out.println(driverService.get(firstDriver.getId()));
        driverService.delete(firstDriver.getId());
        driverService.getAll().forEach(System.out::println);

        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer firstManufacturer = new Manufacturer(null, "Car", "Country");
        Manufacturer secondManufacturer = new Manufacturer(null, "Necar", "Necountry");
        manufacturerService.create(firstManufacturer);
        manufacturerService.create(secondManufacturer);
        firstManufacturer.setName("Kalyaska");
        manufacturerService.update(firstManufacturer);
        System.out.println(manufacturerService.get(firstManufacturer.getId()));
        manufacturerService.delete(firstManufacturer.getId());
        manufacturerService.getAll().forEach(System.out::println);
    }
}
