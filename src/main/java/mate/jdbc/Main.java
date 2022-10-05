package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName("Toyota");
        manufacturer.setCountry("japan");
        Manufacturer createManufacturedDb =
                manufacturerService.create(manufacturer);
        createManufacturedDb.setCountry("Japan");
        Manufacturer updateManufacturedDb =
                manufacturerService.update(createManufacturedDb);
        Manufacturer getManufacturedDb = manufacturerService
                .get(updateManufacturedDb.getId());
        System.out.println(getManufacturedDb);
        manufacturerService.delete(updateManufacturedDb.getId());
        List<Manufacturer> manufacturersList = manufacturerService.getAll();
        manufacturersList.forEach(System.out::println);

        DriverService driverService =
                (DriverService) injector.getInstance(DriverService.class);

        Driver driver = new Driver();
        driver.setName("Bob");
        driver.setLicenseNumber("12345");
        Driver createDriverDb = driverService.create(driver);
        createDriverDb.setLicenseNumber("2345");
        Driver updateDriverDb = driverService.update(createDriverDb);
        Driver getDriverDb = driverService
                .get(updateDriverDb.getId());
        System.out.println(getDriverDb);
        driverService.delete(updateDriverDb.getId());
        List<Driver> driversList = driverService.getAll();
        driversList.forEach(System.out::println);
    }
}
