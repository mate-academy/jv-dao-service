package mate.jdbc;

import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static final int ID_MANUFACTURER_TO_GET = 4;
    private static final int ID_MANUFACTURER_TO_UPDATE = 4;
    private static final int ID_MANUFACTURER_TO_DELETE = 5;
    private static final int ID_DRIVER_TO_GET = 4;
    private static final int ID_DRIVER_TO_UPDATE = 3;
    private static final int ID_DRIVER_TO_DELETE = 6;
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        List<Manufacturer> manufacturers = List.of(
                new Manufacturer("Dodge", "USA"),
                new Manufacturer("Renault", "France"),
                new Manufacturer("Peugeot", "France"),
                new Manufacturer("BMW", "Germany"),
                new Manufacturer("Mercedes", "Germany"),
                new Manufacturer("Hyundai", "Korea"),
                new Manufacturer("Subaru", "Japan")
        );
        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);

        System.out.println("Manufacturers data will be displayed");
        
        manufacturers.forEach(manufacturerService::create);
        Manufacturer manufacturerToGet = manufacturerService
                .get(manufacturers.get(ID_MANUFACTURER_TO_GET)
                .getId());
        System.out.println(manufacturerService.get(manufacturerToGet.getId()));
        Manufacturer manufacturerToUpdate = manufacturerService
                .get(manufacturers.get(ID_MANUFACTURER_TO_UPDATE)
                .getId());
        manufacturerToUpdate.setName("Volvo");
        manufacturerToUpdate.setName("Sweden");
        System.out.println(manufacturerService.update(manufacturerToUpdate));
        Manufacturer manufacturerToDelete =
                manufacturerService.get(manufacturers.get(ID_MANUFACTURER_TO_DELETE)
                        .getId());
        manufacturerService.delete(manufacturerToDelete.getId());
        manufacturerService.getAll().forEach(System.out::println);

        List<Driver> drivers = List.of(
                new Driver("Alex", "Ukraine"),
                new Driver("Scott", "Poland"),
                new Driver("Shamil", "Iraq"),
                new Driver("Jezz", "England"),
                new Driver("Anna", "Korea"),
                new Driver("Mary", "Germany"),
                new Driver("Dori", "Spain")
        );
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);

        System.out.println("Drivers data will be displayed");

        drivers.forEach(driverService::create);
        Driver driverToGet = driverService.get(drivers.get(ID_DRIVER_TO_GET).getId());
        System.out.println(driverService.get(driverToGet.getId()));
        Driver driverToUpdate = driverService.get(drivers.get(ID_DRIVER_TO_UPDATE).getId());
        driverToUpdate.setName("Boris");
        driverToUpdate.setLicenseNumber("Slovakia");
        System.out.println(driverService.update(driverToUpdate));
        Driver driverToDelete = driverService.get(drivers.get(ID_DRIVER_TO_DELETE).getId());
        driverService.delete(driverToDelete.getId());
        driverService.getAll().forEach(System.out::println);
    }
}
