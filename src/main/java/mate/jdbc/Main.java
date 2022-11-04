package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector
                    .getInstance(DriverService.class);
        ManufacturerService manufacturerService = (ManufacturerService) injector
                    .getInstance(ManufacturerService.class);
        Driver driver = driverService
                        .create(new Driver("Daniel Morales", "113 334 587"));
        Manufacturer manufacturer = manufacturerService
                        .create(new Manufacturer("Peugeot", "France"));
        System.out.println(manufacturerService.get(manufacturer.getId()));
        System.out.println(driverService.get(driver.getId()));
        manufacturer.setName("Ford");
        manufacturer.setCountry("USA");
        driver.setName("Ken Miles");
        driver.setLicenseNumber("553 487 355");
        manufacturerService.update(manufacturer);
        driverService.update(driver);
        System.out.println(manufacturerService.getAll());
        System.out.println(driverService.getAll());
        manufacturerService.delete(manufacturer.getId());
        driverService.delete(driver.getId());
        try {
            System.out.println(manufacturerService.getAll().toString());
        } catch (RuntimeException e) {
            System.out.println("Just checking exception in manufacturerService");
        }
        try {
            System.out.println(driverService.getAll().toString());
        } catch (RuntimeException e) {
            System.out.println("Just checking exception in driverService");
        }
    }
}
