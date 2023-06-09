package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer("Mazda", "Japan");
        System.out.println(manufacturerService.create(manufacturer));
        System.out.println(manufacturerService.get(manufacturer.getId()));
        manufacturer.setName("Ford");
        manufacturer.setCountry("USA");
        System.out.println(manufacturerService.update(manufacturer));
        System.out.println(manufacturerService.delete(manufacturer.getId()));
        manufacturerService.getAll().forEach(System.out::println);

        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver("Ivan", "GJK421888");
        System.out.println(driverService.create(driver));
        System.out.println(driverService.get(driver.getId()));
        driver.setName("Petya");
        driver.setLicenseNumber("HLE789612");
        System.out.println(driverService.update(driver));
        System.out.println(driverService.delete(driver.getId()));
        driverService.getAll().forEach(System.out::println);
    }
}
