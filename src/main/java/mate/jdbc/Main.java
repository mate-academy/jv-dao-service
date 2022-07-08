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
                .getInstance((ManufacturerService.class));

        Manufacturer firstManufacturer = new Manufacturer();
        firstManufacturer.setName("Jimmy");
        firstManufacturer.setCountry("Australia");
        Manufacturer manufacturerJimmy = manufacturerService.create(firstManufacturer);
        manufacturerService.getAll().forEach(System.out::println);
        Manufacturer secondManufacturer = new Manufacturer();
        secondManufacturer.setName("Bob");
        secondManufacturer.setCountry("Moon");
        Manufacturer manufacturerBob = manufacturerService.create(secondManufacturer);
        manufacturerService.delete(manufacturerBob.getId());
        firstManufacturer.setName("Bilbo");
        manufacturerService.update(firstManufacturer);

        DriverService driverService = (DriverService) injector
                .getInstance(DriverService.class);

        Driver firstDriver = new Driver();
        firstDriver.setName("Bibbity");
        firstDriver.setLicenseNumber("2452211");
        Driver driverBibbity = driverService.create(firstDriver);
        Driver secondDriver = new Driver();
        secondDriver.setName("Mark");
        secondDriver.setLicenseNumber("71777");
        driverService.getAll().forEach(System.out::println);
        Driver driverMark = driverService.create(secondDriver);
        driverService.delete(driverMark.getId());
        firstDriver.setName("Bilbo");
        driverService.update(firstDriver);
    }
}
