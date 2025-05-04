package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        List<Driver> drivers = List.of(new Driver("Bob", "11111"),
                new Driver("Alice", "22222"),
                new Driver("Kate", "33333"));
        drivers.stream()
                .map(driverService::create)
                .forEach(System.out::println);
        Driver driver = driverService.get(drivers.get(0).getId());
        driver.setLicenseNumber("44444");
        System.out.println(driver);
        driverService.update(driver);
        System.out.println(driverService.delete(drivers.get(1).getId()));
        List<Driver> driversFromTable = driverService.getAll();
        driversFromTable.forEach(System.out::println);

        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        List<Manufacturer> manufacturers = List.of(new Manufacturer("Ford", "USA"),
                new Manufacturer("Fiat", "Italy"),
                new Manufacturer("BMW", "Germany"),
                new Manufacturer("Nissan", "Japan"));
        manufacturers.stream()
                .map(manufacturerService::create)
                .forEach(System.out::println);
        Manufacturer manufacturer = manufacturerService.get(
                manufacturers.get(0).getId());
        System.out.println(manufacturer);
        manufacturer.setName("General Motors");
        System.out.println(manufacturerService.update(manufacturer));
        System.out.println(manufacturerService.delete(manufacturer.getId()));
        manufacturerService.getAll().forEach(System.out::println);
    }
}
