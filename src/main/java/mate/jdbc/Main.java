package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        Manufacturer firstManufacturer = new Manufacturer();
        firstManufacturer.setName("Seat");
        firstManufacturer.setCountry("Poland");
        Manufacturer secondManufacturer = new Manufacturer();
        secondManufacturer.setName("Renault");
        secondManufacturer.setCountry("France");
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        manufacturerService.create(firstManufacturer);
        System.out.println(manufacturerService.create(firstManufacturer));
        manufacturerService.create(secondManufacturer);
        Manufacturer updateManufacturer = new Manufacturer();
        updateManufacturer.setName("Daewoo");
        updateManufacturer.setCountry("Russia");
        updateManufacturer.setId(1L);
        manufacturerService.update(updateManufacturer);
        injector.getInstance(ManufacturerService.class);
        manufacturerService.getAll().forEach(System.out::println);

        Driver firstDriver = new Driver();
        firstDriver.setName("Dominic");
        firstDriver.setLicenseNumber("BC 7777 AI");
        Driver secondDriver = new Driver();
        secondDriver.setName("Ivan");
        secondDriver.setLicenseNumber("BC 6666 AI");
        Driver updateDriver = new Driver();
        updateDriver.setName("Petro");
        updateDriver.setLicenseNumber("BOSS");
        updateDriver.setId(1L);
        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);
        injector.getInstance(DriverService.class);
        driverService.create(firstDriver);
        driverService.create(secondDriver);
        injector.getInstance(DriverService.class);
        driverService.update(updateDriver);
        driverService.getAll().forEach(System.out::println);
    }
}
