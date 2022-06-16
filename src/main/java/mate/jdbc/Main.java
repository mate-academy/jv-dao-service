package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        Driver firstDriver = new Driver();
        firstDriver.setName("Bob Jonson");
        firstDriver.setLicenseNumber("99999000");

        driverService.create(firstDriver);

        Driver secondDriver = new Driver();
        secondDriver.setName("Alice Smith");
        secondDriver.setLicenseNumber("44444477");
        driverService.create(secondDriver);

        System.out.println(driverService.get(secondDriver.getId()));
        driverService.update(firstDriver);
        driverService.delete(secondDriver.getId());
        driverService.getAll().forEach(System.out::println);

        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);

        Manufacturer firstManufacturer = new Manufacturer();
        firstManufacturer.setName("Tesla");
        firstManufacturer.setCountry("USA");

        manufacturerService.create(firstManufacturer);

        Manufacturer secondManufacturer = new Manufacturer();
        secondManufacturer.setName("Toyota");
        secondManufacturer.setCountry("Japan");

        manufacturerService.create(secondManufacturer);

        System.out.println(manufacturerService.get(secondManufacturer.getId()));
        manufacturerService.update(secondManufacturer);
        manufacturerService.delete(firstManufacturer.getId());
        manufacturerService.getAll().forEach(System.out::println);
    }
}
