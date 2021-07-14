package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        driverService.create(new Driver("Bob","0000_0000_0000_0001"));
        driverService.create(new Driver("John","0000_0000_0000_0002"));
        driverService.create(new Driver("David","0000_0000_0000_0003"));
        driverService.create(new Driver("Alice","0000_0000_0000_0004"));
        driverService.create(new Driver("Anna","0000_0000_0000_0005"));
        Driver updateDriver = new Driver("Arnold", "SSSS_SSSS_SSSS_SSSS");
        updateDriver.setId(3L);
        driverService.update(updateDriver);
        System.out.println(driverService.get(3L));
        driverService.delete(1L);
        driverService.getAll().forEach(System.out::println);

        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        manufacturerService.create(new Manufacturer("Renault","France"));
        manufacturerService.create(new Manufacturer("Volkswagen","Germany"));
        manufacturerService.create(new Manufacturer("Toyota","Japan"));
        manufacturerService.create(new Manufacturer("Ford","United States"));
        manufacturerService.create(new Manufacturer("Honda","Japan"));
        Manufacturer updateManufacturer = new Manufacturer("Nissan","Japan");
        updateManufacturer.setId(1L);
        manufacturerService.update(updateManufacturer);
        System.out.println(manufacturerService.get(2L));
        manufacturerService.delete(2L);
        manufacturerService.getAll().forEach(System.out::println);
    }
}
