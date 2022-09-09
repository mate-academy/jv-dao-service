package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        final ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer manufacturer = new Manufacturer();
        System.out.println("------create manufacturer------");
        manufacturer.setName("Skoda");
        manufacturer.setCountry("Czech");
        System.out.println(manufacturerService.create(manufacturer) + System.lineSeparator());

        System.out.println("------get manufacturer------");
        System.out.println(manufacturerService.get(manufacturer.getId()) + System.lineSeparator());

        System.out.println("------update manufacturer------");
        manufacturer.setName("Mercedes");
        manufacturer.setCountry("Germany");
        System.out.println(manufacturerService.update(manufacturer) + System.lineSeparator());

        System.out.println("------delete manufacturer-----");
        System.out.println(manufacturerService.delete(manufacturer.getId())
                + System.lineSeparator());

        System.out.println("------getAll manufacturers------");
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println();

        final DriverService driverService
                = (DriverService) injector.getInstance(DriverService.class);
        Driver driver = new Driver();
        System.out.println("------create driver------");
        driver.setName("Vasya");
        driver.setLicenseNumber("12345");
        System.out.println(driverService.create(driver) + System.lineSeparator());

        System.out.println("------get driver------");
        System.out.println(driverService.get(driver.getId()) + System.lineSeparator());

        System.out.println("------update driver------");
        driver.setName("Petya");
        driver.setLicenseNumber("56789");
        System.out.println(driverService.update(driver) + System.lineSeparator());

        System.out.println("------delete driver-----");
        System.out.println(driverService.delete(driver.getId()) + System.lineSeparator());

        System.out.println("------getAll drivers------");
        driverService.getAll().forEach(System.out::println);
    }
}
