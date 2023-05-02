package mate.jdbc;

import java.util.Optional;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        Driver andreyDriver = new Driver("Andrey", "1122");
        Driver sergeyDriver = new Driver("Sergey", "1133");
        Driver volodymyrDriver = new Driver("Volodymyr", "1144");

        driverService.create(andreyDriver);
        driverService.create(sergeyDriver);
        driverService.create(volodymyrDriver);

        Optional<Driver> driverFromDb = driverService.get(1L);
        driverFromDb.get().setName("Bogdan");
        driverFromDb.get().setLicenseNumber("2255");
        driverService.delete(2L);
        driverService.update(driverFromDb.get());
        driverService.getAll().forEach(System.out::println);

        ManufacturerService manufacturerService = (ManufacturerService)
                injector.getInstance(ManufacturerService.class);

        Manufacturer mercedes = new Manufacturer("Mercedes", "Germany");
        manufacturerService.create(mercedes);

        Manufacturer toyota = new Manufacturer("Toyota", "Japan");
        manufacturerService.create(toyota);

        Manufacturer hyundai = new Manufacturer("Hyundai", "Korea");
        manufacturerService.create(hyundai);

        Manufacturer manufacturerFromDb = manufacturerService.get(2L).get();

        manufacturerFromDb.setName("Audi");
        manufacturerFromDb.setCountry("Germany");
        manufacturerService.update(manufacturerFromDb);
        manufacturerService.delete(3L);

        manufacturerService.getAll().forEach(System.out::println);
    }
}

