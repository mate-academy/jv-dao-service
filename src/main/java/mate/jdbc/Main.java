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
        Driver driverBen = new Driver();
        driverBen.setName("Ben");
        driverBen.setLicenseNumber("12345678");
        Driver driverBob = new Driver();
        driverBob.setName("Bob");
        driverBob.setLicenseNumber("56789456");

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);
        driverService.create(driverBen);
        driverService.create(driverBob);

        List<Driver> allDrivers = driverService.getAll();
        allDrivers.stream()
                .forEach(System.out::println);

        System.out.println(driverService.get(driverBen.getId()));

        Driver updateDriverBen = new Driver(1L, "Ben", "5656565");
        driverService.update(updateDriverBen);

        driverService.delete(driverBob.getId());

        Manufacturer createManufacturerHonda = new Manufacturer();
        createManufacturerHonda.setName("Honda");
        createManufacturerHonda.setCountry("Japan");
        Manufacturer createManufacturerToyota = new Manufacturer();
        createManufacturerToyota.setName("Toyota");
        createManufacturerToyota.setCountry("Japan");

        ManufacturerService manufacturerService =
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
        manufacturerService.create(createManufacturerHonda);
        manufacturerService.create(createManufacturerToyota);

        manufacturerService.delete(createManufacturerToyota.getId());

        Manufacturer updateManufacturerToyota = new Manufacturer(createManufacturerToyota.getId(),
                "newHonda", "newJapan");
        manufacturerService.update(updateManufacturerToyota);

        List<Manufacturer> allManufacturers = manufacturerService.getAll();
        allManufacturers.stream()
                .forEach(System.out::println);
    }
}
