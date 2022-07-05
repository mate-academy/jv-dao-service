package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Siat");
        manufacturer.setCountry("Ital");
        System.out.println("Create manufacturer " + manufacturerService.create(manufacturer));
        manufacturer.setName("Fiat");
        manufacturer.setCountry("Italy");
        manufacturer = manufacturerService.update(manufacturer);
        System.out.println("Update new manufacturer" + manufacturer);

        System.out.println("Get All manufacturers" + System.lineSeparator());
        manufacturerService.getAll().stream().forEach(System.out::println);

        System.out.println(manufacturerService.get(manufacturer.getId()));

        manufacturerService.delete(manufacturer.getId());
        System.out.println("Delete manufacturer by id " + manufacturer.getId()
                + System.lineSeparator() + manufacturerService.getAll());

        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        Driver driver = new Driver();
        driver.setName("Romin");
        driver.setLicenseNumber("123456");

        System.out.println("Create driver " + driverService.create(driver));
        driver.setName("Roman");
        driver.setLicenseNumber("55555");
        driver = driverService.update(driver);
        System.out.println("Update new driver" + driver);

        System.out.println("Get All drivers" + System.lineSeparator());
        driverService.getAll().stream().forEach(System.out::println);

        System.out.println(driverService.get(driver.getId()));

        driverService.delete(driver.getId());
        System.out.println("Delete manufacturer by id " + driver.getId()
                + System.lineSeparator() + driverService.getAll());
    }
}
