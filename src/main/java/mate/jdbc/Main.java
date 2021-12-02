package mate.jdbc;

import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService)
                injector.getInstance(DriverService.class);
        final ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);

        driverService.getAll()
                .forEach(System.out::println);
        Driver driverFromDB = driverService.get(2L);
        Driver createdDriver = driverService.create(new Driver("Bob", "3123"));
        driverFromDB.setName("updatedName");
        driverFromDB.setLicenseNumber("updatedLicense");
        Driver updateDriver = driverService.update(driverFromDB);
        boolean deleteDriver = driverService.delete(1L);

        manufacturerService.getAll()
                .forEach(System.out::println);
        Manufacturer manufacturerFromDB = manufacturerService.get(2L);
        Manufacturer createdManufacturer =
                manufacturerService.create(new Manufacturer("BMW", "Germany"));
        manufacturerFromDB.setName("Ferrari");
        manufacturerFromDB.setCountry("Italy");
        Manufacturer updateManufacturer = manufacturerService.update(manufacturerFromDB);
        boolean deleteManufacturer = manufacturerService.delete(1L);
    }
}
