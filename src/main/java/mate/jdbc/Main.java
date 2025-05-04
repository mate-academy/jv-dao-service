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
        firstDriver.setName("Jim Root");
        firstDriver.setLicenseNumber("1381428");

        driverService.create(firstDriver);

        Driver secondDriver = new Driver();
        secondDriver.setName("Michael Myers");
        secondDriver.setLicenseNumber("31101973");
        driverService.create(secondDriver);

        System.out.println(driverService.get(secondDriver.getId()));
        driverService.update(firstDriver);
        driverService.delete(secondDriver.getId());
        driverService.getAll().forEach(System.out::println);

        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);

        Manufacturer firstManufacturer = new Manufacturer();
        firstManufacturer.setName("Ford");
        firstManufacturer.setCountry("USA");

        manufacturerService.create(firstManufacturer);

        Manufacturer secondManufacturer = new Manufacturer();
        secondManufacturer.setName("Honda");
        secondManufacturer.setCountry("Japan");

        manufacturerService.create(secondManufacturer);

        System.out.println(manufacturerService.get(secondManufacturer.getId()));
        manufacturerService.update(secondManufacturer);
        manufacturerService.delete(firstManufacturer.getId());
        manufacturerService.getAll().forEach(System.out::println);
    }
}


