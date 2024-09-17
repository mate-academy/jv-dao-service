package mate.jdbc;

import java.util.Arrays;
import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);
        List<Manufacturer> manufacturers = Arrays.asList(
                new Manufacturer("Toyota", "Japan"),
                new Manufacturer("Subaru", "Japan"),
                new Manufacturer("Volkswagen", "Germany"),
                new Manufacturer("Audi", "Germany"),
                new Manufacturer("Tesla", "USA"),
                new Manufacturer("Ford", "USA"),
                new Manufacturer("RENAULT", "FRANCE"),
                new Manufacturer("RENAULT", "FRANCE")
        );
        manufacturers.forEach(manufacturerService::create);
        List<Manufacturer> manufacturersFromDb = manufacturerService.getAll();
        manufacturersFromDb.forEach(System.out::println);
        Manufacturer manufacturerToUpdate = manufacturerService.get(7L);
        manufacturerToUpdate.setName("FIAT");
        manufacturerToUpdate.setCountry("ITALY");
        manufacturerService.update(manufacturerToUpdate);
        manufacturerService.delete(8L);
        manufacturersFromDb = manufacturerService.getAll();
        manufacturersFromDb.forEach(System.out::println);
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        List<Driver> drivers = Arrays.asList(
                new Driver("Bob", "0001"),
                new Driver("John", "0002"),
                new Driver("Mat", "0003"),
                new Driver("Drew", "0004"),
                new Driver("Mike", "0005"),
                new Driver("Elon", "0006"),
                new Driver("Peter", "0007"),
                new Driver("Bob", "0008")
        );
        drivers.forEach(driverService::create);
        List<Driver> driversFromDb = driverService.getAll();
        driversFromDb.forEach(System.out::println);
        Driver driverToUpdate = driverService.get(7L);
        driverToUpdate.setName("Cobey");
        driverToUpdate.setLicenseNumber("0009");
        driverService.update(driverToUpdate);
        driverService.delete(8L);
        driversFromDb = driverService.getAll();
        driversFromDb.forEach(System.out::println);
    }

}
