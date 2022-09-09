package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        final ManufacturerService manufacturerService = (ManufacturerService) injector
                .getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer();

        System.out.println("Create: ");
        manufacturer.setName("Mercedes-Benz");
        manufacturer.setCountry("Germany");
        Manufacturer mercedes = manufacturerService.create(manufacturer);
        System.out.println(mercedes);

        System.out.println("Get manufacturer: ");
        Manufacturer getManufacturer = manufacturerService.get(mercedes.getId());
        System.out.println(getManufacturer);

        System.out.println("Get all manufacturers: ");
        System.out.println(manufacturerService.getAll());

        System.out.println("Update manufacturer: ");
        manufacturer.setName("Pontiac");
        System.out.println(manufacturerService.update(manufacturer));

        System.out.println("Delete manufacturer: ");
        boolean deleteManufacturer = manufacturerService.delete(manufacturer.getId());
        System.out.println(deleteManufacturer);

        final DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);
        Driver driver = new Driver();

        System.out.println("Create: ");
        driver.setName("Tom");
        driver.setLicenseNumber("111111");
        Driver tom = driverService.create(driver);
        System.out.println(tom);

        System.out.println("Get driver: ");
        Driver getDriver = driverService.get(tom.getId());
        System.out.println(getDriver);

        System.out.println("Get all drivers: ");
        System.out.println(driverService.getAll());

        System.out.println("Update drivers: ");
        manufacturer.setName("Alice");
        System.out.println(driverService.update(driver));

        System.out.println("Delete driver: ");
        boolean deleteDriver = driverService.delete(driver.getId());
        System.out.println(deleteDriver);
    }
}
