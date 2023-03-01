package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturarerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        final ManufacturarerService manufacturarerService = (ManufacturarerService)
                injector.getInstance(ManufacturarerService.class);
        final DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        Driver driver = new Driver();
        final Driver updateDriver = new Driver(1L, "Bogdan", "007");
        driver.setName("Taras");
        driver.setLicenseNumber("123456");
        final Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Samsung");
        manufacturer.setCountry("South Korea");
        final Manufacturer updateManufacturer = new Manufacturer(33L, "Kia", "South Korea");
        // get all from Manufacturer
        manufacturarerService.getAll().forEach(System.out::println);
        // get by id from Manufactorer
        System.out.println(manufacturarerService.get(12L));
        // create new manufacturer in Manufactorer
        System.out.println(manufacturarerService.create(manufacturer));
        // update by id in Manufacturer
        System.out.println(manufacturarerService.update(updateManufacturer));
        // delete from Manufactorer by Id
        System.out.println("data by id " + 35L
                + " is soft deleted " + manufacturarerService.delete(35L));
        // get all from taxi_driver
        driverService.getAll().forEach(System.out::println);
        // get by id from taxi_driver
        System.out.println(driverService.get(1L));
        // create new driver in taxi_driver
        System.out.println(driverService.create(driver));
        // update by id in Driver
        System.out.println(driverService.update(updateDriver));
        // delete driver from taxi_driver
        System.out.println(driverService.delete(2L));
    }
}
