package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);

        System.out.println("ManufacturerService:");
        Manufacturer firstManufacturer = new Manufacturer(null, "Volkswagen", "Germany");
        Manufacturer secondManufacturer = new Manufacturer(null, "Ferrari", "Italy");

        manufacturerService.create(firstManufacturer);
        manufacturerService.create(secondManufacturer);
        System.out.println(manufacturerService.get(firstManufacturer.getId()));
        manufacturerService.getAll().forEach(System.out::println);

        firstManufacturer.setName("BMW");
        manufacturerService.update(firstManufacturer);
        manufacturerService.delete(secondManufacturer.getId());

        DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);

        System.out.println("DriverService:");
        Driver firstDriver = new Driver(null,"Thomas Schmidt", "AA1234");
        Driver secondDriver = new Driver(null, "Taras Melnyk", "BB2345");

        driverService.create(firstDriver);
        driverService.create(secondDriver);
        System.out.println(driverService.get(firstDriver.getId()));
        driverService.getAll().forEach(System.out::println);

        firstDriver.setName("Hans Schneider");
        driverService.update(firstDriver);
        driverService.delete(secondDriver.getId());
    }
}
