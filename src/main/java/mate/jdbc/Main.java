package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver firstDriver = new Driver();
        firstDriver.setName("Bob");
        firstDriver.setLicenseNumber("11111");
        driverService.create(firstDriver);
        Driver secondDriver = new Driver();
        secondDriver.setName("Alice");
        secondDriver.setLicenseNumber("22222");
        driverService.create(secondDriver);
        driverService.getAll().forEach(System.out::println);
        System.out.println(driverService.get(secondDriver.getId()));
        secondDriver.setName("Stephania");
        secondDriver.setLicenseNumber("33333");
        driverService.update(secondDriver);
        System.out.println(driverService.get(secondDriver.getId()));
        driverService.delete(firstDriver.getId());
        driverService.getAll().forEach(System.out::println);

        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        Manufacturer firstManufacturer = new Manufacturer();
        firstManufacturer.setName("audi");
        firstManufacturer.setCountry("Germany");
        manufacturerService.create(firstManufacturer);
        Manufacturer secondManufacturer = new Manufacturer();
        secondManufacturer.setName("BMV");
        secondManufacturer.setCountry("Germany");
        manufacturerService.create(secondManufacturer);
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println(manufacturerService.get(secondManufacturer.getId()));
        secondManufacturer.setName("toyota");
        secondManufacturer.setCountry("Japan");
        manufacturerService.update(secondManufacturer);
        System.out.println(manufacturerService.get(secondManufacturer.getId()));
        manufacturerService.delete(firstManufacturer.getId());
        manufacturerService.getAll().forEach(System.out::println);
    }
}
