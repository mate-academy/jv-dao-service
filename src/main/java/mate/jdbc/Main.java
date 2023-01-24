package mate.jdbc;

import java.util.List;
import mate.jdbc.dao.service.DriverService;
import mate.jdbc.dao.service.ManufacturerService;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        List<Manufacturer> manufacturers = List.of(
                new Manufacturer("Skoda", "Czech Republic"),
                new Manufacturer("Nissan", "Japan"),
                new Manufacturer("Tesla", "USA"));
        for (Manufacturer manufacturer: manufacturers) {
            manufacturerService.create(manufacturer);
        }
        Manufacturer unicManufacturer = manufacturerService.get(manufacturers.get(0).getId());
        unicManufacturer.setName("Honda");
        unicManufacturer.setCountry("IDK");
        manufacturerService.update(unicManufacturer);
        manufacturerService.delete(unicManufacturer.getId());
        manufacturerService.getAll().forEach(System.out::println);

        System.out.println(System.lineSeparator());
        //driver test
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        List<Driver> drivers = List.of(
                new Driver("Stepan", "883399112"),
                new Driver("Pachakutek", "7128374918"),
                new Driver("Mykola", "3874618748"));
        for (Driver driver: drivers) {
            driverService.create(driver);
        }
        Driver unicDriver = driverService.get(drivers.stream().findFirst().get().getId());
        unicDriver.setName("Vitaliy");
        unicDriver.setLicenseNumber("999385710");
        driverService.update(unicDriver);
        driverService.delete(unicDriver.getId());
        driverService.getAll().forEach(System.out::println);
    }
}
