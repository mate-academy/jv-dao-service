package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final String PACKAGE_NAME = "mate.jdbc";

    public static void main(String[] args) {
        Injector injector = Injector.getInstance(PACKAGE_NAME);
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);

        Manufacturer tesla = new Manufacturer("Tesla", "USA");
        Manufacturer zaporozhets = new Manufacturer("Zaporozhets", "Ukraine");

        manufacturerService.create(tesla);
        manufacturerService.create(zaporozhets);
        manufacturerService.getAll().forEach(System.out::println);

        tesla.setCountry("Ukraine");
        manufacturerService.update(tesla);
        System.out.println(manufacturerService.get(tesla.getId()));

        manufacturerService.delete(zaporozhets.getId());
        manufacturerService.getAll().forEach(System.out::println);

        Driver joe = new Driver("Joe", "AS444");
        Driver marry = new Driver("Marry", "RG843");

        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);

        driverService.create(joe);
        driverService.create(marry);
        driverService.getAll().forEach(System.out::println);

        marry.setLicenseNumber("DK0332");
        driverService.update(marry);
        System.out.println(driverService.get(marry.getId()));

        driverService.delete(joe.getId());
        driverService.getAll().forEach(System.out::println);
    }
}
