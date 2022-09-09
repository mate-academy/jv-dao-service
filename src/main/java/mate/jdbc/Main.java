package mate.jdbc;

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

        Manufacturer manufacturer1 = new Manufacturer("Apple", "USA");
        manufacturerService.create(manufacturer1);
        Manufacturer manufacturer2 = new Manufacturer("Xiaomi", "China");
        manufacturerService.create(manufacturer2);
        manufacturer1.setName(manufacturer1.getName().toUpperCase());
        manufacturerService.update(manufacturer1);
        manufacturerService.delete(manufacturer2.getId());
        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);

        Driver driver1 = new Driver("Gogi", "AA7951CE");
        driverService.create(driver1);
        Driver driver2 = new Driver("Vahtang", "AE9856BB");
        driverService.create(driver2);
        driver1.setName(driver1.getName().toUpperCase());
        driverService.update(driver1);
        driverService.delete(driver2.getId());
        driverService.getAll().forEach(System.out::println);
    }
}
