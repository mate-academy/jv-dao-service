package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        manufacturerService.getAll().forEach(System.out::println);
        Manufacturer manufacturer = new Manufacturer("Nissan", "Japan");
        manufacturerService.create(manufacturer);
        manufacturer = new Manufacturer("Jeep", "Usa");
        manufacturer = manufacturerService.create(manufacturer);
        System.out.println(manufacturerService.get(manufacturer.getId()).toString());
        manufacturer.setCountry(manufacturer.getCountry().toUpperCase());
        System.out.println(manufacturerService.update(manufacturer).toString());
        manufacturerService.delete(manufacturer.getId());

        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        driverService.getAll().forEach(System.out::println);
        Driver driver = new Driver(null, "Maks", "UA1111");
        driverService.create(driver);
        driver = new Driver(null, "Masha", "UA2222");
        driver = driverService.create(driver);
        System.out.println(driverService.get(driver.getId()).toString());
        driver.setName(driver.getName().toUpperCase());
        System.out.println(driverService.update(driver).toString());
        driverService.delete(driver.getId());
    }
}
