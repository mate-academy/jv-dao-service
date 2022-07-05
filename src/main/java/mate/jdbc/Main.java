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
        firstManufacturer.setName("First manufacturer");
        firstManufacturer.setCountry("Ukraine");
        Manufacturer secondManufacturer = new Manufacturer();
        secondManufacturer.setName("Second manufacturer");
        secondManufacturer.setCountry("Ukraine");
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        manufacturerService.create(firstManufacturer);
        manufacturerService.create(secondManufacturer);
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println(manufacturerService.get(firstManufacturer.getId()));
        firstManufacturer.setCountry("USA");
        manufacturerService.update(firstManufacturer);
        manufacturerService.delete(secondManufacturer.getId());
        manufacturerService.getAll().forEach(System.out::println);
        Driver firstDriver = new Driver();
        firstDriver.setName("First driver");
        firstDriver.setLicenseNumber("123");
        Driver secondDriver = new Driver();
        secondDriver.setName("Second Driver");
        secondDriver.setLicenseNumber("123");
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        driverService.create(firstDriver);
        driverService.create(secondDriver);
        driverService.getAll().forEach(System.out::println);
        System.out.println(driverService.get(firstDriver.getId()));
        firstDriver.setLicenseNumber("1234");
        driverService.update(firstDriver);
        driverService.delete(secondDriver.getId());
        driverService.getAll().forEach(System.out::println);
    }
}
