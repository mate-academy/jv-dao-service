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
        System.out.println(driverService.get(2L));
        Driver ivan = new Driver();
        ivan.setId(1L);
        ivan.setLicenseNumber("WE53467");
        ivan.setName("Ivan");
        driverService.update(ivan);
        driverService.getAll().forEach(System.out::println);
        driverService.delete(2L);
        driverService.getAll().forEach(System.out::println);

        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        Manufacturer porscheManufacturer = new Manufacturer("Porsche", "Germany");
        Manufacturer mustangManufacturer = new Manufacturer("Mustang", "USA");
        manufacturerService.create(porscheManufacturer);
        manufacturerService.create(mustangManufacturer);
        manufacturerService.getAll().forEach(System.out::println);
        System.out.println(manufacturerService.get(1L));
        Manufacturer car = new Manufacturer();
        car.setId(19L);
        car.setCountry("Ukraine");
        car.setName("Zaporozhets");
        manufacturerService.update(car);
        manufacturerService.getAll().forEach(System.out::println);
        manufacturerService.delete(19L);
        manufacturerService.getAll().forEach(System.out::println);

    }
}
