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
        Manufacturer firstManufacturer = new Manufacturer("Mazda", "Japan");
        manufacturerService.create(firstManufacturer);
        Manufacturer secondManufacturer = manufacturerService.get(firstManufacturer.getId());
        secondManufacturer.setName("Mazda");
        secondManufacturer.setCountry("Japan");
        manufacturerService.update(secondManufacturer);
        manufacturerService.delete(firstManufacturer.getId());
        manufacturerService.getAll().forEach(System.out::println);
        Driver firstDriver = new Driver("Ivanov", "123453");
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        driverService.create(firstDriver);
        Driver secondDriver = driverService.get(firstDriver.getId());
        secondDriver.setName("Savin");
        secondDriver.setLicenseNumber("555555");
        driverService.update(secondDriver);
        driverService.delete(secondDriver.getId());
        driverService.getAll().forEach(System.out::println);
    }
}
