package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    public static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        Driver petro = new Driver("Petro", "AX12345");
        Driver volodymyr = new Driver("Volodymyr", "BC54321");
        driverService.create(petro);
        driverService.create(volodymyr);
        driverService.getAll().forEach(System.out::println);
        System.out.println(driverService.get(volodymyr.getId()));
        Driver ashot = new Driver();
        ashot.setId(petro.getId());
        ashot.setLicenseNumber("WE53467");
        ashot.setName("Ashot");
        driverService.update(ashot);
        driverService.getAll().forEach(System.out::println);
        driverService.delete(volodymyr.getId());
        driverService.getAll().forEach(System.out::println);

        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer porscheManufacturer = new Manufacturer("Porsche", "Germany");
        Manufacturer mustangManufacturer = new Manufacturer("Mustang", "USA");
        manufacturerService.create(porscheManufacturer);
        manufacturerService.create(mustangManufacturer);
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println(manufacturerService.get(mustangManufacturer.getId()));
        Manufacturer car = new Manufacturer();
        car.setId(mustangManufacturer.getId());
        car.setCountry("Ukraine");
        car.setName("Zaporozhets");
        manufacturerService.update(car);
        manufacturerService.getAll().forEach(System.out::println);
        manufacturerService.delete(porscheManufacturer.getId());
        manufacturerService.getAll().forEach(System.out::println);
    }
}
